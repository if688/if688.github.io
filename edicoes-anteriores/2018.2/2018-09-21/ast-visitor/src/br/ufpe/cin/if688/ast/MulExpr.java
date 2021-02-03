package br.ufpe.cin.if688.ast;


public class MulExpr extends Expr {

	// TODO private...
	public Expr e1, e2;

	public MulExpr(Expr e1, Expr e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

}
