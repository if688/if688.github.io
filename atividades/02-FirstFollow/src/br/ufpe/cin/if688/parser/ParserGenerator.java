package br.ufpe.cin.if688.parser;

import java.util.*;

import br.ufpe.cin.if688.parsing.analysis.GeneralSymbol;
import br.ufpe.cin.if688.parsing.grammar.*;
import br.ufpe.cin.if688.table.*;

public final class ParserGenerator {
	
	private ParserGenerator() {};
	
	public static Parser createParser(Grammar g) throws NotLL1Exception {
		if(g == null) throw new NullPointerException();
		
		Map<LL1Key, List<GeneralSymbol>> table = Table.createTable(g);
		
		return new LL1Parser(table, g.getStartSymbol());
		
	}
	
}
