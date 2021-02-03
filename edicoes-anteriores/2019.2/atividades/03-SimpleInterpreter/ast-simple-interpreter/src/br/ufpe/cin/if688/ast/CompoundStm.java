package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.IVisitor;

public class CompoundStm extends Stm {
	// x=1; y=x;
	Stm stm1, stm2;

	public CompoundStm(Stm s1, Stm s2) {
		stm1 = s1;
		stm2 = s2;
	}

	public Stm getStm1() {
		return stm1;
	}

	public Stm getStm2() {
		return stm2;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}