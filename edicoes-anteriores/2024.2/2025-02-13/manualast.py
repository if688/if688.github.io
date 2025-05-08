from lexer import *
from parse import *
from visitor import *
import sys

def main(): 
    program = Program("simples", [PrintStmt(StringExpr("Hello World")),PrintStmt(StringExpr("Outro hello"))])

    # program = Program(
    #     "simples",
    #     [
    #         PrintStmt(
    #             StringExpr(
    #                 "Hello World"
    #             )
    #         )
    #         ,
    #         PrintStmt(
    #             StringExpr(
    #                 "Outro hello"
    #             )
    #         )
    #     ]
    # )
    print(program)
    visitor = CountPrint(program)
    print('Antes de contar: '+ str(visitor.numPrint))
    visitor.contar()
    print('Depois de contar: '+ str(visitor.numPrint))
    

main()