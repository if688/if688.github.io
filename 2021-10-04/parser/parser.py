import sys
from lexer import *

class Parser: 
    def __init__(self, lexer):
        pass

    #Retorna true se o Token **atual** casa com tipo de Token esperado
    def checkToken(self, tipo):
        pass

    #Retorna true se o próximo Token **(peek)** casa com tipo de Token esperado
    def checkPeek(self, tipo):
        pass

    #Tenta fazer o casamento do Token atual. Se conseguir, avança para o próximo Token. Do contrário, gera mensagem de erro.
    def match(self, tipo):
        pass

    # Avançando com os ponteiros dos tokens (atual e peek)
    def nextToken(self):
        pass

    def abort(self, msg):
        sys.exit("Erro sintático: "+msg)

    def parse(self):
        pass
