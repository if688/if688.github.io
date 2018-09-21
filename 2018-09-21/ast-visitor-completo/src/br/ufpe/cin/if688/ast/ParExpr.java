package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.EvalVisitor;
import br.ufpe.cin.if688.visitor.IVisitor;
import br.ufpe.cin.if688.visitor.IntVisitor;
import br.ufpe.cin.if688.visitor.VoidVisitor;

public class ParExpr extends Expr {

	// TODO private...
	public Expr e;

	public ParExpr(Expr e) {
		this.e = e;
	}

	@Override
	public String toString() {
		return " ( " + e.toString() + " ) ";
	}

	@Override
	public <T> T accept(IVisitor<T> v) {
		// Exibe apenas quando estiver rodando EvalVisitor,
		// para não poluir toda vez que rodar um visitor qualquer.
		if (v instanceof EvalVisitor) {
			System.out.println("accept de ParExpr");
		}
		return v.visit(this);
	}

	// Todos os métodos daqui pra baixo são 'desnecessários'
	// ao usarmos o Visitor com Generics.
	@Override
	public double eval() {
		return e.eval();
	}

	@Override
	public String prettyPrint() {
		return this.toString();
	}

	@Override
	public String posFixa() {
		return e.posFixa();
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
