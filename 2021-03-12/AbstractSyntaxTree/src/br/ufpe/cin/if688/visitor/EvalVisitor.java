package br.ufpe.cin.if688.visitor;

import br.ufpe.cin.if688.ast.*;

public class EvalVisitor implements IVisitor<Double> {
    @Override
    public Double visit(Expr expr) {
        System.out.println("visit(Expr expr)");
        return expr.accept(this);
    }
    @Override
    public Double visit(SumExpr expr) {
        System.out.println("visit(SumExpr expr)");
        return expr.ladoEsquerdo.accept(this) + expr.ladoDireito.accept(this);
    }
    @Override
    public Double visit(SubExpr expr) {
        System.out.println("visit(SubExpr expr)");
        return expr.ladoEsquerdo.accept(this) - expr.ladoDireito.accept(this);
    }
    @Override
    public Double visit(MulExpr expr) {
        System.out.println("visit(MulExpr expr)");
        return expr.ladoEsquerdo.accept(this) * expr.ladoDireito.accept(this);
    }
    @Override
    public Double visit(DivExpr expr) {
        System.out.println("visit(DivExpr expr)");
        return expr.ladoEsquerdo.accept(this) / expr.ladoDireito.accept(this);
    }
    @Override
    public Double visit(NumExpr expr) {
        System.out.println("visit(NumExpr expr)");
        return Double.valueOf(expr.num);
    }
}
