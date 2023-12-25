package cz.upce.bteja.semantickaAnalyza

class SymbolTable {
    private val scopes = ArrayDeque<MutableMap<String, Type>>()

    init {
        // Přidat globální rozsah
        enterScope()
    }

    // Vstoupit do nového rozsahu
    fun enterScope() {
        scopes.addFirst(mutableMapOf())
    }

    // Opustit rozsah
    fun exitScope() {
        if (scopes.isNotEmpty()) {
            scopes.removeFirst()
        } else {
            throw IllegalStateException("No scope to exit.")
        }
    }

    // Definovat proměnnou v aktuálním rozsahu
    fun defineVariable(name: String, type: Type) {
        val currentScope = scopes.firstOrNull() ?: throw IllegalStateException("No scope defined.")
        if (currentScope.containsKey(name)) {
            throw Exception("Variable $name is already defined in the current scope.")
        }
        currentScope[name] = type
    }

    // Získat typ proměnné, hledá všechny rozsahy
    fun getType(name: String): Type {
        for (scope in scopes) {
            scope[name]?.let { return it }
        }
        throw Exception("Variable $name is not defined in any scope.")
    }
}

