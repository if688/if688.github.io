package br.ufpe.cin.compilers.ast.exp;

import br.ufpe.cin.compilers.visitor.IVisitor;

public class SumExp extends Exp {
    public final Exp ladoEsquerdo, ladoDireito;

    public SumExp(Exp esq, Exp dir) {
        ladoEsquerdo = esq;
        ladoDireito = dir;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
