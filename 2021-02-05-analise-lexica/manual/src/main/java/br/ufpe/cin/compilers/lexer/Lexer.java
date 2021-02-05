package br.ufpe.cin.compilers.lexer;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lexer {

    //programa de entrada
    private final String entrada;
    //tamanho do programa em caracteres
    private final int tamanhoEntrada;

    //em que ponto nós estamos
    private int posicao = 0;
    //linhas e colunas
    private int linha = 1;
    private int coluna = 0;

    private char caractereAtual;

    public Lexer(String input) {
        this.entrada = input;
        this.tamanhoEntrada = input.length();
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public Token scan() throws IOException {
        while (posicao < tamanhoEntrada) {
            caractereAtual = entrada.charAt(posicao);
            switch(caractereAtual) {
                case ' ':
                case '\n':
                    posicao++;
                    break;
                case '+':
                case '-':
                case '=':
                case ';':
                case '(':
                case ')':
                    posicao++;
                    return new Token(caractereAtual);
                default:
                    if (Character.isDigit(caractereAtual)) {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(caractereAtual);
                            posicao++;
                            if (posicao<tamanhoEntrada) {
                                caractereAtual = entrada.charAt(posicao);
                            }
                            else {
                                caractereAtual = ' ';
                            }
                        } while (Character.isDigit(caractereAtual));
                        int x = Integer.parseInt(sb.toString());
                        return new Num(x);
                    }
                    else if(Character.isLetter(caractereAtual)) {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(caractereAtual);
                            posicao++;
                            if (posicao<tamanhoEntrada) {
                                caractereAtual = entrada.charAt(posicao);
                            }
                            else {
                                caractereAtual = ' ';
                            }
                        } while (Character.isLetterOrDigit(caractereAtual));
                        String palavra = sb.toString();
                        if (palavra.equals("print")) {
                            return new Token(Tag.PRINT);
                        }
                        else {
                            return new Id(palavra);
                        }
                    }
                    else {
                        throw new IOException("Caractere ilegal");
                    }
            }
        }
        return new Token(Tag.EOF);
    }

    public List<Token> tokens() throws IOException {
        List<Token> tokens = new ArrayList<>();
        Token t = scan();
        tokens.add(t);
        while (t.tag != Tag.EOF) {
            t = scan();
            tokens.add(t);
        }

        return tokens;
    }
}
