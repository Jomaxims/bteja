package cz.upce.bteja

class ProgramContext {
    val procedures = mutableMapOf<String, OberonParser.ProcedureDeclarationContext>()
    val libraryProcedures = mutableMapOf<String, LibraryProcedure>()
    lateinit var globalContext: ExecutionContext
}

class ExecutionContext(
    private val programContext: ProgramContext,
    private val parentContext: ExecutionContext?,
    val isProcedure: Boolean = false,
) {
    val variables = mutableMapOf<String, Variable>()
    private val hasParent get() = parentContext != null

    fun getVariable(name: String): Variable? {
        var variable: Variable? = variables[name]

        if (variable == null && isProcedure)
            return programContext.globalContext.getVariable(name)

        if (variable == null && hasParent)
            variable = parentContext!!.getVariable(name)

        return variable
    }
}