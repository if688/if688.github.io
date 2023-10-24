from lexer import *
from parse import *
from symboltable import *
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
    # print(type(explist))

    symbolTable = SymbolTable()

    for decl in program.declarations: 
        print(decl)
        symbolTable.inserir(decl.nome,decl.exp)
    # Loop abaixo calcula o resultado da expressão, não pode ter Identificadores
    for exp in program.expressions:
        print(exp)
        evalVisitor = EvalVisitor(exp, symbolTable)
        print(evalVisitor.eval())
        # posFixa = exp.posFixa()
        # resultadoEval = str(exp.eval())
        # print(posFixa + " == " + resultadoEval)
        # print('-----')
    #     resultadoVisitor = str(Eval(exp).eval())
    #     posFixa = PosFixa(exp).posFixa()
    #     parenteses = ParenthesisPrint(exp).parenthesize()
    #     print(parenteses + " == " + resultadoEval + " == " + resultadoVisitor + " == " + posFixa)
    # Loop apenas para posfixa e parenteses
    # for exp in explist:
    #     posFixa = PosFixa(exp).posFixa()
    #     parenteses = ParenthesisPrint(exp).parenthesize()
    #     print(parenteses + " == " + posFixa)  
main()