import sys
from lexer import *

def main():
    if len(sys.argv) != 2:
        sys.exit("Erro: Precisamos de um arquivo como argumento.")
    with open(sys.argv[1], 'r') as inputFile:
        input = inputFile.read()
        
    lexer = Lexer(input)
    print(input)
    token = lexer.getToken()
    while token.type != TokenType.EOF:
        print(str(token.type) + '('+ token.text + ')')
        token = lexer.getToken()

main()