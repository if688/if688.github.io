package br.ufpe.cin.if688.ast;

public class SubExpr extends Expr {
    Expr ladoEsquerdo, ladoDireito;
    public SubExpr(Expr esq, Expr dir) {
        ladoEsquerdo = esq;
        ladoDireito = dir;
    }

    @Override
    double eval() {
        return ladoEsquerdo.eval() - ladoDireito.eval();
    }

    @Override
    String posFixa() {
        return ladoEsquerdo.posFixa() + ladoDireito.posFixa() + " -";
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!(ladoEsquerdo instanceof NumExpr)) {
            sb.append('(');
        }
        sb.append(ladoEsquerdo.toString());
        if (!(ladoEsquerdo instanceof NumExpr)) {
            sb.append(')');
        }
        sb.append(" - ");
        if (!(ladoDireito instanceof NumExpr)) {
            sb.append('(');
        }
        sb.append(ladoDireito.toString());
        if (!(ladoDireito instanceof NumExpr)) {
            sb.append(')');
        }

        return sb.toString();
    }

    @Override
    <T> T accept(IVisitor<T> v) {
        return v.visit(this);
    }
}
