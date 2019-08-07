package br.ufpe.cin.if688.infpos.lexer;

public class Token {
	public final int tag;
	public Token(int t) {
		tag = t;
	}
	@Override
	public String toString() {
		return "Token [tag=" + tag + "]";
	}
	
	
}
