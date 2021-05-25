package br.ufpe.cin.if688.basic;

import java.util.List;

public class WhileStm extends Stm {
    public final BooleanExpr expr;
    public final List<Stm> stmts;

    public WhileStm(BooleanExpr e, List<Stm> stmts) {
        this.expr = e;
        this.stmts = stmts;
    }
}
