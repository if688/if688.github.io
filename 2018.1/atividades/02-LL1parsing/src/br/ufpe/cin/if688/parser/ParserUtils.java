package br.ufpe.cin.if688.parser;

import java.util.List;
import br.ufpe.cin.if688.parsing.grammar.Terminal;


public final class ParserUtils {

	private ParserUtils() {
		
	}
	
	public static ParseTree parseSequence(Parser parser, List<Terminal> terminals) throws ErrorOnParseException {
		
		for(Terminal t : terminals)
			parser.nextTerminal(t);
		
		return parser.inputComplete();
	}
	
}
