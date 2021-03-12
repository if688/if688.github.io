package br.ufpe.cin.compilers.visitor;

import br.ufpe.cin.compilers.ast.Program;
import br.ufpe.cin.compilers.ast.boolexp.*;
import br.ufpe.cin.compilers.ast.exp.*;
import br.ufpe.cin.compilers.ast.stm.*;
import br.ufpe.cin.compilers.symboltable.SymbolTable;

public class Interpreter implements IVisitor<Void> {

    SymbolTable symbolTable;
    public Interpreter(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public Void visit(Program p) {
        for (Stm s : p.stmts()) {
            s.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Stm s) {
        return s.accept(this);
    }

    @Override
    public Void visit(AssignStm s) {
        if (s.exp instanceof NumExp) {
            NumExp n = (NumExp) s.exp;
            symbolTable.updateVariable(s.id, n.num);
        }
        return null;
    }

    @Override
    public Void visit(GotoStm s) {
        return null;
    }

    @Override
    public Void visit(IfStm s) {
        return null;
    }

    @Override
    public Void visit(InputStm s) {
        return null;
    }

    @Override
    public Void visit(LabelStm s) {
        return null;
    }

    @Override
    public Void visit(PrintStm s) {
        if (s.exp instanceof StringExp) {
            StringExp str = (StringExp) s.exp;
            System.out.println(str.str);
        }
        else if (s.exp instanceof IdExp) {
            IdExp str = (IdExp) s.exp;
            System.out.println(symbolTable.getValue(str.id));
        }
        return null;
    }

    @Override
    public Void visit(WhileStm s) {
        return null;
    }

    @Override
    public Void visit(Exp e) {
        return null;
    }

    @Override
    public Void visit(IdExp e) {
        return null;
    }

    @Override
    public Void visit(NumExp e) {
        return null;
    }

    @Override
    public Void visit(StringExp e) {
        return null;
    }

    @Override
    public Void visit(SumExp e) {
        return null;
    }

    @Override
    public Void visit(SubExp e) {
        return null;
    }

    @Override
    public Void visit(MulExp e) {
        return null;
    }

    @Override
    public Void visit(DivExp e) {
        return null;
    }

    @Override
    public Void visit(BooleanExp be) {
        return null;
    }

    @Override
    public Void visit(EqualsExp e) {
        return null;
    }

    @Override
    public Void visit(NotEqualsExp e) {
        return null;
    }

    @Override
    public Void visit(LessThanEqualsExp e) {
        return null;
    }

    @Override
    public Void visit(GreatherThanEqualsExp e) {
        return null;
    }

    @Override
    public Void visit(GreatherThanExp e) {
        return null;
    }

    @Override
    public Void visit(LessThanExp e) {
        return null;
    }
}
