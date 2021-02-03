package br.ufpe.cin.if688.ast;


public class DivExpr extends Expr {
	// TODO private...
	public Expr e1, e2;

	public DivExpr(Expr e1, Expr e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
}
