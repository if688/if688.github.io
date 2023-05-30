from lexer import *
from parser import *
from astvisitor import *
import sys

def main(): 
    if len(sys.argv) != 2:
        sys.exit("Erro: Precisamos de um arquivo como argumento.")
    with open(sys.argv[1], 'r') as inputFile:
        input = inputFile.read()

    lexer = Lexer(input)
    parser = Parser(lexer)
    explist = parser.parse()
    # Loop abaixo calcula o resultado da expressão, não pode ter Identificadores
    # for exp in explist:
    #     resultadoEval = str(exp.eval())
    #     resultadoVisitor = str(Eval(exp).eval())
    #     posFixa = PosFixa(exp).posFixa()
    #     parenteses = ParenthesisPrint(exp).parenthesize()
    #     print(parenteses + " == " + resultadoEval + " == " + resultadoVisitor + " == " + posFixa)
    # Loop apenas para posfixa e parenteses
    for exp in explist:
        posFixa = PosFixa(exp).posFixa()
        parenteses = ParenthesisPrint(exp).parenthesize()
        print(parenteses + " == " + posFixa)  
main()