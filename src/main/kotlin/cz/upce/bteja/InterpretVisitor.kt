package cz.upce.bteja

import io.github.oshai.kotlinlogging.KotlinLogging
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.RuleNode
import java.util.*

class InterpretVisitor : OberonBaseVisitor<Value>() {
    private val programContext = ProgramContext()
    private val contexts = Stack<ExecutionContext>()
    private val logger = KotlinLogging.logger { }

    private val currentContext get() = contexts.peek()!!

    init {
        addDefaultProcedures()
    }

    private fun ParseTree.visit() = visit(this)
    private fun RuleNode.visitChildren() = visitChildren(this)

    private fun enterNewContext() = contexts.push(ExecutionContext(programContext, currentContext))
    private fun exitCurrentContext() = contexts.pop()

    private fun addDefaultProcedures() {
        programContext.libraryProcedures += LibraryProcedures.procedures
    }

    override fun visitModule(ctx: OberonParser.ModuleContext): Value? {
        contexts.push(ExecutionContext(programContext, null))

        ctx.visitChildren()

        return null
    }

    override fun visitProcedureDeclaration(ctx: OberonParser.ProcedureDeclarationContext): Value? {
        val name = ctx.procedureHeading().ident().text

        programContext.procedures[name] = ctx

        return null
    }

    override fun visitProcedureCall(ctx: OberonParser.ProcedureCallContext): Value? {
        val callName = ctx.ident().text
        val callParameters = Array(ctx.actualParameters().expList()?.expression()?.size ?: 0) { i ->
            ctx.actualParameters().expList().expression(i).visit()
        }

        try {
            programContext.libraryProcedures[callName]?.let {
                return it.run(*callParameters)
            }
        } catch (e: OberonException) {
            throw e.apply { e.context = ctx }
        }

        val procedureContext = programContext.procedures[callName]
        if (procedureContext == null) {
            logger.error { "Procedura \"$callName\" neexistuje" }
            throw NonExistentProcedureException("Procedura \"$callName\" neexistuje", ctx)
        }

        val procedureParameters = procedureContext.procedureHeading().procedureParameters()
        if (procedureParameters.fPSection().size != callParameters.size) {
            logger.error { "Procedura \"$callName\" má ${procedureParameters.fPSection().size} parametrů" }
            throw WrongNumberOfParametersException("Procedura \"$callName\" má ${procedureParameters.fPSection().size} parametrů", ctx)
        }

        enterNewContext()

        callParameters.forEachIndexed { i, value ->
            val name = procedureContext.procedureHeading().procedureParameters().fPSection(i).ident().text
            currentContext.variables[name] = Variable(value, true)
        }

        val procedureValue: Value? = procedureContext.procedureBody().visit()

        exitCurrentContext()

        return procedureValue
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
        val value = ctx.visitChildren()

        throw ProcedureReturnedException(value)
    }

    override fun visitConstDeclaration(ctx: OberonParser.ConstDeclarationContext): Value? {
        val constName = ctx.ident().text
        val value = ctx.simpleExpression().visit()

        currentContext.variables[constName] = Variable(value, true)

        logger.debug { "Vytvořena konstanta \"$constName\": $value" }

        return null
    }

    override fun visitVariableDeclaration(ctx: OberonParser.VariableDeclarationContext): Value? {
        var type: DataType = DataType.ANY
        var subType: DataType? = null
        ctx.type().ident()?.let {
            type = DataType.parse(it.text)
        }
        ctx.type().arrayType()?.let {
            type = DataType.ARRAY
            subType = DataType.parse(it.ident().text)
        }
        ctx.type().matrixType()?.let {
            type = DataType.MATRIX
            subType = DataType.parse(it.ident().text)
        }

        if (subType == null) {
            ctx.identList().ident().forEach {
                currentContext.variables[it.text] = Variable(PrimitiveValue.getTypedEmpty(type), false).apply {
                    logger.debug { "Vytvořena proměnná \"${it.text}\": $this" }
                }
            }
        } else if (type == DataType.ARRAY) {
            val size = ctx.type().arrayType().length().visit().asPrimitive<Int>().value
            ctx.identList().ident().forEach {
                currentContext.variables[it.text] = Variable(ArrayValue.getTypedEmpty(size, subType!!), false).apply {
                    isInitialized = true
                    logger.debug { "Vytvořena proměnná \"${it.text}\": $this" }
                }
            }
        } else if (type == DataType.MATRIX) {
            val sizeX = ctx.type().matrixType().length(0).visit().asPrimitive<Int>().value
            val sizeY = ctx.type().matrixType().length(1).visit().asPrimitive<Int>().value
            ctx.identList().ident().forEach {
                currentContext.variables[it.text] =
                    Variable(MatrixValue.getTypedEmpty(sizeX, sizeY, subType!!), false).apply {
                        isInitialized = true
                        logger.debug { "Vytvořena proměnná \"${it.text}\": $this" }
                    }
            }
        }

        return null
    }

    override fun visitAssignment(ctx: OberonParser.AssignmentContext): Value? {
        val name = ctx.designator().ident().text
        val variable = currentContext.getVariable(name)

        if (variable == null) {
            logger.error { "Proměnná \"$name\" neexistuje" }
            throw NonExistentVariableException("Proměnná \"$name\" neexistuje", ctx)
        }
        if (variable.isConstant) {
            logger.error { "\"$name\" je konstanta" }
            throw AssignmentToConstantException("\"$name\" je konstanta", ctx)
        }

        val value = ctx.expression().visit()
        val variableType = variable.value.type
        when (variableType) {
            DataType.ARRAY -> {
                if (ctx.designator().expression().size != 1) {
                    logger.error { "Chybný počet dimenzí pro \"$name\"" }
                    throw InvalidDimensionsException("Chybný počet dimenzí pro \"$name\"", ctx)
                }
                val index = ctx.designator().expression(0).visit().asPrimitive<Int>().value

                variable.value.asArray<Any>().value[index] = value.asPrimitive()
            }

            DataType.MATRIX -> {
                if (ctx.designator().expression().size != 2) {
                    logger.error { "Chybný počet dimenzí pro \"$name\"" }
                    throw InvalidDimensionsException("Chybný počet dimenzí pro \"$name\"", ctx)
                }
                val indexX = ctx.designator().expression(0).visit().asPrimitive<Int>().value
                val indexY = ctx.designator().expression(1).visit().asPrimitive<Int>().value

                variable.value.asMatrix<Any>().value[indexX][indexY] = value.asPrimitive()
            }

            else -> {
                variable.setNewValue(value)
            }
        }

        return null
    }

    override fun visitDesignator(ctx: OberonParser.DesignatorContext): Value {
        val name = ctx.ident().text
        val variable = currentContext.getVariable(name)

        if (variable == null) {
            logger.error { "Proměnná/konstanta \"$name\" neexistuje" }
            throw NonExistentVariableException("Proměnná/konstanta \"$name\" neexistuje", ctx)
        }
        if (!variable.isInitialized) {
            logger.error { "Proměnná \"$name\" není inicializovaná" }
            throw VariableNotInitializedException("Proměnná \"$name\" není inicializovaná", ctx)
        }

        val variableType = variable.value.type
        when (variableType) {
            DataType.ARRAY -> {
                if (ctx.expression().size == 0) {
                    return variable.value
                }

                if (ctx.expression().size != 1) {
                    logger.error { "Chybný počet dimenzí pro \"$name\"" }
                    throw InvalidDimensionsException("Chybný počet dimenzí pro \"$name\"", ctx)
                }
                val index = ctx.expression(0).visit().asPrimitive<Int>().value
                return variable.value.asArray<Any>().value[index]
            }

            DataType.MATRIX -> {
                if (ctx.expression().size == 0) {
                    return variable.value
                }

                if (ctx.expression().size != 2) {
                    logger.error { "Chybný počet dimenzí pro \"$name\"" }
                    throw InvalidDimensionsException("Chybný počet dimenzí pro \"$name\"", ctx)
                }
                val indexX = ctx.expression(0).visit().asPrimitive<Int>().value
                val indexY = ctx.expression(1).visit().asPrimitive<Int>().value

                return variable.value.asMatrix<Any>().value[indexX][indexY]
            }

            else -> {
                return variable.value
            }
        }
    }

    override fun visitExpression(ctx: OberonParser.ExpressionContext): Value {
        ctx.STRING()?.let {
            return it.toStringValue()
        }

        return ctx.visitChildren()
    }

    override fun visitSimpleExpression(ctx: OberonParser.SimpleExpressionContext): Value {
        val first = visit(ctx.term(0))

        logger.debug { "Expression: ${ctx.text}" }
        when (first.type) {
            DataType.INTEGER -> {
                var value = first.asPrimitive<Int>().value
                ctx.addOperator().forEachIndexed { i, addOperatorCtx ->
                    if (addOperatorCtx.PLUS() != null) {
                        value += visit(ctx.term(i + 1)).asPrimitive<Int>().value
                    } else if (addOperatorCtx.MINUS() != null) {
                        value -= visit(ctx.term(i + 1)).asPrimitive<Int>().value
                    }
                }

                ctx.MINUS()?.let {
                    value = -value
                }

                return PrimitiveValue(value, DataType.INTEGER)
            }

            DataType.REAL -> {
                var value = first.asPrimitive<Double>().value
                ctx.addOperator().forEachIndexed { i, addOperatorCtx ->
                    if (addOperatorCtx.PLUS() != null) {
                        value += visit(ctx.term(i + 1)).asPrimitive<Double>().value
                    } else if (addOperatorCtx.MINUS() != null) {
                        value -= visit(ctx.term(i + 1)).asPrimitive<Double>().value
                    }
                }

                ctx.MINUS()?.let {
                    value = -value
                }

                return PrimitiveValue(value, DataType.REAL)
            }

            else -> return first
        }
    }

    override fun visitTerm(ctx: OberonParser.TermContext): Value {
        val first = visit(ctx.factor(0))

        when (first.type) {
            DataType.INTEGER -> {
                var value = first.asPrimitive<Int>().value
                ctx.mulOperator().forEachIndexed { i, mulOperatorCtx ->
                    if (mulOperatorCtx.MULT() != null) {
                        value *= ctx.factor(i + 1).visit().asPrimitive<Int>().value
                    } else if (mulOperatorCtx.DIV() != null) {
                        value /= ctx.factor(i + 1).visit().asPrimitive<Int>().value
                    } else if (mulOperatorCtx.MOD() != null) {
                        value = value.mod(ctx.factor(i + 1).visit().asPrimitive<Int>().value)
                    }
                }

                return PrimitiveValue(value, DataType.INTEGER)
            }

            DataType.REAL -> {
                var value = first.asPrimitive<Double>().value
                ctx.mulOperator().forEachIndexed { i, mulOperatorCtx ->
                    if (mulOperatorCtx.MULT() != null) {
                        value *= ctx.factor(i + 1).visit().asPrimitive<Double>().value
                    } else if (mulOperatorCtx.DIV() != null) {
                        value /= ctx.factor(i + 1).visit().asPrimitive<Double>().value
                    }
                }

                return PrimitiveValue(value, DataType.REAL)
            }

            else -> return first
        }
    }

    override fun visitFactor(ctx: OberonParser.FactorContext): Value? {
        ctx.INTEGER()?.let {
            return it.toIntValue()
        }
        ctx.REAL()?.let {
            return it.toRealValue()
        }
        ctx.expression()?.let {
            return visit(it)
        }
        ctx.designator()?.let {
            return visit(it)
        }
        ctx.procedureCall()?.let {
            return visit(it)
        }

        return null
    }

    override fun visitIfStatement(ctx: OberonParser.IfStatementContext): Value? {
        var visited = false

        ctx.boolExpression().forEachIndexed { i, boolExpressionContext ->
            val left = boolExpressionContext.left.visit() as PrimitiveValue<*>
            val right = boolExpressionContext.right.visit() as PrimitiveValue<*>
            val operator = boolExpressionContext.relation().text

            val compared = compareValuesBy(left, right) {
                it.value as Comparable<*>
            }
            val result = when (operator) {
                "=" -> compared == 0
                "<" -> compared < 0
                "<=" -> compared <= 0
                ">" -> compared > 0
                ">=" -> compared >= 0
                else -> throw IllegalRelationException()
            }

            if (result) {
                ctx.statementSequence(i).visitChildren()
                visited = true
                return@forEachIndexed
            }
        }

        ctx.elseStatementSequence?.let {
            if (!visited)
                it.visitChildren()
        }

        return null
    }

    override fun visitForStatement(ctx: OberonParser.ForStatementContext): Value? {
        enterNewContext()

        val counterName = ctx.ident().text
        val counterValue = ctx.counterExpression.visit()
        currentContext.variables[counterName] = Variable(counterValue, true)

        val fromValue = counterValue.asPrimitive<Int>().value
        val toValue = ctx.toExpression.visit().asPrimitive<Int>().value
        val byValue = ctx.byExpression?.visit()?.asPrimitive<Int>()?.value ?: 1

        for (counter in fromValue..<toValue step byValue) {
            currentContext.variables[counterName]!!.value = PrimitiveValue(counter, DataType.INTEGER)
            logger.debug { "Counter $counter na ${currentContext.variables[counterName]!!.value}" }
            ctx.statementSequence().visitChildren()
        }

        exitCurrentContext()

        return null
    }
}