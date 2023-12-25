package cz.upce.bteja.semantickaAnalyza

// Základní třída pro všechny uzly AST
abstract class AstNode {
    abstract fun <T> accept(visitor: AstVisitor<T>): T
}

// Typy
sealed class Type {
    object Integer : Type()
    object Real : Type()
    object String : Type()
    object Boolean : Type()
    object Void : Type()
    class ArrayType(val elementType: Type, val lengths: List<Int>) : Type()
    class FunctionType(val returnType: Type, val parameterTypes: List<Type>) : Type()
    object Error : Type()
}

// Programový modul
data class ModuleNode(
    val name: String,
    val declarations: DeclarationSequence,
    val statementSequence: StatementSequence?
) : AstNode() {
    override fun <T> accept(visitor: AstVisitor<T>): T = visitor.visit(this)
}

// Sekvence deklarací
data class DeclarationSequence(
    val constDeclarations: List<ConstDeclaration>,
    val varDeclarations: List<VariableDeclaration>,
    val procedureDeclarations: List<ProcedureDeclaration>
) : AstNode() {
    override fun <T> accept(visitor: AstVisitor<T>): T = visitor.visit(this)
}

// Deklarace konstanty
data class ConstDeclaration(
    val name: String,
    val expression: Expression
) : AstNode() {
    override fun <T> accept(visitor: AstVisitor<T>): T = visitor.visit(this)
}

// Deklarace proměnné
data class VariableDeclaration(
    val names: List<String>,
    val type: Type
) : AstNode() {
    override fun <T> accept(visitor: AstVisitor<T>): T = visitor.visit(this)
}

// Výrazy
sealed class Expression : AstNode() {
    override fun <T> accept(visitor: AstVisitor<T>): T = when (this) {
        is BinaryExpression -> visitor.visit(this)
        is UnaryExpression -> visitor.visit(this)
        is LiteralExpression -> visitor.visit(this)
        is VariableExpression -> visitor.visit(this)
        is FunctionCall -> visitor.visit(this)
        is IdentifierExpression -> visitor.visit(this)
        is ArrayAccess -> visitor.visit(this)
        is BinaryOperatorExpression -> visitor.visit(this)
        is UnaryOperatorExpression -> visitor.visit(this)
    }
}


// Sekvence příkazů
data class StatementSequence(val statements: List<Statement>) : AstNode() {
    override fun <T> accept(visitor: AstVisitor<T>): T = visitor.visit(this)
}

// Příkazy
sealed class Statement : AstNode() {
    data class Assignment(val designator: Designator, val expression: Expression) : Statement()
    data class IfStatement(
        val condition: Expression,
        val thenStatements: StatementSequence,
        val elsifStatements: List<ElsifStatement>,
        val elseStatements: StatementSequence?
    ) : Statement()

    data class ElsifStatement(
        val condition: Expression,
        val thenStatements: StatementSequence
    ) : Statement()
    override fun <T> accept(visitor: AstVisitor<T>): T = when(this) {
        is Assignment -> visitor.visit(this)
        is IfStatement -> visitor.visit(this)
        is ElsifStatement -> visitor.visit(this)
    }
}

// Procedurální deklarace
data class ProcedureDeclaration(
    val name: String,
    val parameters: List<Parameter>,
    val body: StatementSequence
) : AstNode() {
    override fun <T> accept(visitor: AstVisitor<T>): T = visitor.visit(this)
}

// Parametry
data class Parameter(
    val names: List<String>,
    val type: Type
) : AstNode() {
    override fun <T> accept(visitor: AstVisitor<T>): T = visitor.visit(this)
}

// Identifikátory
data class Identifier(val name: String) : AstNode() {
    override fun <T> accept(visitor: AstVisitor<T>): T = visitor.visit(this)
}

// Operátory
sealed class Operator : AstNode() {
    object Add : Operator()
    object Subtract : Operator()
    object Multiply : Operator()
    object Divide : Operator()
    object Modulo : Operator()
    object Equal : Operator()
    object NotEqual : Operator()
    object LessThan : Operator()
    object LessThanOrEqual : Operator()
    object GreaterThan : Operator()
    object GreaterThanOrEqual : Operator()

    override fun <T> accept(visitor: AstVisitor<T>): T = visitor.visit(this)
}

// Literály
sealed class Literal : AstNode() {
    data class IntegerLiteral(val value: Int) : Literal()
    data class RealLiteral(val value: Double) : Literal()
    data class StringLiteral(val value: String) : Literal()
    object BooleanLiteralTrue : Literal()
    object BooleanLiteralFalse : Literal()

    override fun <T> accept(visitor: AstVisitor<T>): T = visitor.visit(this)
}

// Výrazy pro identifikátory
data class IdentifierExpression(val identifier: Identifier) : Expression()

// Výrazy pro operátory
data class BinaryOperatorExpression(val left: Expression, val operator: Operator, val right: Expression) : Expression()
data class UnaryOperatorExpression(val operator: Operator, val operand: Expression) : Expression()

// Designátory
data class Designator(
    val identifier: Identifier,
    val selectors: List<Selector>
) : AstNode() {
    override fun <T> accept(visitor: AstVisitor<T>): T = visitor.visit(this)
}


// Selectory (přistup k prvkům pole atd.)
sealed class Selector : AstNode() {
    data class ArraySelector(val index: Expression) : Selector()

    override fun <T> accept(visitor: AstVisitor<T>): T = visitor.visit(this)
}

// Pomocné třídy pro přístup k prvku pole nebo pro volání funkcí
data class ArrayAccess(val array: Expression, val index: Expression) : Expression()
data class FunctionCall(val function: Identifier, val arguments: List<Expression>) : Expression()
data class BinaryExpression(val left: Expression, val op: String, val right: Expression) : Expression()
data class UnaryExpression(val op: String, val expr: Expression) : Expression()
data class LiteralExpression(val literal: Literal) : Expression()
data class VariableExpression(val name: String) : Expression()