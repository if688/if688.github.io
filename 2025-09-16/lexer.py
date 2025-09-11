import enum
import sys

class Lexer:
    def __init__(self, source) -> None:
        self.source = source+'\n'
        self.curChar = None
        self.curPos = -1
        self.nextChar()

    def nextChar(self):
        pass

    def peek(self):
        pass

    def abort(self, message):
        sys.exit('Erro Léxico: ' + message)

    def getToken(self):
        pass

class Token:
    def __init__(self, tokenText, tokenType) -> None:
        self.text = tokenText
        self.type = tokenType
        

class TokenType(enum.Enum):
    EOF = -1
    NUM = 1
    ID = 2


    