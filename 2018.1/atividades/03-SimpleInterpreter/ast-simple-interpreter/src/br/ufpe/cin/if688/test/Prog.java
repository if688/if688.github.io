package br.ufpe.cin.if688.test;

import br.ufpe.cin.if688.ast.AssignStm;
import br.ufpe.cin.if688.ast.CompoundStm;
import br.ufpe.cin.if688.ast.EseqExp;
import br.ufpe.cin.if688.ast.IdExp;
import br.ufpe.cin.if688.ast.LastExpList;
import br.ufpe.cin.if688.ast.NumExp;
import br.ufpe.cin.if688.ast.OpExp;
import br.ufpe.cin.if688.ast.PairExpList;
import br.ufpe.cin.if688.ast.PrintStm;
import br.ufpe.cin.if688.ast.Stm;

class Prog {
	//a=5+3; b=(print(a,a-1),10*a); print(b)
	static Stm prog = 
		new CompoundStm(
			new AssignStm(
				"a", 
				new OpExp(
					new NumExp(5), 
					OpExp.Plus, 
					new NumExp(3)
				)
			), 
			new CompoundStm(
				new AssignStm(
					"b", 
					new EseqExp(
						new PrintStm(
							new PairExpList(
								new IdExp("a"), 
								new LastExpList(
									new OpExp(
										new IdExp("a"),
										OpExp.Minus, 
										new NumExp(1)
									)
								)
							)
						), 
						new OpExp(
							new NumExp(10), 
							OpExp.Times, 
							new IdExp("a")
						)
					)
				),
				new PrintStm(
					new LastExpList(
						new IdExp("b")
					)
				)
			)
				);
	
	//print(4)
	static Stm print = new PrintStm(new LastExpList(new NumExp(4)));
	
	//print(0,1,2,3,4)
	static Stm print1234 = new PrintStm(
			new PairExpList(
					new NumExp(0),
			new PairExpList(
				new NumExp(1),
				new PairExpList(
					new NumExp(2),
					new PairExpList(
						new NumExp(3),
						new LastExpList(new NumExp(4))	
					)	
				)
			)
			)
	);
	
	//print(print(0,1,2,3,4),5)
	static Stm printPrint = new PrintStm(
				new LastExpList(
					new EseqExp(
						print1234,
						new NumExp(5)
					)
						
				)
	);
	
	//a=512+3; print(a)
	static Stm prog2 = new CompoundStm(
			new AssignStm(
					"a", 
					new OpExp(
							new NumExp(512), 
							OpExp.Plus, 
							new NumExp(3)
					)
			), 
			new PrintStm(
					new LastExpList(
							new IdExp("a")
					)
			)
		);

	//a=512+3; a=515+3;
			static Stm prog3 = new CompoundStm(
					new AssignStm(
							"a", 
							new OpExp(
									new NumExp(512), 
									OpExp.Plus, 
									new NumExp(3)
							)
					), 
					new AssignStm(
							"a", 
							new OpExp(
									new NumExp(515), 
									OpExp.Plus, 
									new NumExp(3)
							)
					)
				);
}
