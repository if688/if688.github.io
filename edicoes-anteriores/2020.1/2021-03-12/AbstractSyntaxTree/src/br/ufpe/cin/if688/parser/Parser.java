package br.ufpe.cin.if688.parser;


import br.ufpe.cin.if688.ast.*;
import br.ufpe.cin.if688.lexer.ILexer;
import br.ufpe.cin.if688.lexer.Num;
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
    //    T ::= F (* F)* | F (/ F)*
    //    F ::= num | "(" E ")"

    public Expr parse() {
        Expr exp = S();
        match(TipoToken.EOF);
        return exp;
    }

    Expr S() {
        return E();
    }
    Expr E() {
        Expr t = T();
        Expr e = t;
        while(tokenAtual.tipo == TipoToken.ADICAO || tokenAtual.tipo == TipoToken.SUBTRACAO) {
            if (tokenAtual.tipo == TipoToken.ADICAO) {
                match(TipoToken.ADICAO);
                Expr t_2 = T();
                e = new SumExpr(e,t_2);
            }
            else if (tokenAtual.tipo == TipoToken.SUBTRACAO) {
                match(TipoToken.SUBTRACAO);
                Expr t_2 = T();
                e = new SubExpr(e,t_2);
            }
        }

        return e;
    }
    Expr T() {
        Expr f = F();
        Expr e = f;
        while(tokenAtual.tipo == TipoToken.MULTIPLICACAO || tokenAtual.tipo == TipoToken.DIVISAO) {
            if (tokenAtual.tipo == TipoToken.MULTIPLICACAO) {
                match(TipoToken.MULTIPLICACAO);
                Expr f_2 = F();
                e = new MulExpr(e,f_2);
            }
            else if (tokenAtual.tipo == TipoToken.DIVISAO) {
                match(TipoToken.DIVISAO);
                Expr f_2 = F();
                e = new DivExpr(e,f_2);
            }
        }

        return e;
    }
    Expr F() {
        Expr e = null;

        if (tokenAtual.tipo == TipoToken.NUM) {
            if (tokenAtual instanceof Num) {
                Num num = (Num) tokenAtual;
                match(TipoToken.NUM); //daria na mesma usar getProximoToken();
                e = new NumExpr(num.valor);
            }
            else {
                erro("erro, esperava um número");
            }
        }
        else if (tokenAtual.tipo == TipoToken.PARENTESES_ESQ) {
            match(TipoToken.PARENTESES_ESQ);
            e = E();
            match(TipoToken.PARENTESES_DIR);
        }
        else {
            erro("erro de sintaxe");
        }

        return e;
    }

}
