package br.ufpe.cin.if688.visitor;

import br.ufpe.cin.if688.ast.*;

public class PosFixaVisitor implements IVisitor<String> {

    @Override
    public String visit(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visit(SumExpr expr) {
        //2 + 3 ---> 2 3 +
        // 2 + (5 * 4) ---> 2 5 4 * +
        StringBuilder sb = new StringBuilder();
        sb.append(expr.ladoEsquerdo.accept(this));
        sb.append(expr.ladoDireito.accept(this));
        sb.append("+ ");
        return sb.toString();
    }

    @Override
    public String visit(SubExpr expr) {
        StringBuilder sb = new StringBuilder();
        sb.append(expr.ladoEsquerdo.accept(this));
        sb.append(expr.ladoDireito.accept(this));
        sb.append("- ");
        return sb.toString();
    }

    @Override
    public String visit(MulExpr expr) {
        StringBuilder sb = new StringBuilder();
        sb.append(expr.ladoEsquerdo.accept(this));
        sb.append(expr.ladoDireito.accept(this));
        sb.append("* ");
        return sb.toString();
    }

    @Override
    public String visit(DivExpr expr) {
        StringBuilder sb = new StringBuilder();
        sb.append(expr.ladoEsquerdo.accept(this));
        sb.append(expr.ladoDireito.accept(this));
        sb.append("/ ");
        return sb.toString();
    }

    @Override
    public String visit(NumExpr expr) {
        StringBuilder sb = new StringBuilder();
        sb.append(expr.num);
        sb.append(' ');
        return sb.toString();
    }
}
