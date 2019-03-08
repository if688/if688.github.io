package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.EvalVisitor;
import br.ufpe.cin.if688.visitor.IVisitor;
import br.ufpe.cin.if688.visitor.IntVisitor;
import br.ufpe.cin.if688.visitor.VoidVisitor;

public class SumExpr extends Expr {
	// TODO volte para private, come back!
	public Expr e1, e2;

	public SumExpr(Expr e1, Expr e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	@Override
	public String toString() {
		return e1.toString() + " + " + e2.toString();
	}

	@Override
	public <T> T accept(IVisitor<T> v) {
		// Exibe apenas quando estiver rodando EvalVisitor,
		// para não poluir toda vez que rodar um visitor qualquer.
		if (v instanceof EvalVisitor) {
			System.out.println("accept de SumExpr");
		}
		return v.visit(this);
	}

	// Todos os métodos daqui pra baixo são 'desnecessários'
	// ao usarmos o Visitor com Generics.
	@Override
	public double eval() {
		return e1.eval() + e2.eval();
	}

	@Override
	public String prettyPrint() {
		return this.toString();
	}

	@Override
	public String posFixa() {
		return e1.posFixa() + " " + e2.posFixa() + " + ";
	}

	@Override
	public int accept(IntVisitor v) {
		return v.visit(this);
	}

	@Override
	public void accept(VoidVisitor v) {
		v.visit(this);
	}

}
