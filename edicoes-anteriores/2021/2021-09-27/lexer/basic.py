from lexer import *

def main(): 
    # entrada = "WHILE              nums > 0 REPEAT"
    # entrada = "+-    == =+=-        *           /"
    # entrada = " \"Digite um número\" 123.21 12 3 == >= > - != < <= x1 nums WHILE "
    entrada = """PRINT "How many fibonacci numbers do you want?"
INPUT nums

LET a = 0
LET b = 1
WHILE nums > 0 REPEAT
    PRINT a
    LET c = a + b
    LET a = b
    LET b = c
    LET nums = nums - 1
ENDWHILE """
    lexer = Lexer(entrada)

    # while lexer.peek() != '\0':
    #     print(lexer.caractereAtual)
    #     lexer.nextChar()

    token = lexer.getToken()
    while token.tipo != TokenType.EOF:
        print(token.tipo)
        token = lexer.getToken()

main()