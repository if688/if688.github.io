package br.ufpe.cin.if688.infpos.v2.parser;

import java.io.IOException;

import br.ufpe.cin.if688.infpos.v2.lexer.ILexer;
import br.ufpe.cin.if688.infpos.v2.lexer.Num;
import br.ufpe.cin.if688.infpos.v2.lexer.Tag;
import br.ufpe.cin.if688.infpos.v2.lexer.Token;

public class Parser {
   private ILexer<Token> lex;    // analisador lexico
   private Token look;   // lookahead tag
	
	public Parser(ILexer<Token> l) throws IOException { 
		lex = l; move(); 
	}

	void move() throws IOException { 
		look = lex.getNextToken(); 
		//System.out.println(look);
	}
	
	void error(String s) { 
		throw new Error("Erro na linha "+lex.getLine()+": "+s); 
	}

	
	public void expr() throws IOException {
		term();
		while(true) {
			if (look.tag == Tag.PLUS) {
				match('+'); 
				term(); 
				System.out.print("+ ");
			}
			else if (look.tag == Tag.MINUS) {
				match('-'); 
				term(); 
				System.out.print("- ");
			}
			else if (look.tag == Tag.EOF) {
				return;
			}
			else {
				error("Deveria vir um +, -, ou fim de arquivo.");
			}
		}
	}
	void term() throws IOException {
		switch( look.tag ) {
			case Tag.NUM:
				Num n = (Num) look;
				System.out.print(n.getValue() + " ");
				move();
				break;
			default:
				error("Esperava um número, e veio "+look.toString());
				break;
		}
	}
	
	void match(int t) throws IOException {
		if( look.tag == t ) {
			move();
		}
		else {
			error("Erro, esperava "+t+" e veio "+look);
		}
	}

}
