package br.ufpe.cin.if688.lexer;

public enum TipoToken {

    PONTO_VIRGULA(0),
    ID(1),
    NUM(2),
    PRINT(101),
    VAR(102),
    WHILE(103),
    IF(104),
    ADICAO(201),
    SUBTRACAO(202),
    MULTIPLICACAO(203),
    DIVISAO(204),
    ATRIBUICAO(205),
    PARENTESES_ESQ(206),
    PARENTESES_DIR(207),
    EOF(-1);

    private final int tipo;
    TipoToken(int tipo) {
        this.tipo = tipo;
    }
    public int getTipo() {
        return tipo;
    }
}
