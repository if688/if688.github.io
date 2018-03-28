package br.ufpe.cin.if688.execute;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.ufpe.cin.if688.parser.ErrorOnParseException;
import br.ufpe.cin.if688.parser.ParseTree;
import br.ufpe.cin.if688.parser.Parser;
import br.ufpe.cin.if688.parser.ParserGenerator;
import br.ufpe.cin.if688.parser.ParserUtils;
import br.ufpe.cin.if688.parsing.analysis.*;
import br.ufpe.cin.if688.parsing.grammar.*;
import br.ufpe.cin.if688.table.NotLL1Exception;
import br.ufpe.cin.if688.table.LL1Key;
import br.ufpe.cin.if688.table.Table;


public class App {

	public static void main(String[] args) throws NotLL1Exception, ErrorOnParseException {
		
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
		
		List<Terminal> example = new ArrayList<Terminal>();
		example.add(a);
		example.add(c);
		example.add(d);
		
		Grammar g = new Grammar(col, start);
		Map<Nonterminal, Set<GeneralSymbol>> first = SetGenerator.getFirst(g);
		Map<Nonterminal, Set<GeneralSymbol>> follow = SetGenerator.getFollow(g, first);
		Map<LL1Key, List<GeneralSymbol>> table = Table.createTable(g);
		Parser parser = ParserGenerator.createParser(g);
		ParseTree parseTree = ParserUtils.parseSequence(parser, example);
		
		System.out.println("Exemplo 1:\n"
						  + "A -> aB\n"
						  + "B -> cC\n"
						  + "C -> d");		
		System.out.println("Conjunto first: " + first.toString());
		System.out.println("Conjunto follow: " + follow.toString());
		System.out.println("Tabela de parsing: " + table.toString());
		System.out.println("Exemplo de parsing: " + parseTree.toString() + "\n");
		

	}

}
