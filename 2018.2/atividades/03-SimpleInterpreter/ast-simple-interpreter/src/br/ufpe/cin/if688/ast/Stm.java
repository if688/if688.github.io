package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.IVisitor;

public abstract class Stm {
	public abstract <T> T accept(IVisitor<T> visitor);
}
