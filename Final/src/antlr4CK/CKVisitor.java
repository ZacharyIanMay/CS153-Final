// Generated from C:/Users/ianma/Desktop/CS153-Final/Final\CK.g4 by ANTLR 4.10.1

    package antlr4;
    import java.util.HashMap;
    import intermediate.symtab.SymtabEntry;
    import intermediate.type.Typespec;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CKParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CKVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CKParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CKParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#programHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramHeader(CKParser.ProgramHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#programParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramParameters(CKParser.ProgramParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#programIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramIdentifier(CKParser.ProgramIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CKParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#shiftCypherStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftCypherStatement(CKParser.ShiftCypherStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#polyCypherStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolyCypherStatement(CKParser.PolyCypherStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#stringAnalysisStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAnalysisStatement(CKParser.StringAnalysisStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#variableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationStatement(CKParser.VariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(CKParser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#variableIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableIdentifier(CKParser.VariableIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(CKParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(CKParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(CKParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(CKParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLhs(CKParser.LhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhs(CKParser.RhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(CKParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#trueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueStatement(CKParser.TrueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#falseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseStatement(CKParser.FalseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(CKParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#functionCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallStatement(CKParser.FunctionCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(CKParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(CKParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(CKParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CKParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(CKParser.SignContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#simpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpression(CKParser.SimpleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(CKParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableFactor}
	 * labeled alternative in {@link CKParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableFactor(CKParser.VariableFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberFactor}
	 * labeled alternative in {@link CKParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberFactor(CKParser.NumberFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code characterFactor}
	 * labeled alternative in {@link CKParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterFactor(CKParser.CharacterFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringFactor}
	 * labeled alternative in {@link CKParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringFactor(CKParser.StringFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallFactor}
	 * labeled alternative in {@link CKParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallFactor(CKParser.FunctionCallFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notFactor}
	 * labeled alternative in {@link CKParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFactor(CKParser.NotFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesizedFactor}
	 * labeled alternative in {@link CKParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedFactor(CKParser.ParenthesizedFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(CKParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(CKParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(CKParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(CKParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#unsignedNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedNumber(CKParser.UnsignedNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#integerConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerConstant(CKParser.IntegerConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#doubleConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleConstant(CKParser.DoubleConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#characterConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterConstant(CKParser.CharacterConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#stringConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(CKParser.StringConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#relOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelOp(CKParser.RelOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(CKParser.AddOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#mulOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOp(CKParser.MulOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#shiftOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftOp(CKParser.ShiftOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CKParser#polyOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolyOp(CKParser.PolyOpContext ctx);
}