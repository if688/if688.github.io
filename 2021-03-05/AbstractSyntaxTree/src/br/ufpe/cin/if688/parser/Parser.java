package br.ufpe.cin.if688.parser;


import br.ufpe.cin.if688.lexer.ILexer;
import br.ufpe.cin.if688.lexer.TipoToken;
import br.ufpe.cin.if688.lexer.Token;

public class Parser {

    ILexer lexer;
    private Token tokenAtual;

    public Parser(ILexer l) {
        lexer = l;
        getProximoToken();
    }

    void getProximoToken() {
        tokenAtual = lexer.getToken();
    }

    void erro(String msg) {
        throw new ParsingException(msg);
    }

    void match(TipoToken esperado) {
        if (tokenAtual.tipo == esperado) {
            getProximoToken();
        } else {
            erro("Esperava por token do tipo " + esperado.name() + ", apareceu " + tokenAtual.tipo.name());
        }
    }

    //    S ::= E
    //    E ::= T (+ T)* | T (- T)*
    //    T ::= F * F | F / F
    //    F ::= num | "(" E ")"


}
