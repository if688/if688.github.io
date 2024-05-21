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
        pass

    # program ::= statement

    # statement ::= 
    #   PRINT expression nl |
    #   INPUT IDENTIFICADOR nl |
    #   LET IDENTIFICADOR "=" expression nl |
    #   WHILE expression REPEAT nl {statement} ENDWHILE nl |
    #   IF expression "THEN" nl {statement} ENDIF nl

    # expression ::== equality

    # equality ::== comparison ( ("==" | "!=" ) comparison)*

    # comparison ::== term ( ("<" | "<=" | ">" | ">=" ) term)*

    # term ::== factor {("-" | "+") factor}

    # factor ::== unary {("*" | "/") unary}

    # unary ::== ["-" | "+" ] unary | primary

    # primary ::== NUM | ID | STRING