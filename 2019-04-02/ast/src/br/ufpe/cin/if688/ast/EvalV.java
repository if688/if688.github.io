package br.ufpe.cin.if688.ast;

public class EvalV implements IVisitor<Integer> {
	@Override
	public Integer visit(Expr e) {
		return e.accept(this);
	}
	@Override
	public Integer visit(NumExpr e) {
		return e.num;
	}
	@Override
	public Integer visit(SumExpr e) {
		return e.e1.accept(this) + e.e2.accept(this);
	}
	@Override
	public Integer visit(SubExpr e) {
		return e.e1.accept(this) - e.e2.accept(this);
	}

	@Override
	public Integer visit(DivExpr e) {
		return e.e1.accept(this) / e.e2.accept(this);
	}

	@Override
	public Integer visit(MulExpr e) {
		return e.e1.accept(this) * e.e2.accept(this);
	}

}
