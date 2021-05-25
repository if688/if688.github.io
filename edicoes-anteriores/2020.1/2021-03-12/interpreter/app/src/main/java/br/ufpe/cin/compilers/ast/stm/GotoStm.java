package br.ufpe.cin.compilers.ast.stm;

import br.ufpe.cin.compilers.ast.exp.Exp;
import br.ufpe.cin.compilers.visitor.IVisitor;

public class GotoStm extends Stm {

	public final String id;

	public GotoStm(String i) {
		id = i;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}