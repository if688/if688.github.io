package br.ufpe.cin.compilers.ast.exp;

import br.ufpe.cin.compilers.visitor.IVisitor;

public abstract class Exp {
	public abstract <T> T accept(IVisitor<T> visitor);
}
