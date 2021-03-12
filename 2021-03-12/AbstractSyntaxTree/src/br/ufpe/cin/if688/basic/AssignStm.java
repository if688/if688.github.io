package br.ufpe.cin.if688.basic;

public class AssignStm extends Stm {

    public final String id;//nome da variável
    public final Expr expr;

    public AssignStm(String id, Expr e) {
        this.id = id;
        this.expr = e;
    }
}
