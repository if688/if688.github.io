package br.ufpe.cin.compilers.ast.stm;

import br.ufpe.cin.compilers.visitor.IVisitor;

public abstract class Stm {
	public abstract <T> T accept(IVisitor<T> visitor);
}
