package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.IVisitor;

public class PrintStm extends Stm {
	//print(1,x,y,4) --> 4
	// print(1,2,3,4,(print(1,2,3,4,5,6,7),9)) --> 7
	ExpList exps;

	public PrintStm(ExpList e) {
		exps = e;
	}

	public ExpList getExps() {
		return exps;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}