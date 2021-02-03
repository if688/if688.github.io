package br.ufpe.cin.if688.minijava.ast;
import br.ufpe.cin.if688.minijava.visitor.IVisitor;

public class BooleanType extends Type {
	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
