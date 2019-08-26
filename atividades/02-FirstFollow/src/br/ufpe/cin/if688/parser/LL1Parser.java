package br.ufpe.cin.if688.parser;

import java.util.*;

import br.ufpe.cin.if688.parsing.analysis.*;
import br.ufpe.cin.if688.parsing.grammar.*;
import br.ufpe.cin.if688.table.*;

public class LL1Parser implements Parser {
	
	private static final class StackEntry {
		
		public final GeneralSymbol symbol;
		
		public final ParseTree tree;
		
		public StackEntry(GeneralSymbol symbol, ParseTree tree) {
			this.symbol = symbol;
			this.tree = tree;
		}
		
	}
	
	private final Map<LL1Key, List<GeneralSymbol>> parsingTable;
	
	private final Deque<StackEntry> parsingStack = new ArrayDeque<StackEntry>();
	
	private final ParseTree parseTree;
	
	public LL1Parser(Map<LL1Key, List<GeneralSymbol>> parsingTable, Nonterminal start) {
		this.parsingTable = parsingTable;
		
		parseTree = new ParseTree(start);
		
		parsingStack.offerFirst(new StackEntry(SpecialSymbol.EOF, null));
		
		parsingStack.offerFirst(new StackEntry(new ConcreteSymbol(start), parseTree));
	}
	
	public ParseTree inputComplete() throws ErrorOnParseException {
		ParseTree result = processSymbol(SpecialSymbol.EOF);
		assert result != null;
		return result;
	}
	
	public void nextTerminal(Terminal terminal) throws ErrorOnParseException {
		processSymbol(new ConcreteSymbol(terminal));
	}
	
	private ParseTree processSymbol(GeneralSymbol symbol) throws ErrorOnParseException {
		if(parsingStack.isEmpty())
			throw new ErrorOnParseException("Parsing finalizado.");
		
		while(true) {
			StackEntry top = parsingStack.pollFirst();

			if(top.symbol.equals(SpecialSymbol.EPSILON)) continue;			
			
			if(top.symbol.equals(symbol)) {
				return symbol.equals(SpecialSymbol.EOF) ? parseTree : null;
			}
						
			if(!(top.symbol instanceof ConcreteSymbol && ((ConcreteSymbol)top.symbol).getSymbol() instanceof Nonterminal))
				throw new ErrorOnParseException("Esperava " + top.symbol + ", encontrado " + symbol);
			
			Nonterminal nonterminal = (Nonterminal)((ConcreteSymbol)top.symbol).getSymbol();
			List<GeneralSymbol> production = parsingTable.get(new LL1Key(nonterminal, symbol));
			
			if(production == null)
				throw new ErrorOnParseException("Nao ha producao relacionada a " + nonterminal + " ao observar " + symbol);
			
			for(int i = production.size()-1; i >= 0; i--) {
				GeneralSymbol s =  production.get(i);
				
				ParseTree tree = new ParseTree(s);
				
				parsingStack.offerFirst(new StackEntry(new ConcreteSymbol(s), tree));
			}
			
			Iterator<StackEntry> iter = parsingStack.iterator();
			for(int i = 0; i < production.size(); i++)
				top.tree.getChildren().add(iter.next().tree);
		}
	}
	
}
