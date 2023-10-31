from lexer import *

def lexer_simplorio(source): 
    for c in source:
        if c.isdigit():
            print("NUM("+c+")")
        elif c == '+':
            print("OP_SOMA")
        else:
            print("ERRO: Caractere não reconhecido")
    print("EOF")

def main():
    source = "23 -  4   +    56 * 42"
    source = "IF num3 != 42 THEN PRINT num3 ENDIF"
    # lexer_simplorio(source)
    
    lexer = Lexer(source)
    token = lexer.getToken()
    while token.tipo != TipoToken.EOF:
        print(str(token.tipo) + " (" + token.lexema + ')')
        token = lexer.getToken()
main()