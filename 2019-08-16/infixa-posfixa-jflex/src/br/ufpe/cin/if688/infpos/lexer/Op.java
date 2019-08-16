package br.ufpe.cin.if688.infpos.lexer;

public class Op extends Token {
	public final String op;
	public Op(String s) {
		super(s.charAt(0));
		op= new String(s);
	}
	public String getLexeme() {
		return op;
	}
	@Override
	public String toString() {
		return "Op [op=" + op + ", tag=" + tag + "]";
	}
}
