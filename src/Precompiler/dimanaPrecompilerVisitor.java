// Generated from dimanaPrecompiler.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link dimanaPrecompilerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface dimanaPrecompilerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link dimanaPrecompilerParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(dimanaPrecompilerParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link dimanaPrecompilerParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(dimanaPrecompilerParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link dimanaPrecompilerParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreprocessorDirective(dimanaPrecompilerParser.PreprocessorDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link dimanaPrecompilerParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(dimanaPrecompilerParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link dimanaPrecompilerParser#filename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilename(dimanaPrecompilerParser.FilenameContext ctx);
}