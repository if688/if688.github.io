package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.EvalVisitor;
import br.ufpe.cin.if688.visitor.IVisitor;

public class DivExpr extends Expr {
    public Expr ladoEsquerdo, ladoDireito;

    public DivExpr(Expr esq, Expr dir) {
        ladoEsquerdo = esq;
        ladoDireito = dir;
    }

    @Override
    public <T> T accept(IVisitor<T> v) {
        System.out.println("accept de DivExpr");
        return v.visit(this);
    }
}
