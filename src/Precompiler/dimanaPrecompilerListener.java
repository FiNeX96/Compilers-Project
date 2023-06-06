// Generated from dimanaPrecompiler.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link dimanaPrecompilerParser}.
 */
public interface dimanaPrecompilerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link dimanaPrecompilerParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(dimanaPrecompilerParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaPrecompilerParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(dimanaPrecompilerParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaPrecompilerParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(dimanaPrecompilerParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaPrecompilerParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(dimanaPrecompilerParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaPrecompilerParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void enterPreprocessorDirective(dimanaPrecompilerParser.PreprocessorDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaPrecompilerParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void exitPreprocessorDirective(dimanaPrecompilerParser.PreprocessorDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaPrecompilerParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(dimanaPrecompilerParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaPrecompilerParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(dimanaPrecompilerParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link dimanaPrecompilerParser#filename}.
	 * @param ctx the parse tree
	 */
	void enterFilename(dimanaPrecompilerParser.FilenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link dimanaPrecompilerParser#filename}.
	 * @param ctx the parse tree
	 */
	void exitFilename(dimanaPrecompilerParser.FilenameContext ctx);
}