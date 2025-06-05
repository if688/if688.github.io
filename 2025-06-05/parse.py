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

    # S → aABe
    # A → bK
    # K → bcK
    # K → ε
    # B → d

    def parse(self):
        # trocar se resolver alterar para a gramática
        # self.S()

        self.expr()
        
        # comentar a linha abaixo pode levar a erros
        self.match(TipoToken.EOF)

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

    # K → bcK
    # K → ε
    def K(self):
        if self.checkToken(TipoToken.b):
            self.match(TipoToken.b)
            self.match(TipoToken.c)
            self.K()
        elif self.checkToken(TipoToken.d):
            pass
        else: 
            self.abort('Esperava por um token do tipo b ou d, mas apareceu '+self.tokenAtual.tipo.name)

    # B → d
    def B(self):
        self.match(TipoToken.d)

    # expr	→ 	term rest 
    def expr(self):
        self.term()
        self.rest()

    # rest	→	+ term	rest
    # rest	→	- term rest
    # rest	→	ε 
    def rest(self):
        if self.checkToken(TipoToken.SOMA):
            self.match(TipoToken.SOMA)
            self.term()
            self.rest()
        elif self.checkToken(TipoToken.SUBTRACAO):
            self.match(TipoToken.SUBTRACAO)
            self.term()
            self.rest()
        else: 
            pass
    # term	→	0
    # …
    # term	→	9
    def term(self):
        self.match(TipoToken.DIGITO)
    