package br.ufpe.cin.if688.basic;

public class PrintStm extends Stm {
    public final Expr expr;
    public PrintStm(Expr e) {
        expr = e;
    }
}
