package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.IVisitor;

public class EseqExp extends Exp {
	Stm stm;
	Exp exp;

	public Exp getExp() {
		return exp;
	}

	public Stm getStm() {
		return stm;
	}

	public EseqExp(Stm s, Exp e) {
		stm = s;
		exp = e;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}