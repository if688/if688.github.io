from lex import *

def main():
    source = """a b c d e"""
    lexer = Lexer(source)
    token = lexer.getToken()
    
    while token.tipo != TipoToken.EOF:
        print(str(token.tipo) + " (" + token.lexema + ')')
        token = lexer.getToken()
main()