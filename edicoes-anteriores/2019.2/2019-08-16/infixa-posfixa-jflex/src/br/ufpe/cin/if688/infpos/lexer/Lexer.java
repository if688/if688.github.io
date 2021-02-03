package br.ufpe.cin.if688.infpos.lexer;

import java.io.IOException;
import java.util.Hashtable;

public class Lexer {
	public int line = 1;
	private char peek = ' ';
	private Hashtable<String,Word> words = new Hashtable<>();
	
	void reserve(Word w) {
		words.put(w.lexeme, w);
	}
	
	public Lexer() {
		reserve(new Word(Tag.TRUE, "true"));
		reserve(new Word(Tag.FALSE, "false"));
	}
	
	public Token scan() throws IOException {
		for ( ; ; peek = (char) System.in.read()) {			
			if ( peek == ' ' || peek == '\t' ) {
				continue;
			}
			else if ( peek == '\n' ) {
				line = line + 1;
			}
			else {
				break;
			}
		}
		
		if (Character.isDigit(peek)) {
			int v = 0;
			do {
				v = 10*v + Character.digit(peek, 10);
				peek = (char) System.in.read();
			} while (Character.isDigit(peek));
			return new Num(v);
		}
		
		if (Character.isLetter(peek)) {
			StringBuffer b = new StringBuffer();
			do {
				b.append(peek);
				peek = (char) System.in.read(); 
			} while (Character.isLetter(peek));
			String s = b.toString();
			Word w = words.get(s);
			if (w != null) {
				return w;
			}
			w = new Word(Tag.ID,s);
			reserve(w);
			return w;
		}
		Token t = new Token(peek);
		peek = ' ';
		return t;
	}
}
