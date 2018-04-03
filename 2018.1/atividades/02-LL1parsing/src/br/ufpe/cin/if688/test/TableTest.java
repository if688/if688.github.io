package br.ufpe.cin.if688.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;

import br.ufpe.cin.if688.parsing.analysis.GeneralSymbol;
import br.ufpe.cin.if688.parsing.analysis.SpecialSymbol;
import br.ufpe.cin.if688.parsing.grammar.Grammar;
import br.ufpe.cin.if688.parsing.grammar.Nonterminal;
import br.ufpe.cin.if688.parsing.grammar.Production;
import br.ufpe.cin.if688.parsing.grammar.Terminal;
import br.ufpe.cin.if688.table.NotLL1Exception;
import br.ufpe.cin.if688.table.LL1Key;
import br.ufpe.cin.if688.table.Table;

public class TableTest extends TestCase{

	public void testTableG1() throws NotLL1Exception {
		/*
		 * Gramática de exemplo:
		 *  A -> aB
		 *  B -> cC
		 *  C -> d
		 * 
		 */
		
		Nonterminal start = new Nonterminal("A");
		Nonterminal B = new Nonterminal("B");
		Nonterminal C = new Nonterminal("C");
		Terminal a = new Terminal("a");
		Terminal c = new Terminal("c");
		Terminal d = new Terminal("d");
		
		List<GeneralSymbol> prodA = new ArrayList<GeneralSymbol>(); 
		prodA.add(a);
		prodA.add(B);
						
		List<GeneralSymbol> prodB = new ArrayList<GeneralSymbol>();
		prodB.add(c);
		prodB.add(C);
		
		List<GeneralSymbol> prodC = new ArrayList<GeneralSymbol>();
		prodC.add(d);

		Production fpA = new Production(start, prodA);
		Production pB = new Production(B, prodB);
		Production pC = new Production(C, prodC);
		
		Collection<Production> col = new ArrayList<Production>();
		col.add(fpA);
		col.add(pB);
		col.add(pC);
		
		Grammar g = new Grammar(col, start);
		
		Map<LL1Key, List<GeneralSymbol>> table = Table.createTable(g);
		Map<LL1Key, List<GeneralSymbol>> expected = new HashMap<LL1Key, List<GeneralSymbol>>();
		
		LL1Key Aa = searchTable(table, start, a);
		LL1Key Bc = searchTable(table, B, c);
		LL1Key Cd = searchTable(table, C, d);
		
		ArrayList<GeneralSymbol> aB = new ArrayList<GeneralSymbol>();
		aB.add(a);
		aB.add(B);
		
		ArrayList<GeneralSymbol> cC = new ArrayList<GeneralSymbol>();
		cC.add(c);
		cC.add(C);
		
		ArrayList<GeneralSymbol> d_ = new ArrayList<GeneralSymbol>();
		d_.add(d);
		
		expected.put(Aa, aB);
		expected.put(Bc, cC);
		expected.put(Cd, d_);
		
		assertEquals(expected, table);	
	}
	
	public void testTableG2() throws NotLL1Exception {
		/*
		 * Gramatica de exemplo
		 * S -> aABe
		 * A -> bK
		 * K -> bcK | ε
		 * B -> d
		*/ 
		
		Nonterminal S = new Nonterminal("S");
		Nonterminal A = new Nonterminal("A");
		Nonterminal B = new Nonterminal("B");
		Nonterminal K = new Nonterminal("K");
		
		Terminal a = new Terminal("a");
		Terminal b = new Terminal("b");
		Terminal c = new Terminal("c");
		Terminal d = new Terminal("d");
		Terminal e = new Terminal("e");
		
		List<GeneralSymbol> prodS = new ArrayList<GeneralSymbol>();
		prodS.add(a);
		prodS.add(A);
		prodS.add(B);
		prodS.add(e);
		
		List<GeneralSymbol> prodA = new ArrayList<GeneralSymbol>();
		prodA.add(b);
		prodA.add(K);
		
		List<GeneralSymbol> prodK1 = new ArrayList<GeneralSymbol>();
		prodK1.add(b);
		prodK1.add(c);
		prodK1.add(K);
		
		List<GeneralSymbol> prodK2 = new ArrayList<GeneralSymbol>();
		prodK2.add(SpecialSymbol.EPSILON);
		
		List<GeneralSymbol> prodB = new ArrayList<GeneralSymbol>();
		prodB.add(d);
		
		Production pS = new Production(S, prodS);
		Production pA = new Production(A, prodA);
		Production pK1 = new Production(K, prodK1);
		Production pK2 = new Production(K, prodK2);
		Production pB = new Production(B, prodB);
		
		Collection<Production> collection = new ArrayList<Production>();
		collection.add(pS);
		collection.add(pA);
		collection.add(pK1);
		collection.add(pK2);
		collection.add(pB);

		Grammar g = new Grammar(collection, S);
		
		Map<LL1Key, List<GeneralSymbol>> table = Table.createTable(g);
		Map<LL1Key, List<GeneralSymbol>> expected = new HashMap<LL1Key, List<GeneralSymbol>>();
		
		LL1Key Ab = searchTable(table, A, b);
		LL1Key Sa = searchTable(table, S, a);
		LL1Key Kd = searchTable(table, K, d);
		LL1Key Kb = searchTable(table, K, b);
		LL1Key Bd = searchTable(table, B, d);
		
		List<GeneralSymbol> bK = new ArrayList<GeneralSymbol>();
		bK.add(b);
		bK.add(K);
		
		List<GeneralSymbol> aABe = new ArrayList<GeneralSymbol>();
		aABe.add(a);
		aABe.add(A);
		aABe.add(B);
		aABe.add(e);
		
		List<GeneralSymbol> kdeps = new ArrayList<GeneralSymbol>();
		kdeps.add(SpecialSymbol.EPSILON);
		
		List<GeneralSymbol> bcK = new ArrayList<GeneralSymbol>();
		bcK.add(b);
		bcK.add(c);
		bcK.add(K);
		
		List<GeneralSymbol> d_ = new ArrayList<GeneralSymbol>();
		d_.add(d);
		
		expected.put(Ab, bK);
		expected.put(Sa, aABe);
		expected.put(Kd, kdeps);
		expected.put(Kb, bcK);
		expected.put(Bd, d_);
		
		assertEquals(expected, table);	
	}
	
	private LL1Key searchTable(Map<LL1Key, List<GeneralSymbol>> table, Nonterminal nonterminal, GeneralSymbol symbol) {
		LL1Key key = new LL1Key(nonterminal, symbol);
		
		for(LL1Key tableKey : table.keySet()) {
			if(key.equals(tableKey)) {
				return tableKey;
			}
		}
		
		return null;
	}

}
