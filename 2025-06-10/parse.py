import sys
from lexer import *
from astnodes import *

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
        prog = self.S()
        self.match(TokenType.EOF)
        return prog
        
    #     S ::= (E";")*
    def S(self):
        explist = []
        while not(self.checkToken(TokenType.EOF)):
            explist.append(self.E())
            self.match(TokenType.SEMICOLON)
        return explist
    

    #     E ::= T (("+"|"-") T)*
    def E(self):
        node = self.T()
        while True:
            if self.checkToken(TokenType.PLUS):
                self.match(TokenType.PLUS)
                t = self.T()
                node = SomaExpr(node, t)
            elif self.checkToken(TokenType.MINUS):
                self.match(TokenType.MINUS)
                t = self.T()
                node = SubExpr(node, t)
            else:
                break
        return node

    #     T ::= F (("*"|"/") F)* 
    def T(self):
        node = self.F()
        while self.checkToken(TokenType.ASTERISK) or self.checkToken(TokenType.SLASH):
            if self.checkToken(TokenType.ASTERISK):
                self.match(TokenType.ASTERISK)
                f = self.F()
                node = MulExpr(node, f)
            elif self.checkToken(TokenType.SLASH):
                self.match(TokenType.SLASH)
                f = self.F()
                node = DivExpr(node, f)
        return node

    #     F ::= num | id | "(" E ")"
    def F(self):
        node = None
        if self.checkToken(TokenType.NUMBER):
            numero = int(self.tokenAtual.text)
            self.match(TokenType.NUMBER)
            node = NumExpr(numero)
        elif self.checkToken(TokenType.IDENT):
            nome = self.tokenAtual.text
            self.match(TokenType.IDENT)
            node = IdExpr(nome)
        elif self.checkToken(TokenType.L_PAREN):
            self.match(TokenType.L_PAREN)
            exp = self.E()
            self.match(TokenType.R_PAREN)
            node = ParentesesExpr(exp)
            # node = exp
        else:
            self.abort('Token inesperado!')
        
        return node