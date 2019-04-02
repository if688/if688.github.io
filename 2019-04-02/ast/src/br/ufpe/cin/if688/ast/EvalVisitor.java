package br.ufpe.cin.if688.ast;

public class EvalVisitor {
	public int visit(Expr e) {
		System.out.println("visit(Expr e)");
		return e.accept(this);
	}
	public int visit(NumExpr e) {
		System.out.println("visit(NumExpr e)");
		return e.num;
	}
	public int visit(SumExpr e) {
		System.out.println("visit(SumExpr e)");
		int ladoEsquerdo = e.e1.accept(this);
		int ladoDireito = e.e2.accept(this);
		return ladoEsquerdo + ladoDireito;
	}
	public int visit(SubExpr e) {
		System.out.println("visit(SubExpr e)");
		int ladoEsquerdo = e.e1.accept(this);
		int ladoDireito = e.e2.accept(this);
		return ladoEsquerdo - ladoDireito;
	}
	public int visit(DivExpr e) {
		System.out.println("visit(DivExpr e)");
		int ladoEsquerdo = e.e1.accept(this);
		int ladoDireito = e.e2.accept(this);
		if (ladoDireito==0) {
			//TODO melhorar aqui e ter um tratamento de fato
			throw new ArithmeticException("Divisão por zero");
		}
		return ladoEsquerdo / ladoDireito;
	}
	public int visit(MulExpr e) {
		System.out.println("visit(MulExpr e)");
		int ladoEsquerdo = e.e1.accept(this);
		int ladoDireito = e.e2.accept(this);
		return ladoEsquerdo * ladoDireito;
	}
}
