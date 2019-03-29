package br.ufpe.cin.if688.ast;

public class SumExpr extends Expr {
	Expr e1, e2;
	public SumExpr(Expr e1,Expr e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	@Override
	public String toString() {
		return "(" + e1.toString() + " + " + e2 + ")";
		//return e1 + " + " + e2;
	}
	@Override
	public int eval() {
		return e1.eval() + e2.eval();
	}			
	
	@Override
	String posFixa() {
		return e1.posFixa() + e2.posFixa() +  "+ ";
	}
	
	
	
	
	
	
	
}
	