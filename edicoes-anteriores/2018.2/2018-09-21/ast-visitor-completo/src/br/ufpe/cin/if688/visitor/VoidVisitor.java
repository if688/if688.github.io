package br.ufpe.cin.if688.visitor;

import br.ufpe.cin.if688.ast.DivExpr;
import br.ufpe.cin.if688.ast.Expr;
import br.ufpe.cin.if688.ast.MulExpr;
import br.ufpe.cin.if688.ast.NumExpr;
import br.ufpe.cin.if688.ast.ParExpr;
import br.ufpe.cin.if688.ast.SubExpr;
import br.ufpe.cin.if688.ast.SumExpr;

public interface VoidVisitor {
	void visit(Expr e);
	void visit(NumExpr e);
	void visit(SumExpr e);
	void visit(MulExpr e);
	void visit(SubExpr e);
	void visit(DivExpr e);
	void visit(ParExpr e);
}
