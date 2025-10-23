from lexer import *
from parse import *
from astnodes import *

def main():
    if len(sys.argv) != 2:
        sys.exit("Erro: Precisamos de um arquivo como argumento.")
    with open(sys.argv[1], 'r') as inputFile:
        input = inputFile.read()

    lexer = Lexer(input)
    parser = Parser(lexer)
    program = parser.parse()
    for exp in program:
        print(exp)
    # exp = SumExpr(
    #     NumExpr(2),
    #     NumExpr(3)
    # )
    # print(exp)

    

main()