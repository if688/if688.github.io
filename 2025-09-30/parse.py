import sys
from lexer import *

class Parser: 
    def __init__(self, lexer):
        self.lexer = lexer 
        self.tokenAtual = None
        self.proximoToken = None
        self.nextToken()
        self.nextToken() 

    # Avançando com os ponteiros dos tokens (atual e peek)
    def nextToken(self):
        self.tokenAtual = self.proximoToken
        self.proximoToken = self.lexer.getToken()

    #Retorna true se o Token **atual** casa com tipo de Token esperado
    def checkToken(self, tipo):
        return tipo == self.tokenAtual.tipo

    #Retorna true se o próximo Token **(peek)** casa com tipo de Token esperado
    def checkPeek(self, tipo):
        return tipo == self.proximoToken.tipo

    #Tenta fazer o casamento do Token atual. Se conseguir, avança para o próximo Token. Do contrário, gera mensagem de erro.
    def match(self, tipo):
        if self.checkToken(tipo):
            self.nextToken()
        else:
            self.abort('Esperava por token do tipo '+str(tipo)+' e recebeu token do tipo '+str(self.tokenAtual.tipo))

    def abort(self, msg):
        sys.exit("Erro sintático: "+msg)

    def parse(self):
        self.S()
        # comentar a linha abaixo pode levar a erros
        self.match(TipoToken.EOF)

    # Gramática simples, sem palavra vazia
    # X → aYZe
    # Y → bW
    # W → c
    # Z → d
    def X(self):
        self.match(TipoToken.a)
        self.Y()
        self.Z()
        self.match(TipoToken.e)
    def Y(self):
        self.match(TipoToken.b)
        self.W()
    def W(self):
        self.match(TipoToken.c)
    def Z(self):
        self.match(TipoToken.d)

    
    # Gramática com palavra vazia
    # S → aABe
    def S(self):
        self.match(TipoToken.a)
        self.A()
        self.B()
        self.match(TipoToken.e)
    # A → bK
    def A(self):
        self.match(TipoToken.b)
        self.K()
    # Ilustrando o motivo de recursão a esquerda ser um problema em top-down
    # # C → Cbc
    # def C(self):
    #     self.C()
    #     self.match(TipoToken.b)
    #     self.match(TipoToken.c)

    # K → bcK
    # K → ε
    def K(self):
        # K → bcK
        if self.checkToken(TipoToken.b):
            self.match(TipoToken.b)
            self.match(TipoToken.c)
            self.K()
        # K → ε
        elif self.checkToken(TipoToken.d):
            pass
        else:
            self.abort('Esperava por token do tipo b ou d e recebeu token do tipo '+str(self.tokenAtual.tipo))
    # B → d
    def B(self):
        self.match(TipoToken.d)


    