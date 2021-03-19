// Generated from /Users/leopoldomt/Documents/cin/compilers/if688.github.io/2021-03-19/antlr/src/br/ufpe/cin/if688/antlr/arithmetic.g4 by ANTLR 4.9.1
package br.ufpe.cin.if688.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link arithmeticParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface arithmeticVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link arithmeticParser#exps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExps(arithmeticParser.ExpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link arithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(arithmeticParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link arithmeticParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(arithmeticParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link arithmeticParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(arithmeticParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link arithmeticParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(arithmeticParser.NumberContext ctx);
}