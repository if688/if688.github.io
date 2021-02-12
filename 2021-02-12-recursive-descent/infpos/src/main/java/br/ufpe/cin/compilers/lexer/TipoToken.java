package br.ufpe.cin.compilers.lexer;

public enum TipoToken {

    PONTO_VIRGULA(0),
    ID(1),
    NUM(2),
    PRINT(101),
    ADICAO(201),
    SUBTRACAO(202),
    ATRIBUICAO(203),
    PARENTESES_ESQ(204),
    PARENTESES_DIR(205),
    EOF(-1);

    private final int tipo;
    TipoToken(int tipo) {
        this.tipo = tipo;
    }
    public int getTipo() {
        return tipo;
    }
}
