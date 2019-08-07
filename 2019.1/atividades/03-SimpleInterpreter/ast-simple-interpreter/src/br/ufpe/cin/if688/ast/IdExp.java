package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.IVisitor;

public class IdExp extends Exp {
	String id;

	public IdExp(String i) {
		id = i;
	}

	public String getId() {
		return id;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}