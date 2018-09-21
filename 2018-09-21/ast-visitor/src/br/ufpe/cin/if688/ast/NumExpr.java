package br.ufpe.cin.if688.ast;


public class NumExpr extends Expr {
	// volte para private, isso nao eh legal...
	public int num;

	public NumExpr(int n) {
		this.num = n;
	}
}
