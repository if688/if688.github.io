import sys
from lexer import *
from astnodes import *

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
    #     S ::= (E;)*
    #     E ::= T (("+"|"-") T)*
    #     T ::= F (("*"|"/") F)* 
    #     F ::= num | id | "(" E ")"

    #     S' ::= S$
    def parse(self):
        exps = self.S()
        self.match(TokenType.EOF)
        return exps 
        

    # S ::= (E;)*
    def S(self):
        explist = []
        while not(self.checkToken(TokenType.EOF)):
            explist.append(self.E())
            self.match(TokenType.SEMICOLON)
        return explist

    # E ::= T (("+"|"-") T)*
    # E -> T
    # E -> T + T
    # E -> T - T
    def E(self):
        e = self.T()
        while self.checkToken(TokenType.PLUS) or self.checkToken(TokenType.MINUS):
            if self.checkToken(TokenType.PLUS):
                self.match(TokenType.PLUS)
                t = self.T()
                e = SumExpr(e, t)
            elif self.checkToken(TokenType.MINUS):
                self.match(TokenType.MINUS)
                t = self.T()
                e = SubExpr(e, t)
        return e
    # T ::= F (("*"|"/") F)* 
    def T(self):
        e = self.F()
        while self.checkToken(TokenType.ASTERISK) or self.checkToken(TokenType.SLASH):
            if self.checkToken(TokenType.ASTERISK):
                self.match(TokenType.ASTERISK)
                f = self.F()
                e = MulExpr(e, f)
            elif self.checkToken(TokenType.SLASH):
                self.match(TokenType.SLASH)
                f = self.F()
                e = DivExpr(e, f)
        return e
    # F ::= num | id | "(" E ")"
    def F(self):
        e = None
        if self.checkToken(TokenType.NUMBER):
            valorTokenAtual = self.curToken.text
            valorNumerico = int(valorTokenAtual)
            e = NumExpr(valorNumerico)
            self.match(TokenType.NUMBER)
        elif self.checkToken(TokenType.IDENT):
            e = IdExpr(self.curToken.text)
            self.match(TokenType.IDENT)
        elif self.checkToken(TokenType.L_PAREN):
            self.match(TokenType.L_PAREN)
            e = self.E()
            self.match(TokenType.R_PAREN)
        else: 
            self.abort("Token inesperado, esperava um número, um identificador, ou um abre parênteses, recebeu: " + self.curToken.text)
        return e
