from lexer import *
from parse import *
from astvisitor import *

def main():
    if len(sys.argv) != 2:
        sys.exit("Erro: Precisamos de um arquivo como argumento.")
    with open(sys.argv[1], 'r') as inputFile:
        input = inputFile.read()

    lexer = Lexer(input)
    parser = Parser(lexer)
    expressions = parser.parse()
    print("Terminamos.")

    for exp in expressions:
        posFixa = PosFixa(exp)
        evaluator = Eval(exp)
        print(str(exp) + " == " + posFixa.posfixa() + " == " + str(evaluator.eval()))
    
main()