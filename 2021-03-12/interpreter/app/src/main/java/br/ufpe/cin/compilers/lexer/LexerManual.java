package br.ufpe.cin.compilers.lexer;

import java.util.ArrayList;
import java.util.List;

public class LexerManual implements ILexer {

    public final static char EOF = '\0';
    private String codigoFonte;
    private char caractereAtual = ' ';
    private int posicaoAtual = -1;


    public LexerManual(String entrada) {
        codigoFonte = entrada;
        proximoCaractere();
    }

    public void proximoCaractere() {
        posicaoAtual += 1;
        if (posicaoAtual >= codigoFonte.length()) {
            caractereAtual = EOF;
        } else {
            caractereAtual = codigoFonte.charAt(posicaoAtual);
        }
    }

    @Override
    public char peek() {//peek
        if (posicaoAtual + 1 >= codigoFonte.length()) {
            return EOF;
        } else {
            return codigoFonte.charAt(posicaoAtual + 1);
        }
    }

    @Override
    public Token getToken() {
        ignorarEspacoEmBranco();
        ignorarComentarios();
        Token t = null;

        if (caractereAtual == '+') {
            t = new Token(TipoToken.ADICAO, String.valueOf(caractereAtual));
        } else if (caractereAtual == '-') {
            t = new Token(TipoToken.SUBTRACAO, String.valueOf(caractereAtual));
        } else if (caractereAtual == '*') {
            t = new Token(TipoToken.MULTIPLICACAO, String.valueOf(caractereAtual));
        } else if (caractereAtual == '/') {
            t = new Token(TipoToken.DIVISAO, String.valueOf(caractereAtual));
        } else if (caractereAtual == '=') {
            if (peek()=='=') {
                char c = caractereAtual;
                proximoCaractere();
                t = new Token(TipoToken.IGUAL_A,String.valueOf(c+caractereAtual));
            }
            else {
                t = new Token(TipoToken.ATRIBUICAO, String.valueOf(caractereAtual));
            }
        } else if (caractereAtual == '>') {
            if (peek()=='=') {
                char c = caractereAtual;
                proximoCaractere();
                t = new Token(TipoToken.MAIOR_QUE_OU_IGUAL,String.valueOf(c+caractereAtual));
            }
            else {
                t = new Token(TipoToken.MAIOR_QUE, String.valueOf(caractereAtual));
            }
        } else if (caractereAtual == '<') {
            if (peek()=='=') {
                char c = caractereAtual;
                proximoCaractere();
                t = new Token(TipoToken.MENOR_QUE_OU_IGUAL,String.valueOf(c+caractereAtual));
            }
            else {
                t = new Token(TipoToken.MENOR_QUE, String.valueOf(caractereAtual));
            }
        } else if (caractereAtual == '!') {
            if (peek()=='=') {
                char c = caractereAtual;
                proximoCaractere();
                t = new Token(TipoToken.DIFERENTE_DE,String.valueOf(c+caractereAtual));
            }
            else {
                abort("Esperava !=, apareceu !"+peek());
            }
        }
        else if (caractereAtual == '"') {
            proximoCaractere();
            int inicio = posicaoAtual;
            while (caractereAtual!='"') {
                if (caractereAtual=='\r' || caractereAtual == '\n' || caractereAtual == '\t' || caractereAtual == '\\' || caractereAtual == '%') {
                    abort("Caractere ilegal dentro da string.");
                }
                proximoCaractere();
            }
            String str = codigoFonte.substring(inicio,posicaoAtual);
            t = new Token(TipoToken.STRING, str);
        } else if (Character.isDigit(caractereAtual)) {
            int inicio = posicaoAtual;
            while (Character.isDigit(peek())) {
                proximoCaractere();
            }
            int numero = Integer.parseInt(codigoFonte.substring(inicio, posicaoAtual + 1));
            t = new Num(numero);
        } else if (Character.isLetter(caractereAtual)) {
            int inicio = posicaoAtual;
            while (Character.isLetterOrDigit(peek())) {
                proximoCaractere();
            }
            String nome = codigoFonte.substring(inicio, posicaoAtual + 1);
            TipoToken tipoToken = Token.checaPalavraChave(nome);
            t = new Token(tipoToken, nome);
        }
        else if (caractereAtual == '\n') {
            t = new Token(TipoToken.QUEBRA_LINHA, String.valueOf(caractereAtual));
        } else if (caractereAtual == EOF) {
            t = new Token(TipoToken.EOF, "$");
        } else {
            abort("Caractere inesperado: " + caractereAtual);
        }
        proximoCaractere();
        return t;
    }

    public void abort(String msg) {
        throw new LexicalException(msg);
    }

    public void ignorarEspacoEmBranco() {
        while (caractereAtual == ' ' || caractereAtual == '\r' || caractereAtual == '\t') {
            proximoCaractere();
        }
    }

    public void ignorarComentarios() {
        if (caractereAtual == '#') {
            while (caractereAtual != '\n') {
                proximoCaractere();
            }
        }
    }

    public List<Token> tokens() {
        List<Token> tokens = new ArrayList<>();

        Token t = getToken();
        do {
            tokens.add(t);
            t = getToken();
        } while (t.tipo != TipoToken.EOF);

        tokens.add(new Token(TipoToken.EOF, "$"));
        return tokens;
    }

    public static void main(String[] args) {
        String input = "PRINT \"How many fibonacci numbers do you want?\"\n" +
                "INPUT nums\n" +
                "\n" +
                "LET a = 0\n" +
                "LET b = 1\n" +
                "WHILE nums > 0 REPEAT\n" +
                "    PRINT a\n" +
                "    LET c = a + b\n" +
                "    LET a = b\n" +
                "    LET b = c\n" +
                "    LET nums = nums - 1\n" +
                "ENDWHILE\t\n";
        LexerManual l = new LexerManual(input);
//        while (l.peek() != EOF) {
//            System.out.println(l.caractereAtual);
//            l.proximoCaractere();
//        }

        l = new LexerManual(input);
        List<Token> tokens = l.tokens();
        for (Token t : tokens) {
            System.out.println(t);

        }


    }


}
