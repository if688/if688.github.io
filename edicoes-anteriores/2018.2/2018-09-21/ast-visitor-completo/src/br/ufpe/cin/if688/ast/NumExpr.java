package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.EvalVisitor;
import br.ufpe.cin.if688.visitor.IVisitor;
import br.ufpe.cin.if688.visitor.IntVisitor;
import br.ufpe.cin.if688.visitor.VoidVisitor;

public class NumExpr extends Expr {
	// volte para private, isso nao eh legal...
	public int num;

	public int getNum() {
		return num;
	}

	public NumExpr(int n) {
		this.num = n;
	}

	@Override
	public String toString() {
		return " " + num + " ";
	}

	@Override
	public <T> T accept(IVisitor<T> v) {
		// Exibe apenas quando estiver rodando EvalVisitor,
		// para não poluir toda vez que rodar um visitor qualquer.
		if (v instanceof EvalVisitor) {
			System.out.println("accept de NumExpr");
		}
		return v.visit(this);
	}

	// Todos os métodos daqui pra baixo são 'desnecessários'
	// ao usarmos o Visitor com Generics.

	@Override
	public double eval() {
		return num;
	}

	@Override
	public String prettyPrint() {
		return this.toString();
	}

	@Override
	public String posFixa() {
		return this.toString();
	}

	public <T> boolean teste(T algo) {
		return true;
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
