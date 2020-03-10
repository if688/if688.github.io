package br.ufpe.cin.if688.ast;

public interface IVisitor<T> {
    T visit(Expr e);
    T visit(SumExpr e);
    T visit(SubExpr e);
    T visit(MulExpr e);
    T visit(DivExpr e);
    T visit(NumExpr e);
}
