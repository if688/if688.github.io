from lexer import *
from parse import *

def main():
    if len(sys.argv) != 2:
        print("Um arquivo não foi passado como argumento, portanto, digite uma entrada a seguir: ")
        inputString = input()
    else: 
        with open(sys.argv[1], 'r') as inputFile:
            inputString = inputFile.read()

    lexer = Lexer(inputString)
    parser = Parser(lexer)
    parser.parse()
    print("Terminamos.")
    
main()