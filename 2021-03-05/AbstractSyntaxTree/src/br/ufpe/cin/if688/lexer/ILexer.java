package br.ufpe.cin.if688.lexer;

public interface ILexer {
    Token getToken();
    char peek();
}
