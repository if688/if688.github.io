import enum
import sys


class Lexer:
    def __init__(self, source) -> None:
        self.source = source+'\n'
        self.curChar = None
        self.curPos = -1
        self.nextChar()

    def nextChar(self):
        self.curPos+=1
        if self.curPos < len(self.source) :
            self.curChar = self.source[self.curPos]
        else :
            self.curChar = '$'

    def peek(self):
        if self.curPos +1 >= len(self.source) :
            return None
        return self.source[self.curPos+1]

    def abort(self, message):
        sys.exit('Erro Léxico: ' + message)

    def skipWhitespace(self):
        while self.curChar == ' ' or self.curChar == '\n' or self.curChar == '\t':
            self.nextChar()

    def skipComment(self):
        pass

    def getToken(self):
        self.skipWhitespace()
        token = None
        if self.curChar == '+':
            token = Token(self.curChar, TokenType.SUM)
        elif self.curChar == '-':
            token = Token(self.curChar, TokenType.SUB)
        elif self.curChar == '*':
            token = Token(self.curChar, TokenType.MUL)
        elif self.curChar == '/':
            token = Token(self.curChar, TokenType.DIV)
        elif self.curChar == ':':
            token = Token(self.curChar, TokenType.COLON)
        elif self.curChar == '{':
            token = Token(self.curChar, TokenType.L_BRACKET)
        elif self.curChar == '}':
            token = Token(self.curChar, TokenType.R_BRACKET)
        elif self.curChar == '(':
            token = Token(self.curChar, TokenType.L_PAREN)
        elif self.curChar == ')':
            token = Token(self.curChar, TokenType.R_PAREN)
        elif self.curChar == '>':
            token = Token(self.curChar, TokenType.GT)
        elif self.curChar == '=':
            token = Token(self.curChar, TokenType.ASSIGN)
        elif self.curChar == '$':
            token = Token(self.curChar, TokenType.EOF)
        elif self.curChar.isdigit():
            numero = self.curChar
            while self.peek().isdigit():
                self.nextChar()
                numero+=self.curChar
            token = Token(numero, TokenType.NUM)
        elif self.curChar.isalpha():
            posInicial = self.curPos
            while self.peek().isalnum():
                self.nextChar()
            posFinal = self.curPos
            lexema = self.source[posInicial : posFinal + 1]
            tipoToken = Token.checkIfKeyword(lexema.upper())
            if tipoToken is None :
                token = Token(lexema, TokenType.ID)
            else:
                token = Token(lexema, tipoToken)
        else : 
            self.abort('Caractere inesperado --> ' + self.curChar)
        self.nextChar()
        return token

class Token:
    def __init__(self, tokenText, tokenType) -> None:
        self.text = tokenText
        self.type = tokenType
    @staticmethod
    def checkIfKeyword(tokenText):
        for t in TokenType:
            if t.name == tokenText and t.value >=50 and t.value <=100:
                return t
        return None
        

class TokenType(enum.Enum):
    EOF = -1
    NUM = 1
    ID = 2

    SUM = 10
    SUB = 11
    MUL = 12
    DIV = 13

    GT = 15

    ASSIGN = 20
    COLON = 21
    L_BRACKET = 22
    R_BRACKET = 23
    L_PAREN = 24
    R_PAREN = 25

    WHILE = 51
    IF = 52
    FOR = 53
    PRINT = 54

    