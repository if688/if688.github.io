import sys
from lexer import *

programa = "as+2+c+-"

def lexer_muito_muito_simples(programa):
    for c in programa:
        if c.isalpha():
            print("ID("+c+")")
        elif c == '+':
            print("SOMA")
        elif c.isnumeric():
            print("NUM("+c+")")
        else:
            raise(Exception("erro, caractere não reconhecido: "+c))


def main():
    #codigo = "PRINT 237854 WHILE + ENDWHILE x IDENT SOMA"
    if len(sys.argv) != 2:
        sys.exit("Erro: precisamos de um arquivo como argumento.")
    with open(sys.argv[1],'r') as entrada:
        codigo = entrada.read()
    lexer = Lexer(codigo)
    token = lexer.getToken()
    while token.tipo != TipoToken.EOF:
        print(str(token.tipo) +" : "+token.lexema)
        token = lexer.getToken()

main()