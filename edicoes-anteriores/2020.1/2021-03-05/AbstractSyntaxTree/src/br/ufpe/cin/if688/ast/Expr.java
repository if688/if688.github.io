package br.ufpe.cin.if688.ast;

public abstract class Expr {
    public abstract double eval();
    public abstract String posFixa();
    public abstract String prettyPrint();
    //novo metodo significa que tem que implementar este método em todas as subclasses
    //
}
