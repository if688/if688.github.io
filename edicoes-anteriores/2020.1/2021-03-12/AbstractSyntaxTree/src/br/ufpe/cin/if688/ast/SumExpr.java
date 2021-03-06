package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.IVisitor;

public class SumExpr extends Expr {
    public Expr ladoEsquerdo, ladoDireito;

    public SumExpr(Expr esq, Expr dir) {
        ladoEsquerdo = esq;
        ladoDireito = dir;
    }

    @Override
    public <T> T accept(IVisitor<T> v) {
        System.out.println("accept de SumExpr");
        return v.visit(this);
    }
}
