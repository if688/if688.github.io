package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.IVisitor;

public class NumExp extends Exp {
	int num;

	public NumExp(int n) {
		num = n;
	}

	public int getNum() {
		return num;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}