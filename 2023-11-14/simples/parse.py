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
        return tipo == self.tokenAtual.tipo

    #Retorna true se o próximo Token **(peek)** casa com tipo de Token esperado
    def checkPeek(self, tipo):
        return tipo == self.proximoToken.tipo

    #Tenta fazer o casamento do Token atual. Se conseguir, avança para o próximo Token. Do contrário, gera mensagem de erro.
    def match(self, tipo):
        if not self.checkToken(tipo):
            self.abort("Esperava por token do tipo " + tipo.name + ", mas apareceu " + self.tokenAtual.tipo.name)
        else:
            self.nextToken()

    # Avançando com os ponteiros dos tokens (atual e peek)
    def nextToken(self):
        self.tokenAtual = self.proximoToken
        self.proximoToken = self.lexer.getToken()

    def abort(self, msg):
        sys.exit("Erro sintático: "+msg)

    def parse(self):
        self.expr()

############################
    def S(self):
        self.match(TipoToken.a)
        self.A()
        self.B()
        self.match(TipoToken.e)

    def A(self):
        self.match(TipoToken.b)
        self.K()

    def K(self):
        if self.checkToken(TipoToken.b):
            self.match(TipoToken.b)
            self.match(TipoToken.c)
            self.K()
        else:
            pass
    
    def B(self):
        self.match(TipoToken.d)


############
    def expr(self):
        self.term()
        self.rest()

    def rest(self):
        if self.checkToken(TipoToken.SOMA):
            self.match(TipoToken.SOMA)
            self.term()
            self.rest()
        elif self.checkToken(TipoToken.SUBTRACAO):
            self.match(TipoToken.SUBTRACAO)
            self.term()
            self.rest()
        elif self.checkToken(TipoToken.EOF):
            pass
        else:
            self.abort("Token inesperado: "+str(self.tokenAtual.tipo))

    def term(self):
        self.match(TipoToken.NUMERO)
    