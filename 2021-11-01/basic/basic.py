from lexer import *
from parser import *
from visitor import *
import sys

def main(): 
    if len(sys.argv) != 2:
        sys.exit("Erro: Precisamos de um arquivo como argumento.")
    with open(sys.argv[1], 'r') as inputFile:
        input = inputFile.read()

    lexer = Lexer(input)
    parser = Parser(lexer)
    program = parser.parse()
    print(program)
    visitor = CountVars(program)
    print("Número de variáveis declaradas: " + str(visitor.count()))
    visitor = CountPrint(program)
    print("Número de statements print: " + str(visitor.count()))
    visitor = Interpreter(program)
    print(visitor.symbolTable)
    visitor.interpret()
    print(visitor.symbolTable)

    

main()