package br.ufpe.cin.compilers.lexer;

public class Token {

    public TipoToken tipo;
    public String lexema;
    
    public Token(TipoToken t, String l) {
        tipo = t;
        lexema = l;
    }

    public static TipoToken checaPalavraChave(String txt) {
        for(TipoToken t : TipoToken.values()) {
            if (txt.toUpperCase().equals(t.name()) && t.getTipo() > 100 && t.getTipo() < 200) {
                return t;
            }
        }
        return TipoToken.ID;
    }

    @Override
    public String toString() {
        return "Token [tipo = " + tipo + ", lexema = "+lexema+"]";
    }
}
