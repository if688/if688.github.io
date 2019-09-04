package br.ufpe.cin.if688.ast;

public class PosFixaVisitor implements IVisitor<Void> {
    private StringBuilder sb;
    public PosFixaVisitor(){
        sb = new StringBuilder();
    }
    @Override
    public Void visit(Expr e) {
        return e.accept(this);
    }

    @Override
    public Void visit(SumExpr e) {
        e.ladoEsquerdo.accept(this);
        e.ladoDireito.accept(this);
        sb.append('+');
        sb.append(' ');

        return null;
    }

    @Override
    public Void visit(SubExpr e) {
        //TODO completar com implementação
        return null;
    }

    @Override
    public Void visit(MulExpr e) {
        //TODO completar com implementação
        return null;
    }

    @Override
    public Void visit(DivExpr e) {
        //TODO completar com implementação
        return null;
    }

    @Override
    public Void visit(NumExpr e) {
        sb.append(e.num);
        sb.append(' ');
        return null;
    }

    public String posFixa() {
        return sb.toString();
    }
}
