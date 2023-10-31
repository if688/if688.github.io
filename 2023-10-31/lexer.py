import enum
import sys

class Lexer:
    def __init__(self, source):
        self.source = source + '\n'
        self.caractereAtual = ''
        self.posicaoAtual = -1
        self.proximoCaractere()
    
    # Processa o próximo caractere
    def proximoCaractere(self):
        pass

    # Retorna o caractere de lookahead (qual o que vem aí)
    def peek(self):
        pass


    # Token inválido, imprime mensagem de erro
    def abort(self, message):
        pass
		
    # Pula espaços em branco
    def skipWhitespace(self):
        pass
		
    # Pula comentários
    def skipComment(self):
        pass

    # Retorna o próximo token
    def getToken(self):
        pass

class Token:
    def __init__(self, lexema, tipo) -> None:
        self.lexema = lexema
        self.tipo = tipo

class TipoToken(enum.Enum):
    EOF = -1
    NUMERO = 1
    SOMA = 202