package br.ufpe.cin.if688.ast;

public class NumExpr extends Expr {
    int num;

    public NumExpr(int n) {
        num = n;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public double eval() {
        return num;
    }

    @Override
    public String posFixa() {
        return this.toString()+' ';
    }

    @Override
    public String prettyPrint() {
        return this.toString();
    }
}
