package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufpe.cin.if688.parsing.analysis.GeneralSymbol;
import br.ufpe.cin.if688.parsing.analysis.SpecialSymbol;
import br.ufpe.cin.if688.parsing.grammar.Grammar;
import br.ufpe.cin.if688.parsing.grammar.Nonterminal;
import br.ufpe.cin.if688.parsing.grammar.Production;
import br.ufpe.cin.if688.parsing.grammar.Terminal;
import br.ufpe.cin.if688.table.LL1Key;
import br.ufpe.cin.if688.table.NotLL1Exception;
import br.ufpe.cin.if688.table.Table;
import junit.framework.TestCase;

public class TableTest extends TestCase {

	public void testTableG1() throws NotLL1Exception {
		/*
		 * Gramática de exemplo:
		 *  A -> aB
		 *  B -> cC
		 *  C -> d
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

	public void testTableG3() throws NotLL1Exception {
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

		Map<LL1Key, List<GeneralSymbol>> table = Table.createTable(g);
		Map<LL1Key, List<GeneralSymbol>> expected = new HashMap<LL1Key, List<GeneralSymbol>>();

		LL1Key Ei = searchTable(table, E, id);
		LL1Key Eap = searchTable(table, E, ap);
		LL1Key Am = searchTable(table, A, m);
		LL1Key Afp = searchTable(table, A, fp);
		LL1Key Aeof = searchTable(table, A, SpecialSymbol.EOF);
		LL1Key Ti = searchTable(table, T, id);
		LL1Key Tap = searchTable(table, T, ap);
		LL1Key Bm = searchTable(table, B, m);
		LL1Key Ba = searchTable(table, B, a);
		LL1Key Bfp = searchTable(table, B, fp);
		LL1Key Beof = searchTable(table, B, SpecialSymbol.EOF);
		LL1Key Fi = searchTable(table, F, id);
		LL1Key Fap = searchTable(table, F, ap);

		List<GeneralSymbol> TA = new ArrayList<GeneralSymbol>();
		TA.add(T);
		TA.add(A);

		List<GeneralSymbol> mTA = new ArrayList<GeneralSymbol>();
		mTA.add(m);
		mTA.add(T);
		mTA.add(A);

		List<GeneralSymbol> epsilon = new ArrayList<GeneralSymbol>();
		epsilon.add(SpecialSymbol.EPSILON);

		List<GeneralSymbol> FB = new ArrayList<GeneralSymbol>();
		FB.add(F);
		FB.add(B);

		List<GeneralSymbol> aFB = new ArrayList<GeneralSymbol>();
		aFB.add(a);
		aFB.add(F);
		aFB.add(B);

		List<GeneralSymbol> i_ = new ArrayList<GeneralSymbol>();
		i_.add(id);

		List<GeneralSymbol> pEp = new ArrayList<GeneralSymbol>();
		pEp.add(ap);
		pEp.add(E);
		pEp.add(fp);

		expected.put(Ei, TA);
		expected.put(Eap, TA);
		expected.put(Am, mTA);
		expected.put(Afp, epsilon);
		expected.put(Aeof, epsilon);
		expected.put(Ti, FB);
		expected.put(Tap, FB);
		expected.put(Bm, epsilon);
		expected.put(Ba, aFB);
		expected.put(Bfp, epsilon);
		expected.put(Beof, epsilon);
		expected.put(Fi, i_);
		expected.put(Fap, pEp);

		assertEquals(expected, table);
	}

	private LL1Key searchTable(Map<LL1Key, List<GeneralSymbol>> table, Nonterminal nonterminal, GeneralSymbol symbol) {
		LL1Key key = new LL1Key(nonterminal, symbol);

		for (LL1Key tableKey : table.keySet()) {
			if (key.equals(tableKey)) {
				return tableKey;
			}
		}

		return null;
	}

}
