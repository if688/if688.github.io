package br.ufpe.cin.if688.ast;

public class SubExpr extends Expr {
    public Expr ladoEsquerdo, ladoDireito;

    public SubExpr(Expr esq, Expr dir) {
        ladoEsquerdo = esq;
        ladoDireito = dir;
    }

    @Override
    public double eval() {
        return ladoEsquerdo.eval() - ladoDireito.eval();
    }

    @Override
    public String posFixa() {
        //2+3 --> versão pós-fixa é '2 3 +'
        return ladoEsquerdo.posFixa() + ladoDireito.posFixa() + " -";
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        if (!(ladoEsquerdo instanceof NumExpr)) {
            sb.append('(');
        }
        sb.append(ladoEsquerdo.prettyPrint());
        if (!(ladoEsquerdo instanceof NumExpr)) {
            sb.append(')');
        }
        sb.append(" - ");
        if (!(ladoDireito instanceof NumExpr)) {
            sb.append('(');
        }
        sb.append(ladoDireito.prettyPrint());
        if (!(ladoDireito instanceof NumExpr)) {
            sb.append(')');
        }

        return sb.toString();
    }
}
