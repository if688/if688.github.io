package br.ufpe.cin.if688.visitor;

import br.ufpe.cin.if688.ast.DivExpr;
import br.ufpe.cin.if688.ast.Expr;
import br.ufpe.cin.if688.ast.MulExpr;
import br.ufpe.cin.if688.ast.NumExpr;
import br.ufpe.cin.if688.ast.ParExpr;
import br.ufpe.cin.if688.ast.SubExpr;
import br.ufpe.cin.if688.ast.SumExpr;

//T extends Object - qualquer tipo Java
public interface IVisitor<T> {
	T visit(Expr e);
	T visit(NumExpr e);
	T visit(SumExpr e);
	T visit(MulExpr e);
	T visit(SubExpr e);
	T visit(DivExpr e);
	T visit(ParExpr e);
}
