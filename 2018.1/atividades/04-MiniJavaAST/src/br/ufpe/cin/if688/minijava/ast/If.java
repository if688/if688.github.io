package br.ufpe.cin.if688.minijava.ast;

import br.ufpe.cin.if688.minijava.visitor.IVisitor;

public class If extends Statement {
	public Exp e;
	public Statement s1, s2;

	public If(Exp ae, Statement as1, Statement as2) {
		e = ae;
		s1 = as1;
		s2 = as2;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
