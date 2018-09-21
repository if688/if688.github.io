package br.ufpe.cin.if688.ast;


public class SumExpr extends Expr {
	// TODO volte para private, come back!
	public Expr e1, e2;

	public SumExpr(Expr e1, Expr e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

}
