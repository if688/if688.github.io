package br.ufpe.cin.compilers.jflex;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class App {

    public static String programa =
            "x = 3;\n" +
                    "ya = 22+4-10;\n" +
                    "print(x);";

    public static void main(String[] args) {
        LexerGerado lexer = null;
        Reader targetReader = null;
        try {
            targetReader = new StringReader(programa);
            lexer = new LexerGerado(targetReader);

            while(!lexer.yyatEOF()) {
                lexer.yylex();
            }
            targetReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
