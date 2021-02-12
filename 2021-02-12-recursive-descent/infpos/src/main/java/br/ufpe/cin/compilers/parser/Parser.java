package br.ufpe.cin.compilers.parser;


import br.ufpe.cin.compilers.lexer.ILexer;
import br.ufpe.cin.compilers.lexer.TipoToken;
import br.ufpe.cin.compilers.lexer.Token;

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
        }
        else {
            erro("Esperava por token do tipo "+esperado.name()+", apareceu "+tokenAtual.tipo.name());
        }
    }

    public void parse() {
        expr();
        System.out.println("Tudo ok com a entrada");
    }

    void expr() {
        term(); rest();
    }

    void term() {
        if (tokenAtual.tipo == TipoToken.NUM) {
            System.out.print(tokenAtual.lexema + ' ');
            match(TipoToken.NUM);
        }
        else {
            erro("erro de sintaxe");
        }
    }

    void rest() {
        if (tokenAtual.tipo == TipoToken.ADICAO) {
            match(TipoToken.ADICAO);
            term();
            System.out.print("+ ");
            rest();
        }
        else if (tokenAtual.tipo == TipoToken.SUBTRACAO) {
            match(TipoToken.SUBTRACAO);
            term();
            System.out.print("- ");
            rest();
        }
        else if(tokenAtual.tipo == TipoToken.EOF) {
            //palavra vazia
        }
        else {
            erro("erro de sintaxe, token inesperado: "+tokenAtual.tipo.name());
        }
    }
}
