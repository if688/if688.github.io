package br.ufpe.cin.if688.infpos.lexer;


public class Num extends Token {
	public final int value;
	public Num(int v) {
		super(Tag.NUM);
		value = v;
	}
	
	public Num(String s) {
		super(Tag.NUM);
		value = Integer.parseInt(s);
	}
	
	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Num [value=" + value + ", tag=" + tag + "]";
	}
}
