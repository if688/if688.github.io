package br.ufpe.cin.if688.parser;

import br.ufpe.cin.if688.parsing.grammar.*;

public interface Parser {
	
	public void nextTerminal(Terminal terminal) throws ErrorOnParseException;
	
	public ParseTree inputComplete() throws ErrorOnParseException;
	
}
