package br.ufpe.cin.compilers.lexer;

public class Id extends Token {

    String nome;
    public Id(String v) {
        super(Tag.ID);
        nome = v;
    }

    @Override
    public String toString() {
        return "Identificador [valor = "+nome+"]";
    }
}
