package br.ufpe.cin.compilers.ast.stm;

import br.ufpe.cin.compilers.ast.boolexp.BooleanExp;
import br.ufpe.cin.compilers.visitor.IVisitor;

import java.util.List;

public class WhileStm extends Stm {

	public final BooleanExp exp;
	public final List<Stm> stmts;

	public WhileStm(BooleanExp e, List<Stm> s) {
		exp = e;
		stmts = s;
	}


	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}