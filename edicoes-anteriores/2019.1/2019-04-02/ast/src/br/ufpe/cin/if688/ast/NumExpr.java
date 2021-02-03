package br.ufpe.cin.if688.ast;

public class NumExpr extends Expr {
	int num;

	public NumExpr(int n) {
		this.num = n;
	}

	@Override
	public String toString() {
		return this.num + "";
	}

	@Override
	int accept(EvalVisitor v) {
		System.out.println("accept de NumExpr");
		return v.visit(this);
	}

	@Override
	<T> T accept(IVisitor<T> v) {
		return v.visit(this);
	}

}
