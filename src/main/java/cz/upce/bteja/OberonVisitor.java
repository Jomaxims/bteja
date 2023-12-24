// Generated from D:/UPCE/5S/BTEJA/sem/interpreter/Oberon.g4 by ANTLR 4.13.1
package cz.upce.bteja;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OberonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface OberonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link OberonParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(OberonParser.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(OberonParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#constDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDeclaration(OberonParser.ConstDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(OberonParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(OberonParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#matrixType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixType(OberonParser.MatrixTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#length}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLength(OberonParser.LengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#identList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentList(OberonParser.IdentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(OberonParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(OberonParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#boolExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(OberonParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(OberonParser.RelationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#simpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpression(OberonParser.SimpleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#addOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOperator(OberonParser.AddOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(OberonParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#mulOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOperator(OberonParser.MulOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(OberonParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#designator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignator(OberonParser.DesignatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#expList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpList(OberonParser.ExpListContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#actualParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParameters(OberonParser.ActualParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(OberonParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(OberonParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#procedureCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureCall(OberonParser.ProcedureCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#statementSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementSequence(OberonParser.StatementSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(OberonParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(OberonParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#exitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitStatement(OberonParser.ExitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(OberonParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureDeclaration(OberonParser.ProcedureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#procedureHeading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureHeading(OberonParser.ProcedureHeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#procedureBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureBody(OberonParser.ProcedureBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#declarationSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationSequence(OberonParser.DeclarationSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#procedureParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureParameters(OberonParser.ProcedureParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#fPSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFPSection(OberonParser.FPSectionContext ctx);
}