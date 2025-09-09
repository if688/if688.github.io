from lexer import *
from parse import *
from visitor import *

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

    # # # 42 + (57 + 22)
    # e = SomaExpr(
    #         NumExpr(42), 
    #         ParentesesExpr(
    #             SomaExpr(
    #                 NumExpr(57), NumExpr(22)
    #             )
    #         )
    #     )
    # print(e)

    # num_42 = NumExpr(42)
    # par = ParentesesExpr(num_42)
    # print(num_42)
    # print(par)

main()