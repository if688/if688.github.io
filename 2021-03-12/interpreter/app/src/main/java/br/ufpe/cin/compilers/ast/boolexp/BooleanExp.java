package br.ufpe.cin.compilers.ast.boolexp;

import br.ufpe.cin.compilers.visitor.IVisitor;

public abstract class BooleanExp {
	public abstract <T> T accept(IVisitor<T> visitor);
}
