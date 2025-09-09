from lexer import *
from parse import *
from visitor import *
from symboltable import *
import sys

def main(): 
    symbolTable = SymbolTable()
    print(symbolTable)

    INT_type = symbolTable.lookup('INT')
    # print(INT_type)
    BOOLEAN_type = symbolTable.lookup('BOOLEAN')

    symbolTable.insert('x', VarSymbol('x', INT_type, 42))
    symbolTable.insert('y', VarSymbol('y', INT_type))
    symbolTable.insert('b', VarSymbol('b', BOOLEAN_type))
    print(symbolTable)

    symbolTable.update('b',VarSymbol('b', INT_type, 30))
    print(symbolTable)

    
main()