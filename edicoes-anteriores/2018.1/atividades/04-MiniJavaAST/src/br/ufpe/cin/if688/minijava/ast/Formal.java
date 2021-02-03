package br.ufpe.cin.if688.minijava.ast;

import br.ufpe.cin.if688.minijava.visitor.IVisitor;

public class Formal {
	public Type t;
	public Identifier i;

	public Formal(Type at, Identifier ai) {
		t = at;
		i = ai;
	}

	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
