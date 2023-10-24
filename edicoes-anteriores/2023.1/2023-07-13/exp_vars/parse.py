import sys
from lexer import *

class Parser: 
    def __init__(self, lexer):
        self.lexer = lexer
        self.curToken = None
        self.peekToken = None
        self.nextToken()
        self.nextToken()

    #Retorna true se o token **atual** casa com kind
    def checkToken(self, kind):
        return kind == self.curToken.kind

    #Retorna true se o próximo token **(peek)** casa com kind
    def checkPeek(self, kind):
        return kind == self.peekToken.kind

    def match(self, kind):
        if not self.checkToken(kind):
            self.abort("Esperava por " + kind.name + ", apareceu " + self.curToken.kind.name)
        self.nextToken()

    # Avançando com os ponteiros dos tokens (atual e peek)
    def nextToken(self):
        self.curToken = self.peekToken
        self.peekToken = self.lexer.getToken()

    def abort(self, msg):
        sys.exit("Erro sintático: "+msg)

    #     S' ::= S$
    #     S ::= (D;)* "|"(E;)*
    #     E ::= T (("+"|"-") T)*
    #     T ::= F (("*"|"/") F)* 
    #     F ::= num | id | "(" E ")"

    #     S' ::= S$
    def parse(self):
        self.S()
        self.match(TokenType.EOF)

    # S ::= (D;)* "|"(E;)*
    def S(self):
        while not(self.checkToken(TokenType.SEPARATOR)):
            self.D()
            self.match(TokenType.SEMICOLON)
        self.match(TokenType.SEPARATOR)
        while not(self.checkToken(TokenType.EOF)):
            self.E()
            self.match(TokenType.SEMICOLON)
    
    # LET id "=" E ;
    def D(self):
        self.match(TokenType.LET)
        self.match(TokenType.IDENT)
        self.match(TokenType.EQ)
        self.E()

    # E ::= T (("+"|"-") T)*
    def E(self):
        self.T()
        while self.checkToken(TokenType.PLUS) or self.checkToken(TokenType.MINUS):
            if self.checkToken(TokenType.PLUS):
                self.match(TokenType.PLUS)
                self.T()
            elif self.checkToken(TokenType.MINUS):
                self.match(TokenType.MINUS)
                self.T()

    # T ::= F (("*"|"/") F)* 
    def T(self):
        self.F()
        while self.checkToken(TokenType.ASTERISK) or self.checkToken(TokenType.SLASH):
            if self.checkToken(TokenType.ASTERISK):
                self.match(TokenType.ASTERISK)
                self.F()
            elif self.checkToken(TokenType.SLASH):
                self.match(TokenType.SLASH)
                self.F()

    # F ::= num | id | "(" E ")"
    def F(self):
        if self.checkToken(TokenType.NUMBER):
            self.match(TokenType.NUMBER)
        elif self.checkToken(TokenType.IDENT):
            self.match(TokenType.IDENT)
        elif self.checkToken(TokenType.L_PAREN):
            self.match(TokenType.L_PAREN)
            self.E()
            self.match(TokenType.R_PAREN)
        else: 
            self.abort("Token inesperado, esperava um número, um identificador, ou um abre parênteses, recebeu: " + self.curToken.text)