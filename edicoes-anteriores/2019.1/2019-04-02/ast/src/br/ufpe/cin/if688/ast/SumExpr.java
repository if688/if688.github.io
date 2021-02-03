package br.ufpe.cin.if688.ast;

public class SumExpr extends Expr {
	Expr e1, e2;

	public SumExpr(Expr e1, Expr e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	@Override
	public String toString() {
		return "(" + e1.toString() + " + " + e2 + ")";
		// return e1 + " + " + e2;
	}

	@Override
	int accept(EvalVisitor v) {
		System.out.println("accept de SumExpr");
		return v.visit(this);
	}

	@Override
	<T> T accept(IVisitor<T> v) {
		return v.visit(this);
	}

}
