package br.ufpe.cin.compilers.visitor;

import br.ufpe.cin.compilers.ast.Program;
import br.ufpe.cin.compilers.ast.boolexp.*;
import br.ufpe.cin.compilers.ast.exp.*;
import br.ufpe.cin.compilers.ast.stm.*;

public interface IVisitor<T> {
	T visit(Program p);

	T visit(Stm s);
	T visit(AssignStm s);
	T visit(GotoStm s);
	T visit(IfStm s);
	T visit(InputStm s);
	T visit(LabelStm s);
	T visit(PrintStm s);
	T visit(WhileStm s);
	
	T visit(Exp e);
	T visit(IdExp e);
	T visit(NumExp e);
	T visit(StringExp e);
	T visit(SumExp e);
	T visit(SubExp e);
	T visit(MulExp e);
	T visit(DivExp e);

	T visit(BooleanExp be);
	T visit(EqualsExp e);
	T visit(NotEqualsExp e);
	T visit(LessThanEqualsExp e);
	T visit(GreatherThanEqualsExp e);
	T visit(GreatherThanExp e);
	T visit(LessThanExp e);
}
