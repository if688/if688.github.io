package br.ufpe.cin.if688.lexer;

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
            t = new Token(TipoToken.ATRIBUICAO, String.valueOf(caractereAtual));
        } else if (caractereAtual == ';') {
            t = new Token(TipoToken.PONTO_VIRGULA, String.valueOf(caractereAtual));
        } else if (caractereAtual == '(') {
            t = new Token(TipoToken.PARENTESES_ESQ, String.valueOf(caractereAtual));
        } else if (caractereAtual == ')') {
            t = new Token(TipoToken.PARENTESES_DIR, String.valueOf(caractereAtual));
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
        while (caractereAtual == ' ' || caractereAtual == '\n' || caractereAtual == '\r' || caractereAtual == '\t') {
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

        return tokens;
    }

    public static void main(String[] args) {
        String input = "x = 3;\n" +
                "ya = 22+4-10;\n" +
                "print(x2);";
        LexerManual l = new LexerManual(input);
        while (l.peek() != EOF) {
            System.out.println(l.caractereAtual);
            l.proximoCaractere();
        }

    }


}
