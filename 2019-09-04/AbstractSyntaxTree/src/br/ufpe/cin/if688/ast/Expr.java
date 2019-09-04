package br.ufpe.cin.if688.ast;

public abstract class Expr {
    abstract String posFixa();
    abstract double eval();

    //No fim das contas, só vai precisar disso aqui
    abstract <T> T accept(IVisitor<T> v);
}
