package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.IVisitor;

public class OpExp extends Exp {
	Exp left, right;
	int oper;

	// if Opexp.oper == 1 --> soma
	public final static int Plus = 1, Minus = 2, Times = 3, Div = 4;

	public OpExp(Exp l, int o, Exp r) {
		left = l;
		oper = o;
		right = r;
	}

	public Exp getLeft() {
		return left;
	}

	public Exp getRight() {
		return right;
	}

	public int getOper() {
		return oper;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}