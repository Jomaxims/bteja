package cz.upce.bteja.semantickaAnalyza

// Definice rozhraní AstVisitor
interface AstVisitor<T> {
    fun visit(moduleNode: ModuleNode): T
    fun visit(declarationSequence: DeclarationSequence): T
    fun visit(constDeclaration: ConstDeclaration): T
    fun visit(variableDeclaration: VariableDeclaration): T
    fun visit(binaryExpression: BinaryExpression): T
    fun visit(unaryExpression: UnaryExpression): T
    fun visit(literalExpression: LiteralExpression): T
    fun visit(variableExpression: VariableExpression): T
    fun visit(functionCall: FunctionCall): T
    fun visit(identifierExpression: IdentifierExpression): T
    fun visit(arrayAccess: ArrayAccess): T
    fun visit(binaryOperatorExpression: BinaryOperatorExpression): T
    fun visit(unaryOperatorExpression: UnaryOperatorExpression): T
    fun visit(statementSequence: StatementSequence): T
    fun visit(assignment: Statement.Assignment): T
    fun visit(ifStatement: Statement.IfStatement): T
    fun visit(elsifStatement: Statement.ElsifStatement): T
    fun visit(procedureDeclaration: ProcedureDeclaration): T
     fun visit(parameter: Parameter): T
     fun visit(identifier: Identifier): T
     fun visit(operator: Operator): T
     fun visit(literal: Literal): T
     fun visit(designator: Designator): T
     fun visit(selector: Selector): T
}
