package br.ufpe.cin.compilers.ast.exp;

import br.ufpe.cin.compilers.visitor.IVisitor;

public class MulExp extends Exp {
    public final Exp ladoEsquerdo, ladoDireito;

    public MulExp(Exp esq, Exp dir) {
        ladoEsquerdo = esq;
        ladoDireito = dir;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
