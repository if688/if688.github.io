package br.ufpe.cin.if688.parser;

import java.util.*;

import br.ufpe.cin.if688.parsing.analysis.GeneralSymbol;
import br.ufpe.cin.if688.parsing.grammar.*;

public class ParseTree {

	private final GeneralSymbol symbol;
	
	private final List<ParseTree> children;
	
	public ParseTree(GeneralSymbol s, List<ParseTree> children) {
		if(s == null || children == null)
			throw new NullPointerException();
		
		this.symbol = s;
		this.children = children;
	}
	
	public ParseTree(GeneralSymbol s) {
		this(s, new ArrayList<ParseTree>());
	}
	
	public GeneralSymbol getSymbol() {
		return symbol;
	}
	
	public List<ParseTree> getChildren() {
		return children;
	}
	
	public Iterator<ParseTree> iterator() {
		return getChildren().iterator();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(symbol);
		if(symbol instanceof Nonterminal) {
			builder.append(" -> ");
			builder.append(getChildren());			
		}
		return builder.toString();
	}
	
}
