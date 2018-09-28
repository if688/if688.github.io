package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.IVisitor;

public class PairExpList extends ExpList {
	Exp head;
	ExpList tail;

	public PairExpList(Exp h, ExpList t) {
		head = h;
		tail = t;
	}

	public Exp getHead() {
		return head;
	}

	public ExpList getTail() {
		return tail;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}