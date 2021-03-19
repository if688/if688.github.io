package br.ufpe.cin.compilers.ast.stm;

import br.ufpe.cin.compilers.ast.exp.Exp;
import br.ufpe.cin.compilers.visitor.IVisitor;

public class AssignStm extends Stm {

	// x = y
	// ou
	// x = 2
	public final String id;//x
	public final Exp exp;//y ou 2

	public AssignStm(String i, Exp e) {
		id = i;
		exp = e;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}