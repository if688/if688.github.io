from lexer import *

def main():
    source = "+-           */\n"
    source = "212 + 33 * 444"# outros operadores aritméticos também / -
    source = "x = 2+3 *4"# ID(x) ASSIGN NUM PLUS NUM MULT NUM

    source = """
    IF(x > 3) THEN 
        y = 2 
        PRINT x+y
    ENDIF"""
    source = "IF THEN x IFx teste=123x"
    lexer = Lexer(source)
    token = lexer.getToken()
    while token.tipo != TipoToken.EOF:
        print(str(token.tipo) + " (" + token.lexema + ')')
        token = lexer.getToken()
main()