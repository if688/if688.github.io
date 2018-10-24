package br.ufpe.cin.if688.minijava.ast;

import br.ufpe.cin.if688.minijava.visitor.IVisitor;

public class MethodDecl {
	public Type t;
	public Identifier i;
	public FormalList fl;
	public VarDeclList vl;
	public StatementList sl;
	public Exp e;

	public MethodDecl(Type at, Identifier ai, FormalList afl, VarDeclList avl,
			StatementList asl, Exp ae) {
		t = at;
		i = ai;
		fl = afl;
		vl = avl;
		sl = asl;
		e = ae;
	}

	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
