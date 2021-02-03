package br.ufpe.cin.if688.minijava.ast;

import br.ufpe.cin.if688.minijava.visitor.IVisitor;

public class NewObject extends Exp {
	public Identifier i;

	public NewObject(Identifier ai) {
		i = ai;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
