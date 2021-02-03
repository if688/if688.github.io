package br.ufpe.cin.if688.visitor;

import br.ufpe.cin.if688.ast.AssignStm;
import br.ufpe.cin.if688.ast.CompoundStm;
import br.ufpe.cin.if688.ast.EseqExp;
import br.ufpe.cin.if688.ast.Exp;
import br.ufpe.cin.if688.ast.ExpList;
import br.ufpe.cin.if688.ast.IdExp;
import br.ufpe.cin.if688.ast.LastExpList;
import br.ufpe.cin.if688.ast.NumExp;
import br.ufpe.cin.if688.ast.OpExp;
import br.ufpe.cin.if688.ast.PairExpList;
import br.ufpe.cin.if688.ast.PrintStm;
import br.ufpe.cin.if688.ast.Stm;

public interface IVisitor<T> {
	T visit(Stm s);
	T visit(AssignStm s);
	T visit(CompoundStm s);
	T visit(PrintStm s);
	
	T visit(Exp e);
	T visit(EseqExp e);
	T visit(IdExp e);
	T visit(NumExp e);
	T visit(OpExp e);
	
	T visit(ExpList el);
	T visit(PairExpList el);
	T visit(LastExpList el);
}
