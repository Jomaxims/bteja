package cz.upce.bteja

import io.github.oshai.kotlinlogging.KotlinLogging
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.RuleNode
import java.util.*

data class OberonError(val message: String, val context: ParserRuleContext?) {
    override fun toString(): String {
        return "Chyba na řádku ${context?.start?.line}: $message"
    }
}

class SemanticVisitor : OberonBaseVisitor<Value>() {
    private val programContext = ProgramContext()
    private val contexts = Stack<ExecutionContext>()
    private val logger = KotlinLogging.logger { }

    val errors = mutableListOf<OberonError>()
    val isValid get() = errors.isEmpty()

    private val currentContext get() = contexts.peek()!!

    init {
        addDefaultProcedures()
    }

    private fun ParseTree.visit(): Value? = visit(this)
    private fun RuleNode.visitChildren(): Value? = visitChildren(this)

    private fun enterNewContext(isProcedure: Boolean = false) = contexts.push(ExecutionContext(
        currentContext,
        isProcedure
    ))
    private fun exitCurrentContext() = contexts.pop()

    private fun addDefaultProcedures() {
        programContext.libraryProcedures += LibraryProcedures.procedures
    }

    override fun visitModule(ctx: OberonParser.ModuleContext): Value? {
        contexts.push(ExecutionContext(null))

        ctx.visitChildren()

        return null
    }

    override fun visitType(ctx: OberonParser.TypeContext): Value? {
        var typeName = ""
        var arrayType: DataType? = null

        ctx.ident()?.let {
            typeName = it.text
        }
        ctx.arrayType()?.let {
            typeName = it.ident().text
            arrayType = DataType.ARRAY
        }
        ctx.matrixType()?.let {
            typeName = it.ident().text
            arrayType = DataType.MATRIX
        }

        if (DataType.parse(typeName) !in DataType.primitiveTypes) {
            errors.add(OberonError("Neplatný typ \"$typeName\"", ctx))

            return null
        }

        return when(arrayType) {
            DataType.ARRAY -> ArrayValue.getTypedEmpty(0, DataType.parse(typeName))
            DataType.MATRIX -> MatrixValue.getTypedEmpty(0, 0, DataType.parse(typeName))
            else -> PrimitiveValue.getTypedEmpty(DataType.parse(typeName))
        }
    }

    override fun visitConstDeclaration(ctx: OberonParser.ConstDeclarationContext): Value? {
        val constName = ctx.ident().text
        if (currentContext.variables.contains(constName)) {
            errors.add(OberonError("Konstanta/proměnná \"$constName\" již existuje", ctx))

            return null
        }
        val value = ctx.simpleExpression().visit() ?: PrimitiveValue.Empty

        currentContext.variables[constName] = Variable(value, true)

        logger.debug { "Vytvořena konstanta \"$constName\": $value" }

        return null
    }

    override fun visitVariableDeclaration(ctx: OberonParser.VariableDeclarationContext): Value? {
        val value = ctx.type().visit() ?: PrimitiveValue.Empty

        ctx.identList().ident().forEach {
            val varName = it.text
            if (currentContext.variables.contains(varName)) {
                errors.add(OberonError("Konstanta/proměnná \"$varName\" již existuje", ctx))

                return@forEach
            }

            currentContext.variables[varName] = Variable(value, false)

            logger.debug { "Vytvořena proměnná \"$varName\": $value" }
        }

        return null
    }

    override fun visitDesignator(ctx: OberonParser.DesignatorContext): Value? {
        val varName = ctx.ident().text
        val variable = currentContext.getVariable(varName)

        if (variable == null) {
            errors.add(OberonError("Konstanta/proměnná \"$varName\" neexistuje", ctx))

            return null
        }
        if (variable.value.type == DataType.ARRAY && ctx.expression().size == 1) {
            return PrimitiveValue.getTypedEmpty(variable.value.asArray<Any>().ofType)
        }
        if (variable.value.type == DataType.MATRIX && ctx.expression().size == 2) {
            return PrimitiveValue.getTypedEmpty(variable.value.asMatrix<Any>().ofType)
        }

        return variable.value
    }

    override fun visitAssignment(ctx: OberonParser.AssignmentContext): Value? {
        if (ctx.designator().visit() == null)
            return null

        val varName = ctx.designator().ident().text
        val variable = currentContext.getVariable(varName)!!

        if (variable.isConstant) {
            errors.add(OberonError("Konstantu \"$varName\" nelze přepsat", ctx))

            return null
        }
        if (variable.value.type == DataType.ARRAY && ctx.designator().expression().size != 1) {
            errors.add(OberonError("Neplatný počet dimenzí pro pole \"$varName\"", ctx))

            return null
        }
        if (variable.value.type == DataType.MATRIX && ctx.designator().expression().size != 2) {
            errors.add(OberonError("Neplatný počet dimenzí pro matici \"$varName\"", ctx))

            return null
        }

        val expressionValue = ctx.expression().visit()
        expressionValue?.let {
            if (variable.value.type == DataType.ARRAY && variable.value.asArray<Any>().ofType == it.type) {
                return null
            }
            if (variable.value.type == DataType.MATRIX && variable.value.asMatrix<Any>().ofType == it.type) {
                return null
            }
        }
        if (!variable.value.areOfSameType(expressionValue)) {
            errors.add(OberonError("Neplatná hodnota pro proměnnou \"$varName\" typu ${variable.value.type}", ctx))

            return null
        }

        return null
    }

    override fun visitExpression(ctx: OberonParser.ExpressionContext): Value? {
        ctx.STRING()?.let {
            return PrimitiveValue.getTypedEmpty(DataType.STRING)
        }

        return ctx.simpleExpression().visit()
    }

    override fun visitBoolExpression(ctx: OberonParser.BoolExpressionContext): Value? {
        val left = ctx.left.visit()

        ctx.right.visit()?.let { right ->
            if (right.areOfSameType(left))
                return right

            errors.add(OberonError("Neplatné porovnání typů ${left?.type} a ${right.type}", ctx))
        }

        return null
    }

    override fun visitSimpleExpression(ctx: OberonParser.SimpleExpressionContext): Value? {
        val first = ctx.term(0).visit() ?: return null

        ctx.term().forEach {
            if (!first.areOfSameType(it.visit()))
                return null
        }

        return first
    }

    override fun visitTerm(ctx: OberonParser.TermContext): Value? {
        val first = ctx.factor(0).visit() ?: return null

        ctx.factor().forEach {
            if (!first.areOfSameType(it.visit()))
                return null
        }

        return first
    }

    override fun visitFactor(ctx: OberonParser.FactorContext): Value? {
        ctx.INTEGER()?.let {
            return PrimitiveValue.getTypedEmpty(DataType.INTEGER)
        }
        ctx.REAL()?.let {
            return PrimitiveValue.getTypedEmpty(DataType.REAL)
        }
        ctx.expression()?.let {
            return it.visit()
        }
        ctx.designator()?.let {
            return it.visit()
        }
        ctx.procedureCall()?.let {
            return it.visit()
        }

        return null
    }

    override fun visitProcedureCall(ctx: OberonParser.ProcedureCallContext): Value? {
        val procedureName = ctx.ident().text
        val callParameters = Array(ctx.actualParameters().expList()?.expression()?.size ?: 0) { i ->
            ctx.actualParameters().expList().expression(i).visit()
        }

        programContext.libraryProcedures[procedureName]?.let {
            if (it.parameters == null)
                return it.returnValue

            if (it.parameters.size != callParameters.size) {
                errors.add(OberonError("Neplatný počet parametrů pro proceduru \"$procedureName\"", ctx))

                return null
            }

            if (!it.parameters.areOfSameTypes(callParameters)) {
                errors.add(OberonError("Neplatné typy parametrů pro proceduru \"$procedureName\"", ctx))

                return null
            }

            return it.returnValue
        }
        programContext.procedures[procedureName]?.let {
            val parameters = it.procedureHeading().procedureParameters().fPSection().map { it.type().visit() }.toTypedArray()

            if (parameters.size != callParameters.size) {
                errors.add(OberonError("Neplatný počet parametrů pro proceduru \"$procedureName\"", ctx))

                return null
            }

            if (!parameters.areOfSameTypes(callParameters)) {
                errors.add(OberonError("Neplatné typy parametrů pro proceduru \"$procedureName\"", ctx))

                return null
            }

            return it.procedureHeading().procedureParameters().type()?.visit()
        }

        errors.add(OberonError("Procedura \"$procedureName\" neexistuje", ctx))

        return null
    }

    override fun visitProcedureDeclaration(ctx: OberonParser.ProcedureDeclarationContext): Value? {
        val procedureName = ctx.procedureHeading().ident().text

        programContext.procedures[procedureName] = ctx

        enterNewContext(true)

        ctx.procedureHeading().procedureParameters().fPSection().forEach {
            val name = it.ident().text
            val value = it.type().visit() ?: PrimitiveValue.Empty
            currentContext.variables[name] = Variable(value, true)
        }

        val procedureValue: Value? = ctx.procedureBody().visit()

        exitCurrentContext()

        val returnValue = ctx.procedureHeading().procedureParameters()?.type()?.visit()

        if ((returnValue == null && procedureValue != null) || (procedureValue == null && returnValue != null)) {
            errors.add(OberonError("Neplatná hodnota pro proceduru \"$procedureName\" s návratovým typem ${returnValue?.type}", ctx))

            return null
        }
        if (returnValue == null) {
            return null
        }
        if (!returnValue.areOfSameType(procedureValue)) {
            errors.add(OberonError("Neplatná návratová hodnota pro \"$procedureName\" s návratovým typem ${returnValue.type}", ctx))
        }

        return null
    }

    override fun visitProcedureBody(ctx: OberonParser.ProcedureBodyContext): Value? {
        ctx.declarationSequence().visit()

        try {
            ctx.statementSequence().statement().forEach {
                it.visit()
            }
        } catch (e: ProcedureReturnedException) {
            return e.value
        }

        return null
    }

    override fun visitReturnStatement(ctx: OberonParser.ReturnStatementContext): Value? {
        if (!currentContext.isProcedure) {
            errors.add(OberonError("RETURN mimo proceduru", ctx))

            return null
        }

        val value = ctx.visitChildren()

        throw ProcedureReturnedException(value)
    }

    override fun visitForStatement(ctx: OberonParser.ForStatementContext): Value? {
        enterNewContext()

        val counterName = ctx.ident().text
        val counterValue = ctx.counterExpression.visit() ?: PrimitiveValue.Empty
        currentContext.variables[counterName] = Variable(counterValue, true)

        val toValue = ctx.toExpression.visit()
        val byValue = ctx.byExpression?.visit()

        if (counterValue.type != DataType.INTEGER) {
            errors.add(OberonError("FOR iteruje pouze po INTEGER", ctx))
        }
        if (toValue == null || toValue.type != DataType.INTEGER) {
            errors.add(OberonError("FOR iteruje pouze po INTEGER", ctx))
        }
        if (byValue != null && byValue.type != DataType.INTEGER) {
            errors.add(OberonError("FOR iteruje pouze po INTEGER", ctx))
        }

        ctx.visitChildren()

        exitCurrentContext()

        return null
    }
}