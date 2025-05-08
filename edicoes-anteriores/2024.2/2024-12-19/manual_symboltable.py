from lexer import *
from parse import *
from visitor import *
from symboltable import *
import sys

def main(): 
    symbolTable = SymbolTable()
    print(symbolTable)
    INT = symbolTable.lookup('INT')

    symbolTable.insert('y', VarSymbol('y', INT, 120))
    symbolTable.insert('x', VarSymbol('x', INT))
    print(symbolTable)

    

main()