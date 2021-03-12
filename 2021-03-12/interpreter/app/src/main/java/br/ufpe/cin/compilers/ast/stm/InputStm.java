package br.ufpe.cin.compilers.ast.stm;

import br.ufpe.cin.compilers.visitor.IVisitor;

public class InputStm extends Stm {

	public final String id;

	public InputStm(String i) {
		id = i;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}