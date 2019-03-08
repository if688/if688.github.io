package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.IVisitor;

public class AssignStm extends Stm {

	// x = y
	// ou
	// x = 2
	String id;//x
	Exp exp;//y ou 2

	public Exp getExp() {
		return exp;
	}

	public String getId() {
		return id;
	}

	public AssignStm(String i, Exp e) {
		id = i;
		exp = e;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}