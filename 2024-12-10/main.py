from lexer import *
from parse import *

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
        print(exp)

    print("Terminamos.")

main()