// Generated from dimana.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link dimanaParser}.
 */
public interface dimanaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link dimanaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(dimanaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(dimanaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#statList}.
	 * @param ctx the parse tree
	 */
	void enterStatList(dimanaParser.StatListContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#statList}.
	 * @param ctx the parse tree
	 */
	void exitStatList(dimanaParser.StatListContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(dimanaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(dimanaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(dimanaParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(dimanaParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#readToArray}.
	 * @param ctx the parse tree
	 */
	void enterReadToArray(dimanaParser.ReadToArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#readToArray}.
	 * @param ctx the parse tree
	 */
	void exitReadToArray(dimanaParser.ReadToArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(dimanaParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(dimanaParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void enterInputStatement(dimanaParser.InputStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void exitInputStatement(dimanaParser.InputStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#outputStatement}.
	 * @param ctx the parse tree
	 */
	void enterOutputStatement(dimanaParser.OutputStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#outputStatement}.
	 * @param ctx the parse tree
	 */
	void exitOutputStatement(dimanaParser.OutputStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#outputFormat}.
	 * @param ctx the parse tree
	 */
	void enterOutputFormat(dimanaParser.OutputFormatContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#outputFormat}.
	 * @param ctx the parse tree
	 */
	void exitOutputFormat(dimanaParser.OutputFormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#write_expr}.
	 * @param ctx the parse tree
	 */
	void enterWrite_expr(dimanaParser.Write_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#write_expr}.
	 * @param ctx the parse tree
	 */
	void exitWrite_expr(dimanaParser.Write_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(dimanaParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(dimanaParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(dimanaParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(dimanaParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(dimanaParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(dimanaParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#length}.
	 * @param ctx the parse tree
	 */
	void enterLength(dimanaParser.LengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#length}.
	 * @param ctx the parse tree
	 */
	void exitLength(dimanaParser.LengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(dimanaParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(dimanaParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(dimanaParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(dimanaParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#headerFile}.
	 * @param ctx the parse tree
	 */
	void enterHeaderFile(dimanaParser.HeaderFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#headerFile}.
	 * @param ctx the parse tree
	 */
	void exitHeaderFile(dimanaParser.HeaderFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#prefixUnit}.
	 * @param ctx the parse tree
	 */
	void enterPrefixUnit(dimanaParser.PrefixUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#prefixUnit}.
	 * @param ctx the parse tree
	 */
	void exitPrefixUnit(dimanaParser.PrefixUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code independentUnit}
	 * labeled alternative in {@link dimanaParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterIndependentUnit(dimanaParser.IndependentUnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code independentUnit}
	 * labeled alternative in {@link dimanaParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitIndependentUnit(dimanaParser.IndependentUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dependantUnit}
	 * labeled alternative in {@link dimanaParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterDependantUnit(dimanaParser.DependantUnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dependantUnit}
	 * labeled alternative in {@link dimanaParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitDependantUnit(dimanaParser.DependantUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#alternativeUnit}.
	 * @param ctx the parse tree
	 */
	void enterAlternativeUnit(dimanaParser.AlternativeUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#alternativeUnit}.
	 * @param ctx the parse tree
	 */
	void exitAlternativeUnit(dimanaParser.AlternativeUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#listDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterListDeclaration(dimanaParser.ListDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#listDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitListDeclaration(dimanaParser.ListDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(dimanaParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(dimanaParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(dimanaParser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(dimanaParser.IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(dimanaParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(dimanaParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(dimanaParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(dimanaParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexExpression}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpression(dimanaParser.IndexExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexExpression}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpression(dimanaParser.IndexExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Get_array_idx}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGet_array_idx(dimanaParser.Get_array_idxContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Get_array_idx}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGet_array_idx(dimanaParser.Get_array_idxContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSubExpression}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpression(dimanaParser.AddSubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSubExpression}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpression(dimanaParser.AddSubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RealLiteral}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRealLiteral(dimanaParser.RealLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RealLiteral}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRealLiteral(dimanaParser.RealLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeConversion}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTypeConversion(dimanaParser.TypeConversionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeConversion}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTypeConversion(dimanaParser.TypeConversionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RealSuffix}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRealSuffix(dimanaParser.RealSuffixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RealSuffix}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRealSuffix(dimanaParser.RealSuffixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(dimanaParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(dimanaParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolLiteral}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(dimanaParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolLiteral}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(dimanaParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpression}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpression(dimanaParser.IdExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpression}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpression(dimanaParser.IdExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpression}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(dimanaParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpression}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(dimanaParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(dimanaParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(dimanaParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntSuffix}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntSuffix(dimanaParser.IntSuffixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntSuffix}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntSuffix(dimanaParser.IntSuffixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndOrExpression}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndOrExpression(dimanaParser.AndOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndOrExpression}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndOrExpression(dimanaParser.AndOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivExpression}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpression(dimanaParser.MulDivExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivExpression}
	 * labeled alternative in {@link dimanaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpression(dimanaParser.MulDivExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(dimanaParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(dimanaParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaParser#castTypes}.
	 * @param ctx the parse tree
	 */
	void enterCastTypes(dimanaParser.CastTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaParser#castTypes}.
	 * @param ctx the parse tree
	 */
	void exitCastTypes(dimanaParser.CastTypesContext ctx);
}