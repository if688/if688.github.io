import sys
from lexer import *

class Parser: 
    def __init__(self, lexer):
        self.lexer = lexer
        self.tokenAtual = None
        self.proximoToken = None
        self.nextToken()
        self.nextToken()

    #Retorna true se o Token **atual** casa com tipo de Token esperado
    def checkToken(self, tipo):
        return tipo == self.tokenAtual.kind

    #Retorna true se o próximo Token **(peek)** casa com tipo de Token esperado
    def checkPeek(self, tipo):
        return tipo == self.proximoToken.kind

    #Tenta fazer o casamento do Token atual. Se conseguir, avança para o próximo Token. Do contrário, gera mensagem de erro.
    def match(self, tipo):
        if not self.checkToken(tipo):
            self.abort("Esperava por token do tipo " + tipo.name + ", mas apareceu " + self.tokenAtual.kind.name)
        else:
            self.nextToken()

    # Avançando com os ponteiros dos tokens (atual e peek)
    def nextToken(self):
        self.tokenAtual = self.proximoToken
        self.proximoToken = self.lexer.getToken()

    def abort(self, msg):
        sys.exit("Erro sintático: "+msg)

    #     S' ::= S$
    #     S ::= (E";")*
    #     E ::= T (("+"|"-") T)*
    #     T ::= F (("*"|"/") F)* 
    #     F ::= num | id | "(" E ")"
    
    #     S' ::= S$
    def parse(self):
        self.S()
        self.match(TokenType.EOF)


    #     S ::= (E";")*
    def S(self):
        while not self.checkToken(TokenType.EOF):
            self.E()
            self.match(TokenType.SEMICOLON)

    #     E ::= T (("+"|"-") T)*
    def E(self):
        self.T()
        while (self.checkToken(TokenType.PLUS) or self.checkToken(TokenType.MINUS)):
            self.nextToken()
            self.T()
    
    #     T ::= F (("*"|"/") F)* 
    def T(self):
        self.F()
        while (self.checkToken(TokenType.ASTERISK) or self.checkToken(TokenType.SLASH)):
            self.nextToken()
            self.F()

    #     F ::= num | id | "(" E ")"
    def F(self):
        if self.checkToken(TokenType.NUMBER):
            self.match(TokenType.NUMBER)
        elif self.checkToken(TokenType.IDENT):
            self.match(TokenType.IDENT)
        elif self.checkToken(TokenType.L_PAREN):
            self.match(TokenType.L_PAREN)
            self.E()
            self.match(TokenType.R_PAREN)
        