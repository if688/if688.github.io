package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.EvalVisitor;
import br.ufpe.cin.if688.visitor.IVisitor;

public class MulExpr extends Expr {
    public Expr ladoEsquerdo, ladoDireito;

    public MulExpr(Expr esq, Expr dir) {
        ladoEsquerdo = esq;
        ladoDireito = dir;
    }

    @Override
    public <T> T accept(IVisitor<T> v) {
        System.out.println("accept de MulExpr");
        return v.visit(this);
    }
}
