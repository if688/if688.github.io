package br.ufpe.cin.if688.ast;

public class NumExpr extends Expr {
    double num;
    public NumExpr(double n) {
        num = n;
    }

    @Override
    double eval() {
        return num;
    }

    @Override
    String posFixa() {
        return ""+num+ " ";
    }

    @Override
    public String toString() {
        return ""+num;
    }

    @Override
    <T> T accept(IVisitor<T> v) {
        System.out.println("accept dentro de NumExpr");
        return v.visit(this);
    }
}
