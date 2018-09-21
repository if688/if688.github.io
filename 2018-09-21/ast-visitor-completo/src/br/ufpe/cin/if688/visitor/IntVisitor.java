package br.ufpe.cin.if688.visitor;

import br.ufpe.cin.if688.ast.DivExpr;
import br.ufpe.cin.if688.ast.Expr;
import br.ufpe.cin.if688.ast.MulExpr;
import br.ufpe.cin.if688.ast.NumExpr;
import br.ufpe.cin.if688.ast.ParExpr;
import br.ufpe.cin.if688.ast.SubExpr;
import br.ufpe.cin.if688.ast.SumExpr;

public interface IntVisitor {
	int visit(Expr e);
	int visit(NumExpr e);
	int visit(SumExpr e);
	int visit(MulExpr e);
	int visit(SubExpr e);
	int visit(DivExpr e);
	int visit(ParExpr e);
}
