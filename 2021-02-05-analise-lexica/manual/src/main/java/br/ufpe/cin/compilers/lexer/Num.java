package br.ufpe.cin.compilers.lexer;

public class Num extends Token {
    public int valor;

    public Num(int v) {
        super(Tag.NUM);
        valor = v;
    }

    @Override
    public String toString() {
        return "Numero [valor = "+valor+"]";
    }
}
