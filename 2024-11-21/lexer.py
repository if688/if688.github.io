import enum
import sys

class Lexer:
    def __init__(self, source) -> None:
        self.source = source+'\n'
        self.curChar = None
        self.curPos = -1
        self.nextChar()

    def nextChar(self):
        self.curPos += 1
        if self.curPos >= len(self.source):
            self.curChar = '$'
        else:
            self.curChar = self.source[self.curPos]

    def peek(self):
        if self.curPos + 1 >= len(self.source):
            return None
        return self.source[self.curPos+1]

    def abort(self, message):
        sys.exit('Lexical error: ' + message)

    def skipWhitespace(self):
        while self.curChar== ' ' or self.curChar== '\t' or self.curChar== '\n':
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
        elif self.curChar == '$':
            token = Token('', TokenType.EOF)
        elif self.curChar.isdigit():
            startPos = self.curPos
            while self.peek().isdigit():
                self.nextChar()
            if self.peek() == '.':
                self.nextChar()
                if not self.peek().isdigit():
                    self.abort('A number must appear after the dot.')
                while self.peek().isdigit():
                    self.nextChar()
            endPos = self.curPos
            tokenText = self.source[startPos : endPos + 1]
            token = Token(tokenText, TokenType.NUM)
        elif self.curChar.isalpha():
            startPos = self.curPos
            while self.peek().isalnum():
                self.nextChar()
            endPos = self.curPos
            tokenText = self.source[startPos : endPos + 1]
            tokenType = Token.checkIfKeyword(tokenText.upper())
            if tokenType == None:
                token = Token(tokenText, TokenType.ID)
            else:
                token = Token(tokenText, tokenType)
        else:
            self.abort('Unknown character: ' + self.curChar)
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
    SUM = 3
    SUB = 4
    MUL = 5
    DIV = 6
    WHILE = 51
    IF = 52
    ELSE = 53
    