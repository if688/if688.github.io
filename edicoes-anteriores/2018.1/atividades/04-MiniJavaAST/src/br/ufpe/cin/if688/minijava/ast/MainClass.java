package br.ufpe.cin.if688.minijava.ast;

import br.ufpe.cin.if688.minijava.visitor.IVisitor;

public class MainClass {
	public Identifier i1, i2;
	public Statement s;

	public MainClass(Identifier ai1, Identifier ai2, Statement as) {
		i1 = ai1;
		i2 = ai2;
		s = as;
	}

	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
