package br.ufpe.cin.if688.minijava.ast;

import br.ufpe.cin.if688.minijava.visitor.IVisitor;

public class ArrayAssign extends Statement {
	public Identifier i;
	public Exp e1, e2;

	public ArrayAssign(Identifier ai, Exp ae1, Exp ae2) {
		i = ai;
		e1 = ae1;
		e2 = ae2;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
