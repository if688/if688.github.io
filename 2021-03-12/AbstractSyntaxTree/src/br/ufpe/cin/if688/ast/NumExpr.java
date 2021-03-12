package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.EvalVisitor;
import br.ufpe.cin.if688.visitor.IVisitor;

public class NumExpr extends Expr {
    public int num;

    public NumExpr(int n) {
        num = n;
    }

    @Override
    public <T> T accept(IVisitor<T> v) {
        System.out.println("accept de NumExpr");
        return v.visit(this);
    }
}
