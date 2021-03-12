package br.ufpe.cin.if688.visitor;

import br.ufpe.cin.if688.ast.*;

public interface IVisitor<T> {
    T visit(Expr expr);

    T visit(SumExpr expr);

    T visit(SubExpr expr);

    T visit(MulExpr expr);

    T visit(DivExpr expr);

    T visit(NumExpr expr);
}
