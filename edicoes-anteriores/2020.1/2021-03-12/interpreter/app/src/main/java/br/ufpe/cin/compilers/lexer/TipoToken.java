package br.ufpe.cin.compilers.lexer;

public enum TipoToken {

    EOF(-1),
    QUEBRA_LINHA(0),
    ID(1),
    NUM(2),
    STRING(3),
    //Palavras reservadas
    LABEL(101),
    GOTO(102),
    PRINT(103),
    INPUT(104),
    LET(105),
    IF(106),
    THEN(107),
    ENDIF(108),
    WHILE(109),
    REPEAT(110),
    ENDWHILE(111),
    //Operadores
    ATRIBUICAO(201),
    ADICAO(202),
    SUBTRACAO(203),
    MULTIPLICACAO(204),
    DIVISAO(205),
    IGUAL_A(206),
    DIFERENTE_DE(207),
    MENOR_QUE(208),
    MENOR_QUE_OU_IGUAL(209),
    MAIOR_QUE(210),
    MAIOR_QUE_OU_IGUAL(211)
    ;

    private final int tipo;
    TipoToken(int tipo) {
        this.tipo = tipo;
    }
    public int getTipo() {
        return tipo;
    }
}
