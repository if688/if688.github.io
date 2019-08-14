package br.ufpe.cin.if688.infpos.lexer;

import java.io.IOException;

public interface ILexer<T> {
	T getNextToken() throws IOException;
	int getLine();
	int getColumn();
}
