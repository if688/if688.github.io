package br.ufpe.cin.if688.visitor;

import br.ufpe.cin.if688.ast.DivExpr;
import br.ufpe.cin.if688.ast.Expr;
import br.ufpe.cin.if688.ast.MulExpr;
import br.ufpe.cin.if688.ast.NumExpr;
import br.ufpe.cin.if688.ast.ParExpr;
import br.ufpe.cin.if688.ast.SubExpr;
import br.ufpe.cin.if688.ast.SumExpr;

public class PosFixaVisitor implements IVisitor<Void> {
	public StringBuilder exp;

	// pode passar algum argumento, como uma Symbol Table
	public PosFixaVisitor() {
		exp = new StringBuilder();
	}
	
	@Override
	public Void visit(Expr e) {
		e.accept(this);
		return null;
	}

	@Override
	public Void visit(NumExpr e) {
		exp.append(e.num);
		return null;
	}

	@Override
	public Void visit(SumExpr e) {
		// SumExpr e = new SumExpr(NumExpr(25),NumExpr(3));
		e.e1.accept(this);// exp.append(NumExpr(25))
		exp.append(" ");
		e.e2.accept(this);// exp.append(NumExpr(3))
		exp.append(" + ");
		return null;
	}

	@Override
	public Void visit(MulExpr e) {
		e.e1.accept(this);
		exp.append(" ");
		e.e2.accept(this);
		exp.append(" * ");
		return null;
	}

	@Override
	public Void visit(SubExpr e) {
		e.e1.accept(this);
		exp.append(" ");
		e.e2.accept(this);
		exp.append(" - ");
		return null;
	}

	@Override
	public Void visit(DivExpr e) {
		e.e1.accept(this);
		exp.append(" ");
		e.e2.accept(this);
		exp.append(" / ");
		return null;
	}

	@Override
	public Void visit(ParExpr e) {
		e.e.accept(this);
		return null;
	}
}