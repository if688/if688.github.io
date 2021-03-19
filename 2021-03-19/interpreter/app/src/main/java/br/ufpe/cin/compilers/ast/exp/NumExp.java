package br.ufpe.cin.compilers.ast.exp;

import br.ufpe.cin.compilers.visitor.IVisitor;

public class NumExp extends Exp {
	public final int num;

	public NumExp(int n) {
		num = n;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
