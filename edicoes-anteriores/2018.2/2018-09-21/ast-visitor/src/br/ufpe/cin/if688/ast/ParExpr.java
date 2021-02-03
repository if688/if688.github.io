package br.ufpe.cin.if688.ast;


public class ParExpr extends Expr {

	// TODO private...
	public Expr e;

	public ParExpr(Expr e) {
		this.e = e;
	}

}
