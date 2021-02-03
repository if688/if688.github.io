package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.EvalVisitor;
import br.ufpe.cin.if688.visitor.PosFixaVisitor;
import br.ufpe.cin.if688.visitor.PrettyPrintVisitor;

public class Teste {
	public static void main(String[] args) {
		// 25*4+3 ---> 103
		// 25*4 + 3
		NumExpr n3 = new NumExpr(3);
		NumExpr n25 = new NumExpr(25);
		NumExpr n4 = new NumExpr(4);
		
		SumExpr n25_n3 = new SumExpr(n25,n3);		
		
		//SumExpr outra = new SumExpr(n4,new ParExpr(n25_n3));
		SumExpr outra = new SumExpr(n4,n25_n3);
		
		// 25*4
		MulExpr mul25_4 = new MulExpr(n25, n4);
		// (25*4) + 3
		Expr expr = new SumExpr(mul25_4, n3);
		//System.out.println(expr.posFixa() + " = " + expr.eval());

		EvalVisitor v = new EvalVisitor();
		int resultado = v.visit(expr);
		//System.out.println("Resultado: "+resultado);
		PrettyPrintVisitor ppv = new PrettyPrintVisitor();
		ppv.visit(expr);
		PosFixaVisitor pfv = new PosFixaVisitor();
		pfv.visit(expr);
		String prettyPrint = ppv.exp.toString();
		String posFixa = pfv.exp.toString();
		System.out.println(prettyPrint + " = " + posFixa + " = " + resultado);
		
		
		SumExpr exprAlt = new SumExpr(
								new MulExpr(
										new NumExpr(25), 
										new NumExpr(4)
								), 
								new NumExpr(3)
						  );
		
		ppv = new PrettyPrintVisitor();
		ppv.visit(exprAlt);
		pfv = new PosFixaVisitor();
		pfv.visit(exprAlt);
		resultado = v.visit(exprAlt);
		prettyPrint = ppv.exp.toString();
		posFixa = pfv.exp.toString();
		System.out.println(prettyPrint + " = " + posFixa + " = " + resultado);
		/**/
	}
}
