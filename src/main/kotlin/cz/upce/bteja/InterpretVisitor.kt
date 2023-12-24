package cz.upce.bteja

import io.github.oshai.kotlinlogging.KotlinLogging
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.RuleNode
import java.util.*

class InterpretVisitor : OberonBaseVisitor<Value>() {
    val programContext = ProgramContext()
    val contexts = Stack<ExecutionContext>()
    private val logger = KotlinLogging.logger { }

    val currentContext get() = contexts.peek()!!

    init {
        addDefaultProcedures()
    }

    private fun ParseTree.visit() = visit(this)
    private fun RuleNode.visitChildren() = visitChildren(this)

    private fun enterNewContext() = contexts.push(ExecutionContext(programContext, currentContext))
    private fun exitCurrentContext() = contexts.pop()

    private fun addDefaultProcedures() {
        programContext.apply {
            procedures["PRINT_STR"] = ""
            procedures["PRINT_INT"] = ""
        }
    }

    override fun visitModule(ctx: OberonParser.ModuleContext): Value? {
        contexts.push(ExecutionContext(programContext, null))

        ctx.visitChildren()

        return null
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
            throw NonExistentVariableException("Proměnná \"$name\" neexistuje")
        }
        if (variable.isConstant) {
            logger.error { "\"$name\" je konstanta" }
            throw AssignmentToConstantException("\"$name\" je konstanta")
        }

        val value = ctx.expression().visit()
        val variableType = variable.value.type
        when (variableType) {
            DataType.ARRAY -> {
                if (ctx.designator().expression().size != 1) {
                    logger.error { "Chybný počet dimenzí pro \"$name\"" }
                    throw InvalidDimensionsException("Chybný počet dimenzí pro \"$name\"")
                }
                val index = ctx.designator().expression(0).visit().asPrimitive<Int>().value

                variable.value.asArray<Any>().value[index] = value.asPrimitive()
            }

            DataType.MATRIX -> {
                if (ctx.designator().expression().size != 2) {
                    logger.error { "Chybný počet dimenzí pro \"$name\"" }
                    throw InvalidDimensionsException("Chybný počet dimenzí pro \"$name\"")
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
            throw NonExistentVariableException("Proměnná/konstanta \"$name\" neexistuje")
        }
        if (!variable.isInitialized) {
            logger.error { "Proměnná \"$name\" není inicializovaná" }
            throw VariableNotInitializedException("Proměnná \"$name\" není inicializovaná")
        }

        val variableType = variable.value.type
        when (variableType) {
            DataType.ARRAY -> {
                if (ctx.expression().size != 1) {
                    logger.error { "Chybný počet dimenzí pro \"$name\"" }
                    throw InvalidDimensionsException("Chybný počet dimenzí pro \"$name\"")
                }
                val index = ctx.expression(0).visit().asPrimitive<Int>().value
                return variable.value.asArray<Any>().value[index]
            }

            DataType.MATRIX -> {
                if (ctx.expression().size != 2) {
                    logger.error { "Chybný počet dimenzí pro \"$name\"" }
                    throw InvalidDimensionsException("Chybný počet dimenzí pro \"$name\"")
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

            else -> throw IllegalTypeException("Neplatný typ")
        }
    }

    override fun visitTerm(ctx: OberonParser.TermContext): Value {
        val first = visit(ctx.factor(0))

        when (first.type) {
            DataType.INTEGER -> {
                var value = first.asPrimitive<Int>().value
                ctx.mulOperator().forEachIndexed { i, mulOperatorCtx ->
                    if (mulOperatorCtx.MULT() != null) {
                        value *= visit(ctx.factor(i + 1)).asPrimitive<Int>().value
                    } else if (mulOperatorCtx.DIV() != null) {
                        value /= visit(ctx.factor(i + 1)).asPrimitive<Int>().value
                    } else if (mulOperatorCtx.MOD() != null) {
                        value = value.mod(visit(ctx.factor(i + 1)).asPrimitive<Int>().value)
                    }
                }

                return PrimitiveValue(value, DataType.INTEGER)
            }

            DataType.REAL -> {
                var value = first.asPrimitive<Double>().value
                ctx.mulOperator().forEachIndexed { i, mulOperatorCtx ->
                    if (mulOperatorCtx.MULT() != null) {
                        value *= visit(ctx.factor(i + 1)).asPrimitive<Double>().value
                    } else if (mulOperatorCtx.DIV() != null) {
                        value /= visit(ctx.factor(i + 1)).asPrimitive<Double>().value
                    }
                }

                return PrimitiveValue(value, DataType.REAL)
            }

            else -> throw IllegalTypeException("Neplatný typ")
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