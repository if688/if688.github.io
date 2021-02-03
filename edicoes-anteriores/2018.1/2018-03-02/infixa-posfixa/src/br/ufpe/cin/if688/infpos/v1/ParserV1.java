package br.ufpe.cin.if688.infpos.v1;

import java.io.IOException;

public class ParserV1 {
	static char lookahead;
	
	public ParserV1() throws IOException {
		lookahead = (char) System.in.read();
	}
	
	void expr() throws IOException {
		term(); rest();
	}
	
	void rest() throws IOException {
		if (lookahead == '+') {
			match('+'); term(); System.out.write('+'); System.out.write(' ');  rest();
		}
		else if (lookahead == '-') {
			match('-'); term(); System.out.write('-'); System.out.write(' ');  rest();
		}
		else return;	
	}
	
	void term() throws IOException {
		char t = lookahead;
		if (Character.isDigit(t)) {
			match(lookahead);
			System.out.write(t); 
			System.out.write(' '); 
		}
		else {
			throw new Error("erro de sintaxe");
		}
	}
	
	void match(char t) throws IOException {
		if (lookahead == t) lookahead = (char) System.in.read();
		else throw new Error("erro de sintaxe");
	}
}












