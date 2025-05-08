from lexer import *

source = '2   +   4  - 3 * 8'
source = '2+4-3*8'
source = '\t\t\t\n+   -     *      '
source = '22 + 412..34 5.678904 - 33 * 88'
source = '2   +   4 / while elif else - x2 * x'
lexer = Lexer(source)

token = lexer.getToken()
while token.type != TokenType.EOF:
    print(str(token.type) + '('+ token.text + ')')
    token = lexer.getToken()
