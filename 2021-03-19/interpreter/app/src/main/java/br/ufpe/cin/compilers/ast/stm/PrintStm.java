package br.ufpe.cin.compilers.ast.stm;

import br.ufpe.cin.compilers.ast.exp.Exp;
import br.ufpe.cin.compilers.visitor.IVisitor;

public class PrintStm extends Stm {

	public final Exp exp;

	public PrintStm(Exp e) {
		exp = e;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}