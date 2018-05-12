package br.ufpe.cin.if688.minijava.ast;

import br.ufpe.cin.if688.minijava.visitor.IVisitor;

public class Program {
	public MainClass m;
	public ClassDeclList cl;

	public Program(MainClass am, ClassDeclList acl) {
		m = am;
		cl = acl;
	}

	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
