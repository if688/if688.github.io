package br.ufpe.cin.if688.minijava.ast;

import br.ufpe.cin.if688.minijava.visitor.IVisitor;

public class Identifier {
	public String s;

	public Identifier(String as) {
		s = as;
	}

	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		return s;
	}
}
