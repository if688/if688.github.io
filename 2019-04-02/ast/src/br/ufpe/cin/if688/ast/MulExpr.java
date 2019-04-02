package br.ufpe.cin.if688.ast;

public class MulExpr extends Expr {
	Expr e1, e2;
	public MulExpr(Expr e1,Expr e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	@Override
	int accept(EvalVisitor v) {
		System.out.println("accept de MulExpr");
		return v.visit(this);
	}
	@Override
	<T> T accept(IVisitor<T> v) {
		return v.visit(this);
	}
}
