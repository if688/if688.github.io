package br.ufpe.cin.if688.infpos.v2.lexer;

import java.io.IOException;

public interface ILexer<T> {
	T getNextToken() throws IOException;
	int getLine();
	int getColumn();
}
