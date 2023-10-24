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
    def parse(self):
        program = self.S()
        self.match(TokenType.EOF)
        return program

    # S ::= (D;)* "|"(E;)*
    def S(self):
        declarations = []
        expressions = []
        while not(self.checkToken(TokenType.SEPARATOR)):
            d = self.D()
            declarations.append(d)
            self.match(TokenType.SEMICOLON)
        self.match(TokenType.SEPARATOR)
        while not(self.checkToken(TokenType.EOF)):
            e = self.E()
            expressions.append(e)
            self.match(TokenType.SEMICOLON)
        return Program(declarations, expressions)
    
    # LET id "=" E ;
    def D(self):
        self.match(TokenType.LET)
        nome = self.curToken.text
        self.match(TokenType.IDENT)
        self.match(TokenType.EQ)
        e = self.E()
        return Declaration(nome, e)

    # E ::= T (("+"|"-") T)*
    def E(self):
        e = self.T()
        while self.checkToken(TokenType.PLUS) or self.checkToken(TokenType.MINUS):
            if self.checkToken(TokenType.PLUS):
                self.match(TokenType.PLUS)
                ladoEsquerdo = e
                ladoDireito = self.T()
                e = SumExpr(ladoEsquerdo, ladoDireito)
            elif self.checkToken(TokenType.MINUS):
                self.match(TokenType.MINUS)
                ladoDireito = self.T()
                e = SubExpr(e, ladoDireito)
        return e

    # T ::= F (("*"|"/") F)* 
    def T(self):
        e = self.F()
        while self.checkToken(TokenType.ASTERISK) or self.checkToken(TokenType.SLASH):
            if self.checkToken(TokenType.ASTERISK):
                self.match(TokenType.ASTERISK)
                ladoDireito = self.F()
                e = MulExpr(e,ladoDireito)
            elif self.checkToken(TokenType.SLASH):
                self.match(TokenType.SLASH)
                ladoDireito = self.F()
                e = DivExpr(e,ladoDireito)
        return e

    # F ::= num | id | "(" E ")"
    def F(self):
        e = None
        if self.checkToken(TokenType.NUMBER):
            valorNumerico = int(self.curToken.text)
            self.match(TokenType.NUMBER)
            e = NumExpr(valorNumerico)
        elif self.checkToken(TokenType.IDENT):
            nome = self.curToken.text
            self.match(TokenType.IDENT)
            e = IdExpr(nome)
        elif self.checkToken(TokenType.L_PAREN):
            self.match(TokenType.L_PAREN)
            e = self.E()
            self.match(TokenType.R_PAREN)
        else: 
            self.abort("Token inesperado, esperava um número, um identificador, ou um abre parênteses, recebeu: " + self.curToken.text)
        return e
    

