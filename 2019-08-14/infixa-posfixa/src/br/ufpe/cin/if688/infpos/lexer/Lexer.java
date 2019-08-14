package br.ufpe.cin.if688.infpos.lexer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lexer implements ILexer<Token> {
	//linhas e colunas
	public int line = 1;
	public int column = 0;

	//caractere atual
	private char peek = ' ';

	//palavra de entrada
	private final String input;
	//tamanho da String
	private final int inputLength;
	//em que ponto da String nós estamos
	private int position = 0;

	public Lexer(String input) {
		this.input = input;
		this.inputLength = input.length();
	}

	public Token scan() throws IOException {
		//enquanto não cheguei ao fim do arquivo (entrada)
		while (position < inputLength) {
			//caractere na posição atual
			peek = input.charAt(position);
			
			switch (peek) {
			case ' ':
			case '\t':
				column++;
				position++;
				break;
			case '\n':
				line++;
				column = 0;
				position++;
				break;
			case '+':
			case '-':
				position++;
				column++;
				return new Token(peek);
			default:
				if (Character.isDigit(peek)) {
					int v = 0;
					do {
						v = 10 * v + Character.digit(peek, 10);
						position++;
						column++;
						if (position<inputLength) {
							peek = input.charAt(position);
						}
						else {
							peek = ' ';
						}
					} while (Character.isDigit(peek));
					return new Num(v);
				} 
				else {
					throw new IOException("Caractere ilegal");
				}
			}
		}
		//Isto é comumente usado em gramáticas como $
		Token t = new Token(Tag.EOF);
		return t;
	}

	@Override
	public Token getNextToken() throws IOException {
		return scan();
	}

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public int getColumn() {
		//TODO considerar column-1
		return column;
	}
	
	public List<Token> tokens() throws IOException {
		List<Token> tokenList = new ArrayList<>();
		Token t = getNextToken();
		tokenList.add(t);
		while (t.tag != Tag.EOF) {
			t = getNextToken();
			tokenList.add(t);
		}
		position = 0;
		column = 0;
		line = 1;
		return tokenList;
	}
}























/*
private Hashtable<String,Word> symbolTable = new Hashtable<>();
void reserve(Word w) {
	symbolTable.put(w.lexeme, w);
}
public Lexer(String input) {
	this.input = input;
	
	//criando palavras reservadas
	reserve(new Word(Tag.TRUE, "true"));
	reserve(new Word(Tag.FALSE, "false"));
}

	if (Character.isLetter(peek)) {
		StringBuffer b = new StringBuffer();
		do {
			b.append(peek);
			peek = (char) System.in.read(); 
		} while (Character.isLetter(peek));
		String s = b.toString();
		Word w = symbolTable.get(s);
		if (w != null) {
			return w;
		}
		w = new Word(Tag.ID,s);
		reserve(w);
		return w;
	}

*
*/