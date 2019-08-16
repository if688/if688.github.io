package br.ufpe.cin.if688.infpos.parser;

import java.io.IOException;

import br.ufpe.cin.if688.infpos.lexer.InfPosLexer;
import br.ufpe.cin.if688.infpos.lexer.Num;
import br.ufpe.cin.if688.infpos.lexer.Tag;
import br.ufpe.cin.if688.infpos.lexer.Token;
import br.ufpe.cin.if688.infpos.lexer.Word;

public class Parser {
   private InfPosLexer lex;    // analisador lexico
   private Token look;   // lookahead tag
	
	public Parser(InfPosLexer l) throws IOException { 
		lex = l; move(); 
	}

	void move() throws IOException { 
		look = lex.getNextToken(); 
	}
	
	void error(String s) { 
		throw new Error("problema de parsing"); 
	}

	
	public void expr() throws IOException {
		term();
		while(true) {
			if (null == look) {
				return;
			}
			else if (look.tag == '+') {
				match('+'); 
				term(); 
				System.out.print("+ ");
			}
			else if (look.tag == '-') {
				match('-'); 
				term(); 
				System.out.print("- ");
			}
			else return;
		}
	}
	void term() throws IOException {
		switch( look.tag ) {
			case Tag.NUM:
				Num n = (Num) look;
				System.out.print(n.getValue() + " ");
				move();
				break;
			case Tag.ID:
				Word w = (Word) look;
				System.out.print(w.getLexeme() + " ");
				move();
				break;
			default:
				error("erro de sintaxe");
				break;
		}
	}
	
	void match(int t) throws IOException {
		if( look.tag == t ) {
			move();
		}
		else {
			error("erro de sintaxe");
		}
	}

}
