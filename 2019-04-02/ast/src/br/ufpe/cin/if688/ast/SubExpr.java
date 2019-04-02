package br.ufpe.cin.if688.ast;

public class SubExpr extends Expr {
	Expr e1, e2;

	public SubExpr(Expr e1, Expr e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	@Override
	int accept(EvalVisitor v) {
		System.out.println("accept de SubExpr");
		return v.visit(this);
	}

	@Override
	<T> T accept(IVisitor<T> v) {
		return v.visit(this);
	}
}
