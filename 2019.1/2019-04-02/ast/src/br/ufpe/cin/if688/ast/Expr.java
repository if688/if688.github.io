package br.ufpe.cin.if688.ast;

public abstract class Expr {
	abstract int accept(EvalVisitor v);
	abstract <T> T accept(IVisitor<T> v);
}
