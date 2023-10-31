from lexer import *

def main():
    source = "2+3"
    lexer = Lexer(source)
    token = lexer.getToken()
    while token.tipo != TipoToken.EOF:
        print(str(token.tipo) + " (" + token.lexema + ')')
        token = lexer.getToken()
main()