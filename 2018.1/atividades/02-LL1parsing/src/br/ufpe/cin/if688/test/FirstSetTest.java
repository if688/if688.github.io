package br.ufpe.cin.if688.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.ufpe.cin.if688.parsing.analysis.GeneralSymbol;
import br.ufpe.cin.if688.parsing.analysis.SetGenerator;
import br.ufpe.cin.if688.parsing.analysis.SpecialSymbol;
import br.ufpe.cin.if688.parsing.grammar.Grammar;
import br.ufpe.cin.if688.parsing.grammar.Nonterminal;
import br.ufpe.cin.if688.parsing.grammar.Production;
import br.ufpe.cin.if688.parsing.grammar.Terminal;
import junit.framework.TestCase;

public class FirstSetTest extends TestCase {

	public void testFirstSetG1() {
		/*
		 * Gramática de exemplo:
		 * A -> aB
		 * B -> cC
		 * C -> d
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

		for (Nonterminal nt : g.getNonterminals()) {
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

		for (Nonterminal nt : g.getNonterminals()) {
			expected.put(nt, new HashSet<GeneralSymbol>());
		}

		expected.get(K).add(SpecialSymbol.EPSILON);
		expected.get(K).add(b);

		expected.get(S).add(a);

		expected.get(B).add(d);

		expected.get(A).add(b);

		assertEquals(expected, first);
	}

	public void testFirstSetG3() {
		/*
		 * Gramatica de exemplo
		 * E -> TA
		 * A -> +TA
		 * A -> vazio
		 * T -> FB
		 * B -> *FB
		 * B -> vazio
		 * F -> (E)
		 * F -> i
		 */

		Nonterminal E = new Nonterminal("E");
		Nonterminal A = new Nonterminal("A");
		Nonterminal B = new Nonterminal("B");
		Nonterminal T = new Nonterminal("T");
		Nonterminal F = new Nonterminal("F");

		Terminal m = new Terminal("+");
		Terminal a = new Terminal("*");
		Terminal ap = new Terminal("(");
		Terminal fp = new Terminal(")");
		Terminal id = new Terminal("i");

		List<GeneralSymbol> prodE = new ArrayList<GeneralSymbol>();
		prodE.add(T);
		prodE.add(A);

		List<GeneralSymbol> prodA1 = new ArrayList<GeneralSymbol>();
		prodA1.add(m);
		prodA1.add(T);
		prodA1.add(A);

		List<GeneralSymbol> prodA2 = new ArrayList<GeneralSymbol>();
		prodA2.add(SpecialSymbol.EPSILON);

		List<GeneralSymbol> prodT = new ArrayList<GeneralSymbol>();
		prodT.add(F);
		prodT.add(B);

		List<GeneralSymbol> prodB1 = new ArrayList<GeneralSymbol>();
		prodB1.add(a);
		prodB1.add(F);
		prodB1.add(B);

		List<GeneralSymbol> prodB2 = new ArrayList<GeneralSymbol>();
		prodB2.add(SpecialSymbol.EPSILON);

		List<GeneralSymbol> prodF1 = new ArrayList<GeneralSymbol>();
		prodF1.add(ap);
		prodF1.add(E);
		prodF1.add(fp);

		List<GeneralSymbol> prodF2 = new ArrayList<GeneralSymbol>();
		prodF2.add(id);

		Production pE = new Production(E, prodE);
		Production pA1 = new Production(A, prodA1);
		Production pA2 = new Production(A, prodA2);
		Production pT = new Production(T, prodT);
		Production pB1 = new Production(B, prodB1);
		Production pB2 = new Production(B, prodB2);
		Production pF1 = new Production(F, prodF1);
		Production pF2 = new Production(F, prodF2);

		Collection<Production> collection = new ArrayList<Production>();
		collection.add(pE);
		collection.add(pA1);
		collection.add(pA2);
		collection.add(pT);
		collection.add(pB1);
		collection.add(pB2);
		collection.add(pF1);
		collection.add(pF2);

		Grammar g = new Grammar(collection, E);

		Map<Nonterminal, Set<GeneralSymbol>> first = SetGenerator.getFirst(g);
		Map<Nonterminal, Set<GeneralSymbol>> expected = new HashMap<Nonterminal, Set<GeneralSymbol>>();

		for (Nonterminal nt : g.getNonterminals()) {
			expected.put(nt, new HashSet<GeneralSymbol>());
		}

		expected.get(E).add(ap);
		expected.get(E).add(id);

		expected.get(A).add(m);
		expected.get(A).add(SpecialSymbol.EPSILON);

		expected.get(T).add(ap);
		expected.get(T).add(id);

		expected.get(B).add(a);
		expected.get(B).add(SpecialSymbol.EPSILON);

		expected.get(F).add(ap);
		expected.get(F).add(id);

		assertEquals(expected, first);
	}

	public void testFirstSetG4() {
		/*
		 * Gramatica de exemplo
		 * S -> aAb
		 * A -> BCDEFGz
		 * B -> b | #
		 * C -> c | #
		 * D -> d | #
		 * E -> e | #
		 * F -> f
		 * G -> g | #
		 */

		Nonterminal S = new Nonterminal("S");
		Nonterminal A = new Nonterminal("A");
		Nonterminal B = new Nonterminal("B");
		Nonterminal C = new Nonterminal("C");
		Nonterminal D = new Nonterminal("D");
		Nonterminal E = new Nonterminal("E");
		Nonterminal F = new Nonterminal("F");
		Nonterminal G = new Nonterminal("G");

		Terminal a = new Terminal("a");
		Terminal b = new Terminal("b");
		Terminal c = new Terminal("c");
		Terminal d = new Terminal("d");
		Terminal e = new Terminal("e");
		Terminal f = new Terminal("f");
		Terminal g = new Terminal("g");
		Terminal z = new Terminal("z");

		List<GeneralSymbol> prodS = new ArrayList<GeneralSymbol>();
		prodS.add(a);
		prodS.add(A);
		prodS.add(b);

		List<GeneralSymbol> prodA = new ArrayList<GeneralSymbol>();
		prodA.add(B);
		prodA.add(C);
		prodA.add(D);
		prodA.add(E);
		prodA.add(F);
		prodA.add(G);
		prodA.add(z);

		List<GeneralSymbol> prodB1 = new ArrayList<GeneralSymbol>();
		prodB1.add(b);

		List<GeneralSymbol> prodB2 = new ArrayList<GeneralSymbol>();
		prodB2.add(SpecialSymbol.EPSILON);

		List<GeneralSymbol> prodC1 = new ArrayList<GeneralSymbol>();
		prodC1.add(c);

		List<GeneralSymbol> prodC2 = new ArrayList<GeneralSymbol>();
		prodC2.add(SpecialSymbol.EPSILON);

		List<GeneralSymbol> prodD1 = new ArrayList<GeneralSymbol>();
		prodD1.add(d);

		List<GeneralSymbol> prodD2 = new ArrayList<GeneralSymbol>();
		prodD2.add(SpecialSymbol.EPSILON);

		List<GeneralSymbol> prodE1 = new ArrayList<GeneralSymbol>();
		prodE1.add(e);

		List<GeneralSymbol> prodE2 = new ArrayList<GeneralSymbol>();
		prodE2.add(SpecialSymbol.EPSILON);

		List<GeneralSymbol> prodF = new ArrayList<GeneralSymbol>();
		prodF.add(f);

		List<GeneralSymbol> prodG1 = new ArrayList<GeneralSymbol>();
		prodG1.add(g);

		List<GeneralSymbol> prodG2 = new ArrayList<GeneralSymbol>();
		prodG2.add(SpecialSymbol.EPSILON);

		Production pS = new Production(S, prodS);
		Production pA = new Production(A, prodA);
		Production pB1 = new Production(B, prodB1);
		Production pB2 = new Production(B, prodB2);
		Production pC1 = new Production(C, prodC1);
		Production pC2 = new Production(C, prodC2);
		Production pD1 = new Production(D, prodD1);
		Production pD2 = new Production(D, prodD2);
		Production pE1 = new Production(E, prodE1);
		Production pE2 = new Production(E, prodE2);
		Production pF = new Production(F, prodF);
		Production pG1 = new Production(G, prodG1);
		Production pG2 = new Production(G, prodG2);

		Collection<Production> collection = new ArrayList<Production>();
		collection.add(pS);
		collection.add(pA);
		collection.add(pB1);
		collection.add(pB2);
		collection.add(pC1);
		collection.add(pC2);
		collection.add(pD1);
		collection.add(pD2);
		collection.add(pE1);
		collection.add(pE2);
		collection.add(pF);
		collection.add(pG1);
		collection.add(pG2);

		Grammar gr = new Grammar(collection, S);

		Map<Nonterminal, Set<GeneralSymbol>> first = SetGenerator.getFirst(gr);
		Map<Nonterminal, Set<GeneralSymbol>> expected = new HashMap<Nonterminal, Set<GeneralSymbol>>();

		for (Nonterminal nt : gr.getNonterminals()) {
			expected.put(nt, new HashSet<GeneralSymbol>());
		}

		expected.get(S).add(a);

		expected.get(B).add(b);
		expected.get(B).add(SpecialSymbol.EPSILON);

		expected.get(C).add(c);
		expected.get(C).add(SpecialSymbol.EPSILON);

		expected.get(D).add(d);
		expected.get(D).add(SpecialSymbol.EPSILON);

		expected.get(E).add(e);
		expected.get(E).add(SpecialSymbol.EPSILON);

		expected.get(F).add(f);

		expected.get(G).add(g);
		expected.get(G).add(SpecialSymbol.EPSILON);

		expected.get(A).add(b);
		expected.get(A).add(c);
		expected.get(A).add(d);
		expected.get(A).add(e);
		expected.get(A).add(f);

		assertEquals(expected, first);
	}

}
