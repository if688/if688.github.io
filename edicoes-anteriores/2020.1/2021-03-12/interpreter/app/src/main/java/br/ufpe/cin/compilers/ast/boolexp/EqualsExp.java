package br.ufpe.cin.compilers.ast.boolexp;

import br.ufpe.cin.compilers.ast.exp.Exp;
import br.ufpe.cin.compilers.visitor.IVisitor;

public class EqualsExp extends BooleanExp {
    public final Exp ladoEsquerdo, ladoDireito;

    public EqualsExp(Exp esq, Exp dir) {
        ladoEsquerdo = esq;
        ladoDireito = dir;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
