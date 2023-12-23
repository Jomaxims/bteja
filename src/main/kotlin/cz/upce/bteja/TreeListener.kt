package cz.upce.bteja

import java.util.Stack

class TreeListener(private val parser: OberonParser) : OberonBaseListener() {
    private val programContext = ProgramContext()
    private val contexts = Stack<ExecutionContext>().apply {
        push(ExecutionContext(programContext, null))
    }

    init {
        addDefaultVarsAndProcedures()
    }

    private fun addDefaultVarsAndProcedures() {
        contexts.peek().apply {
            variables["INTEGER"] = Variable.Empty
            variables["REAL"] = Variable.Empty
            variables["STRING"] = Variable.Empty
        }

        programContext.apply {
            procedures["PRINT_STR"] = ""
            procedures["PRINT_INT"] = ""
        }
    }

    override fun enterConstDeclaration(ctx: OberonParser.ConstDeclarationContext) {
        val constName = ctx.ident().text
        contexts.peek().variables[constName] = Variable.Empty
    }

    override fun enterVariableDeclaration(ctx: OberonParser.VariableDeclarationContext) {
        ctx.identList().ident().forEach { ident ->
            val varName = ident.text
            contexts.peek().variables[varName] = Variable.Empty
        }
    }

    override fun enterProcedureHeading(ctx: OberonParser.ProcedureHeadingContext) {
        val procedureName = ctx.ident().text
        programContext.procedures[procedureName] = ""
    }

    override fun enterProcedureDeclaration(ctx: OberonParser.ProcedureDeclarationContext) {
        contexts.push(ExecutionContext(programContext, contexts.peek()))
    }

    override fun exitProcedureDeclaration(ctx: OberonParser.ProcedureDeclarationContext) {
        contexts.pop()
    }

    override fun enterProcedureParameters(ctx: OberonParser.ProcedureParametersContext) {
        ctx.fPSection().forEach { fPSection->
            val varName = fPSection.ident().text
            contexts.peek().variables[varName] = Variable.Empty
        }
    }

    override fun enterForStatement(ctx: OberonParser.ForStatementContext) {
        contexts.push(ExecutionContext(programContext, contexts.peek()))

        ctx
    }

    override fun exitForStatement(ctx: OberonParser.ForStatementContext) {
        contexts.pop()
    }

    override fun enterIdent(ctx: OberonParser.IdentContext) {
        val name = ctx.text

        if (
            ctx.getParent() is OberonParser.ModuleContext ||
            ctx.getParent() is OberonParser.ProcedureHeadingContext ||
            ctx.getParent() is OberonParser.ProcedureDeclarationContext
            )
            return

        if (ctx.getParent() is OberonParser.ProcedureCallContext) {
            if (!programContext.procedures.contains(name)) {
                throw Exception(name)
            }

            return
        }

        if (!contexts.peek().hasVariable(name))
            throw Exception(name)
    }
}