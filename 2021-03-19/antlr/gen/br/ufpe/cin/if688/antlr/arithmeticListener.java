// Generated from /Users/leopoldomt/Documents/cin/compilers/if688.github.io/2021-03-19/antlr/src/br/ufpe/cin/if688/antlr/arithmetic.g4 by ANTLR 4.9.1
package br.ufpe.cin.if688.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link arithmeticParser}.
 */
public interface arithmeticListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link arithmeticParser#exps}.
	 * @param ctx the parse tree
	 */
	void enterExps(arithmeticParser.ExpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link arithmeticParser#exps}.
	 * @param ctx the parse tree
	 */
	void exitExps(arithmeticParser.ExpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link arithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(arithmeticParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link arithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(arithmeticParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link arithmeticParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(arithmeticParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link arithmeticParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(arithmeticParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link arithmeticParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(arithmeticParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link arithmeticParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(arithmeticParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link arithmeticParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(arithmeticParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link arithmeticParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(arithmeticParser.NumberContext ctx);
}