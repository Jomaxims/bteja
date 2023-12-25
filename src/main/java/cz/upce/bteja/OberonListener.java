// Generated from D:/UPCE/5S/BTEJA/sem/interpreter/Oberon.g4 by ANTLR 4.13.1
package cz.upce.bteja;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OberonParser}.
 */
public interface OberonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OberonParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(OberonParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(OberonParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(OberonParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(OberonParser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclaration(OberonParser.ConstDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclaration(OberonParser.ConstDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(OberonParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(OberonParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(OberonParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(OberonParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#matrixType}.
	 * @param ctx the parse tree
	 */
	void enterMatrixType(OberonParser.MatrixTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#matrixType}.
	 * @param ctx the parse tree
	 */
	void exitMatrixType(OberonParser.MatrixTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#length}.
	 * @param ctx the parse tree
	 */
	void enterLength(OberonParser.LengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#length}.
	 * @param ctx the parse tree
	 */
	void exitLength(OberonParser.LengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#identList}.
	 * @param ctx the parse tree
	 */
	void enterIdentList(OberonParser.IdentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#identList}.
	 * @param ctx the parse tree
	 */
	void exitIdentList(OberonParser.IdentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(OberonParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(OberonParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(OberonParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(OberonParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#boolExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(OberonParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#boolExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(OberonParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(OberonParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(OberonParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpression(OberonParser.SimpleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpression(OberonParser.SimpleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#addOperator}.
	 * @param ctx the parse tree
	 */
	void enterAddOperator(OberonParser.AddOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#addOperator}.
	 * @param ctx the parse tree
	 */
	void exitAddOperator(OberonParser.AddOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(OberonParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(OberonParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#mulOperator}.
	 * @param ctx the parse tree
	 */
	void enterMulOperator(OberonParser.MulOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#mulOperator}.
	 * @param ctx the parse tree
	 */
	void exitMulOperator(OberonParser.MulOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(OberonParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(OberonParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#designator}.
	 * @param ctx the parse tree
	 */
	void enterDesignator(OberonParser.DesignatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#designator}.
	 * @param ctx the parse tree
	 */
	void exitDesignator(OberonParser.DesignatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#expList}.
	 * @param ctx the parse tree
	 */
	void enterExpList(OberonParser.ExpListContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#expList}.
	 * @param ctx the parse tree
	 */
	void exitExpList(OberonParser.ExpListContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#actualParameters}.
	 * @param ctx the parse tree
	 */
	void enterActualParameters(OberonParser.ActualParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#actualParameters}.
	 * @param ctx the parse tree
	 */
	void exitActualParameters(OberonParser.ActualParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(OberonParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(OberonParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(OberonParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(OberonParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#procedureCall}.
	 * @param ctx the parse tree
	 */
	void enterProcedureCall(OberonParser.ProcedureCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#procedureCall}.
	 * @param ctx the parse tree
	 */
	void exitProcedureCall(OberonParser.ProcedureCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#statementSequence}.
	 * @param ctx the parse tree
	 */
	void enterStatementSequence(OberonParser.StatementSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#statementSequence}.
	 * @param ctx the parse tree
	 */
	void exitStatementSequence(OberonParser.StatementSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(OberonParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(OberonParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(OberonParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(OberonParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(OberonParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(OberonParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProcedureDeclaration(OberonParser.ProcedureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProcedureDeclaration(OberonParser.ProcedureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#procedureHeading}.
	 * @param ctx the parse tree
	 */
	void enterProcedureHeading(OberonParser.ProcedureHeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#procedureHeading}.
	 * @param ctx the parse tree
	 */
	void exitProcedureHeading(OberonParser.ProcedureHeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#procedureBody}.
	 * @param ctx the parse tree
	 */
	void enterProcedureBody(OberonParser.ProcedureBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#procedureBody}.
	 * @param ctx the parse tree
	 */
	void exitProcedureBody(OberonParser.ProcedureBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#declarationSequence}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSequence(OberonParser.DeclarationSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#declarationSequence}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSequence(OberonParser.DeclarationSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#procedureParameters}.
	 * @param ctx the parse tree
	 */
	void enterProcedureParameters(OberonParser.ProcedureParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#procedureParameters}.
	 * @param ctx the parse tree
	 */
	void exitProcedureParameters(OberonParser.ProcedureParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#fPSection}.
	 * @param ctx the parse tree
	 */
	void enterFPSection(OberonParser.FPSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#fPSection}.
	 * @param ctx the parse tree
	 */
	void exitFPSection(OberonParser.FPSectionContext ctx);
}