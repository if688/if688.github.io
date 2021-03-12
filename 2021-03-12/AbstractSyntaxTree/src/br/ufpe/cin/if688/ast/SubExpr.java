package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.EvalVisitor;
import br.ufpe.cin.if688.visitor.IVisitor;

public class SubExpr extends Expr {
    public Expr ladoEsquerdo, ladoDireito;

    public SubExpr(Expr esq, Expr dir) {
        ladoEsquerdo = esq;
        ladoDireito = dir;
    }

    @Override
    public <T> T accept(IVisitor<T> v) {
        System.out.println("accept de SubExpr");
        return v.visit(this);
    }
}
