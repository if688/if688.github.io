package br.ufpe.cin.compilers.ast;

import br.ufpe.cin.compilers.ast.stm.Stm;

import java.util.List;

public class Program {
    private List<Stm> statements;
    public Program(List<Stm> stms) {
        statements = stms;
    }

    public void addStatement(Stm s) {
        statements.add(s);
    }

    public int size() {
        return statements.size();
    }

    public Stm getStm(int i) {
        return statements.get(i);
    }

    public List<Stm> stmts() {
        return statements;
    }
}
