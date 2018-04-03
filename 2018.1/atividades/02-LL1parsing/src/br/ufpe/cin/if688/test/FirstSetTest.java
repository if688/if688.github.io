package br.ufpe.cin.if688.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import br.ufpe.cin.if688.parsing.analysis.ConcreteSymbol;
import br.ufpe.cin.if688.parsing.analysis.GeneralSymbol;
import br.ufpe.cin.if688.parsing.analysis.SetGenerator;
import br.ufpe.cin.if688.parsing.analysis.SpecialSymbol;
import br.ufpe.cin.if688.parsing.grammar.Grammar;
import br.ufpe.cin.if688.parsing.grammar.Nonterminal;
import br.ufpe.cin.if688.parsing.grammar.Production;
import br.ufpe.cin.if688.parsing.grammar.Terminal;

public class FirstSetTest extends TestCase {

	public void testFirstSetG1() {
		/*
		 * Gramática de exemplo:
		 *  A -> aB
		 * 	B -> cC
		 * 	C -> d
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
		
		Map<Nonterminal, Set<GeneralSymbol>> first = SetGenerator.getFirst(g);
		Map<Nonterminal, Set<GeneralSymbol>> expected = new HashMap<Nonterminal, Set<GeneralSymbol>>();
		
		for (Nonterminal nt: g.getNonterminals()){
			expected.put(nt, new HashSet<GeneralSymbol>());
		}
		
		expected.get(C).add(d);
		expected.get(B).add(c);
		expected.get(start).add(a);
		
		assertEquals(expected, first);
	
	}
	
	public void testFirstSetG2() {
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
		
		Map<Nonterminal, Set<GeneralSymbol>> first = SetGenerator.getFirst(g);
		Map<Nonterminal, Set<GeneralSymbol>> expected = new HashMap<Nonterminal, Set<GeneralSymbol>>();

		for (Nonterminal nt: g.getNonterminals()){
			expected.put(nt, new HashSet<GeneralSymbol>());
		}
		
		expected.get(K).add(SpecialSymbol.EPSILON);
		expected.get(K).add(b);
		
		expected.get(S).add(a);
		
		expected.get(B).add(d);
		
		expected.get(A).add(b);
		
		assertEquals(expected, first);		
	}
	
}
