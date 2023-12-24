package cz.upce.bteja

class ProgramContext {
    val procedures = mutableMapOf<String, String>()
}

class ExecutionContext(
    val programContext: ProgramContext,
    val parentContext: ExecutionContext?
) {
    val variables = mutableMapOf<String, Variable>()
    val hasParent get() = parentContext != null

    fun hasVariable(name: String): Boolean =
        if (variables.keys.contains(name))
            true
        else if (!hasParent)
            false
        else parentContext!!.hasVariable(name)

    fun getVariable(name: String): Variable? {
        var variable: Variable? = variables[name]

        if (variable == null && hasParent)
            variable = parentContext!!.getVariable(name)

        return variable
    }
}