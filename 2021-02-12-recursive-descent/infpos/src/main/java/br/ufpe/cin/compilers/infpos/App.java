package br.ufpe.cin.compilers.infpos;

import br.ufpe.cin.compilers.lexer.LexerManual;

public class App {
    public static String programa ="22+4-10";

    public static void main(String[] args) {
        LexerManual lexer = new LexerManual(programa);
    }
}
