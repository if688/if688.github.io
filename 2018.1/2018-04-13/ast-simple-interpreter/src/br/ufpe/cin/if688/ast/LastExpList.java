package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.IVisitor;

public class LastExpList extends ExpList {
	Exp head;

	public LastExpList(Exp h) {
		head = h;
	}

	public Exp getHead() {
		return head;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}