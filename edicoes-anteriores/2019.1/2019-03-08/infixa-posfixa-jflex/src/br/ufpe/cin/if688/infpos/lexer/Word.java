package br.ufpe.cin.if688.infpos.lexer;

public class Word extends Token {
	public final String lexeme;
	public Word(int t, String s) {
		super(t);
		lexeme = new String(s);
	}
	public String getLexeme() {
		return lexeme;
	}
	@Override
	public String toString() {
		return "Word [lexeme=" + lexeme + ", tag=" + tag + "]";
	}
}
