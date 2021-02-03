package br.ufpe.cin.if688.minijava.ast;

import br.ufpe.cin.if688.minijava.visitor.IVisitor;

public abstract class Type {
	public abstract <T> T accept(IVisitor<T> visitor);
}
