package cz.upce.bteja.semantickaAnalyza

class ConcreteAstVisitor : AstVisitor<Type> {
    val symbolTable = SymbolTable()

    override fun visit(moduleNode: ModuleNode): Type {
        symbolTable.enterScope()

        // Navštívit všechny deklarace
        moduleNode.declarations.accept<Type>(this)

        // Navštívit všechny příkazy, pokud existují
        moduleNode.statementSequence?.accept<Type>(this)

        // Opustit rozsah modulu
        symbolTable.exitScope()

        return Type.Void
    }



    override fun visit(variableExpression: VariableExpression): Type {
        val variableType = symbolTable.getType(variableExpression.name)
        return variableType
    }

    override fun visit(functionCall: FunctionCall): Type {
        // Zkontrolujte, zda funkce existuje s definovanými parametry a zda jsou argumenty správného typu.
        val functionType = symbolTable.getType(functionCall.function.name) as? Type.FunctionType
            ?: throw Exception("Funkce ${functionCall.function.name} není definována.")
        if (functionCall.arguments.size != functionType.parameterTypes.size) {
            throw Exception("Nesprávný počet argumentů pro funkci ${functionCall.function.name}.")
        }
        for (i in functionCall.arguments.indices) {
            val argType = functionCall.arguments[i].accept<Type>(this)
            val paramType = functionType.parameterTypes[i]
            if (argType != paramType) {
                throw Exception("Nesouhlas typů argumentu ${i + 1} ve funkci ${functionCall.function.name}: očekáváno $paramType, nalezeno $argType")
            }
        }
        return functionType.returnType
    }


    override fun visit(identifierExpression: IdentifierExpression): Type {
        val identifierName = identifierExpression.identifier.name
        val identifierType = symbolTable.getType(identifierName)
        return identifierType
    }

    override fun visit(arrayAccess: ArrayAccess): Type {
        val arrayType = symbolTable.getType(arrayAccess.array.accept<Type>(this).toString()) as? Type.ArrayType
            ?: throw Exception("Pokus o přístup k ne-poli jako k poli.")

        val indexType = arrayAccess.index.accept<Type>(this)
        if (indexType != Type.Integer) {
            throw Exception("Index pole musí být typu Integer.")
        }

        return arrayType.elementType
    }

    override fun visit(binaryOperatorExpression: BinaryOperatorExpression): Type {
        val leftType = binaryOperatorExpression.left.accept<Type>(this)
        val rightType = binaryOperatorExpression.right.accept<Type>(this)

        if (leftType != Type.Integer || rightType != Type.Integer) {
            throw Exception("Aritmetické operace jsou povoleny pouze na typu Integer.")
        }

        return Type.Integer
    }

    override fun visit(unaryOperatorExpression: UnaryOperatorExpression): Type {
        TODO("Not yet implemented")
    }

    override fun visit(statementSequence: StatementSequence): Type {
        TODO("Not yet implemented")
    }

    override fun visit(assignment: Statement.Assignment): Type {
        TODO("Not yet implemented")
    }

    override fun visit(ifStatement: Statement.IfStatement): Type {
        TODO("Not yet implemented")
    }

    override fun visit(elsifStatement: Statement.ElsifStatement): Type {
        TODO("Not yet implemented")
    }

    override fun visit(procedureDeclaration: ProcedureDeclaration): Type {
        TODO("Not yet implemented")
    }

    override fun visit(parameter: Parameter): Type {
        TODO("Not yet implemented")
    }

    override fun visit(identifier: Identifier): Type {
        TODO("Not yet implemented")
    }

    override fun visit(operator: Operator): Type {
        TODO("Not yet implemented")
    }

    override fun visit(literal: Literal): Type {
        TODO("Not yet implemented")
    }

    override fun visit(designator: Designator): Type {
        TODO("Not yet implemented")
    }

    override fun visit(selector: Selector): Type {
        TODO("Not yet implemented")
    }

    override fun visit(literalExpression: LiteralExpression): Type {
        TODO("Not yet implemented")
    }

    override fun visit(unaryExpression: UnaryExpression): Type {
        TODO("Not yet implemented")
    }

    override fun visit(declarationSequence: DeclarationSequence): Type {
        TODO("Not yet implemented")
    }

    override fun visit(constDeclaration: ConstDeclaration): Type {
        TODO("Not yet implemented")
    }

    override fun visit(variableDeclaration: VariableDeclaration): Type {
        variableDeclaration.names.forEach { name ->
            symbolTable.defineVariable(name, variableDeclaration.type)
        }
        //Kdyz je to v poho
        return Type.Void
    }

    override fun visit(binaryExpression: BinaryExpression): Type {
        val leftType = binaryExpression.left.accept<Type>(this)
        val rightType = binaryExpression.right.accept<Type>(this)
        if (binaryExpression.op in listOf("+", "-", "*", "/")) {
            if ((leftType == Type.Integer || leftType == Type.Real) &&
                (rightType == Type.Integer || rightType == Type.Real)) {
                // Operace je povolena pro celá i reálná čísla
                return if (leftType == Type.Real || rightType == Type.Real) Type.Real else Type.Integer
            } else {
                throw Exception("Aritmetické operace jsou povoleny pouze pro celá čísla nebo reálná čísla")
            }
        } else {
            throw Exception("Nepodporovaný operátor: ${binaryExpression.op}")
        }
    }

}