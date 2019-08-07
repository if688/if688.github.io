package br.ufpe.cin.if688.ast;

public class NumExpr extends Expr {
	int num;
	public NumExpr(int n) {
		this.num = n;
	}
	@Override
	public String toString() {
		return this.num+"";
	}
	@Override
	public int eval() {
		return num;
	}
	@Override
	String posFixa() {
		return num + " ";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
