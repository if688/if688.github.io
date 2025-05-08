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
    # program = SumExpr(NumExpr(21), NumExpr(32))
    # program = MulExpr(NumExpr(42), SumExpr(NumExpr(57), NumExpr(22)))
    
    for exp in program: 
        visitor = PrettyPrint(exp)
        resultado = visitor.prettyPrint()
        print(resultado)
        visitor = PosFixa(exp)
        resultado = visitor.posFixa()
        print(resultado)
        visitor = Eval(exp)
        resultado = visitor.eval()
        print(resultado)
        # print(exp)

    # p = SumExpr( 
    #     NumExpr(8),
    #     SumExpr(
    #         MulExpr(
    #             NumExpr(10),
    #             SubExpr(
    #                 NumExpr(7),
    #                 NumExpr(45)
    #             )
    #         ), 
    #         NumExpr(2)
    #     )
    # )
    # print("Terminamos.")

main()