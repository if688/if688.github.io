package br.ufpe.cin.if688.lexer;

public class Num extends Token {
    public int valor;

    public Num(int v) {
        super(TipoToken.NUM, String.valueOf(v));
        valor = v;
    }

    @Override
    public String toString() {
        return "Numero [valor = "+valor+"]";
    }
}
