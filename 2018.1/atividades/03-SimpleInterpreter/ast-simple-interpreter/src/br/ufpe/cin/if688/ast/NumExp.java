package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.IVisitor;

public class NumExp extends Exp {
	double num;

	public NumExp(double n) {
		num = n;
	}

	public double getNum() {
		return num;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
