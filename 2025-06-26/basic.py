from lexer import *
from parse import *
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
    # visitor = CountPrint(program)
    # print('Antes de contar: '+ str(visitor.numPrint))
    # visitor.contar()
    # print('Depois de contar: '+ str(visitor.numPrint))

    
    # visitor = PrintAST(program)
    # print(visitor.printAST())

    visitor = BuildSymbolTable(program)
    print(visitor.symbolTable)
    symbolTable = visitor.buildTable()
    print(symbolTable)
    
    # visitor = TypeCheckVisitor(program)
    # visitor.typecheck()
    # print(visitor.symbolTable)
    

main()