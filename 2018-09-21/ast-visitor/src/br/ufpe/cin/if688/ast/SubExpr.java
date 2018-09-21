package br.ufpe.cin.if688.ast;

public class SubExpr extends Expr {

	// TODO private...
	public Expr e1, e2;

	public SubExpr(Expr e1, Expr e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

}
