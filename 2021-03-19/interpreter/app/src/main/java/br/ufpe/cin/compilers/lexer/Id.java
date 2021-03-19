package br.ufpe.cin.compilers.lexer;

public class Id extends Token {

    public Id(String v) {
        super(TipoToken.ID, v);
    }

    @Override
    public String toString() {
        return "Identificador [valor = "+lexema+"]";
    }
}
