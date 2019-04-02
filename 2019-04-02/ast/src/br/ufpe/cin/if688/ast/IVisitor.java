package br.ufpe.cin.if688.ast;

//ArrayList<String> arr = new ArrayList<>();
//arr.add("aasdasd"); OK
//arr.add(123); NAO OK 

public interface IVisitor<T> {
	T visit(Expr e);
	T visit(NumExpr e);
	T visit(SumExpr e);
	T visit(SubExpr e);
	T visit(DivExpr e);
	T visit(MulExpr e);
}
