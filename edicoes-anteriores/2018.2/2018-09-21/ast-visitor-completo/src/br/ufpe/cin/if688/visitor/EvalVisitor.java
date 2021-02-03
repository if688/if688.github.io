package br.ufpe.cin.if688.visitor;

import br.ufpe.cin.if688.ast.DivExpr;
import br.ufpe.cin.if688.ast.Expr;
import br.ufpe.cin.if688.ast.MulExpr;
import br.ufpe.cin.if688.ast.NumExpr;
import br.ufpe.cin.if688.ast.ParExpr;
import br.ufpe.cin.if688.ast.SubExpr;
import br.ufpe.cin.if688.ast.SumExpr;

public class EvalVisitor implements IVisitor<Integer> {

	@Override
	public Integer visit(Expr e) {
		System.out.println("visit(Expr e) - " + e.toString());
		return e.accept(this);
	}

	@Override
	public Integer visit(NumExpr e) {
		System.out.println("visit(NumExpr e) - " + e.toString());
		return e.num;
	}

	@Override
	public Integer visit(SumExpr e) {
		System.out.println("visit(SumExpr e) - " + e.toString());
		return e.e1.accept(this) + e.e2.accept(this);
	}

	@Override
	public Integer visit(MulExpr e) {
		System.out.println("visit(MulExpr e) - " + e.toString());
		return e.e1.accept(this) * e.e2.accept(this);
	}

	@Override
	public Integer visit(SubExpr e) {
		System.out.println("visit(SubExpr e) - " + e.toString());
		return e.e1.accept(this) - e.e2.accept(this);
	}

	@Override
	public Integer visit(DivExpr e) {
		System.out.println("visit(DivExpr e) - " + e.toString());
		//TODO evitar divisao por zero
		return e.e1.accept(this) / e.e2.accept(this);
	}

	@Override
	public Integer visit(ParExpr e) {
		System.out.println("visit(ParExpr e) - " + e.toString());
		return e.e.accept(this);
	}

}
