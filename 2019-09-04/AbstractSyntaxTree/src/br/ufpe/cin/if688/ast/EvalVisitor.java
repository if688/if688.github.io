package br.ufpe.cin.if688.ast;

public class EvalVisitor implements IVisitor<Double> {

    @Override
    public Double visit(Expr e) {
        System.out.println("visit(Expr e)");
        return e.accept(this);
    }

    @Override
    public Double visit(SumExpr e) {
        System.out.println("visit(SumExpr e)");
        double ladoEsq = e.ladoEsquerdo.accept(this);
        double ladoDir = e.ladoDireito.accept(this);
        return ladoEsq + ladoDir;
    }

    @Override
    public Double visit(SubExpr e) {
        System.out.println("visit(SubExpr e)");
        double ladoEsq = e.ladoEsquerdo.accept(this);
        double ladoDir = e.ladoDireito.accept(this);
        return ladoEsq - ladoDir;
    }

    @Override
    public Double visit(MulExpr e) {
        System.out.println("visit(MulExpr e)");
        double ladoEsq = e.ladoEsquerdo.accept(this);
        double ladoDir = e.ladoDireito.accept(this);
        return ladoEsq * ladoDir;
    }

    @Override
    public Double visit(DivExpr e) {
        System.out.println("visit(DivExpr e)");
        double ladoEsq = e.ladoEsquerdo.accept(this);
        double ladoDir = e.ladoDireito.accept(this);
        return ladoEsq / ladoDir;
    }

    @Override
    public Double visit(NumExpr e) {
        System.out.println("visit(NumExpr e)");
        return e.num;
    }
}
