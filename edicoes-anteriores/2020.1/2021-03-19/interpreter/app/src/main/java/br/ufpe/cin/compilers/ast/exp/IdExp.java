package br.ufpe.cin.compilers.ast.exp;

import br.ufpe.cin.compilers.visitor.IVisitor;

public class IdExp extends Exp {
	public final String id;

	public IdExp(String i) {
		id = i;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}