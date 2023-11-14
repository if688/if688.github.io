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
        self.posicaoAtual+=1
        if self.posicaoAtual >= len(self.source):
            self.caractereAtual = None #EOF
        else:
            self.caractereAtual = self.source[self.posicaoAtual]

    # Retorna o caractere de lookahead (qual o que vem aí)
    def peek(self):
        if self.posicaoAtual+1 >= len(self.source):
            return None #EOF
        else:
            return self.source[self.posicaoAtual+1]

    # Token inválido, imprime mensagem de erro
    def abort(self, message):
        sys.exit('Erro Léxico: '+message)
		
    # Pula espaços em branco
    def skipWhitespace(self):
        while self.caractereAtual == ' ' or self.caractereAtual == '\t' or self.caractereAtual == '\n': 
            self.proximoCaractere()
		
    # Pula comentários
    def skipComment(self):
        pass

    # Retorna o próximo token
    def getToken(self):
        self.skipWhitespace()
        token = None
        if self.caractereAtual is None: 
            token = Token(self.caractereAtual, TipoToken.EOF)
        elif self.caractereAtual == '+':
            token = Token(self.caractereAtual, TipoToken.SOMA)
        elif self.caractereAtual == '-':
            token = Token(self.caractereAtual, TipoToken.SUBTRACAO)
        elif self.caractereAtual == '*':
            token = Token(self.caractereAtual, TipoToken.MULTIPLICACAO)
        elif self.caractereAtual == '/':
            token = Token(self.caractereAtual, TipoToken.DIVISAO)
        elif self.caractereAtual.isdigit():
            posicaoInicial = self.posicaoAtual
            while self.peek()!=None and self.peek().isdigit():
                self.proximoCaractere()
            lexema = self.source[ posicaoInicial : self.posicaoAtual+1 ]
            token = Token(lexema, TipoToken.NUMERO)
        elif self.caractereAtual.isalpha():
            posicaoInicial = self.posicaoAtual
            while self.peek()!=None and self.peek().isalnum():
                self.proximoCaractere()
            lexema = self.source[ posicaoInicial : self.posicaoAtual+1 ]
            tipo = Token.checaPalavraReservada(lexema)
            if tipo == None:
                token = Token(lexema, TipoToken.IDENTIFICADOR)
            else: 
                token = Token(lexema, tipo)
        else:
            self.abort("Caractere não reconhecido: "+self.caractereAtual)
        self.proximoCaractere()
        return token

class Token:
    def __init__(self, lexema, tipo) -> None:
        self.lexema = lexema
        self.tipo = tipo
    @staticmethod
    def checaPalavraReservada(lexema):
        for tipo in TipoToken:
            if tipo.name == lexema and tipo.value > 100 and tipo.value < 200:
                return tipo
        return None

class TipoToken(enum.Enum):
    EOF = -1
    NUMERO = 1
    IDENTIFICADOR = 2
    #INICIO PALAVRAS RESERVADAS 100
    a = 105
    b = 106
    c = 107
    d = 108
    e = 109
    #FIM PALAVRAS RESERVADAS 200
    SOMA = 202
    SUBTRACAO = 203
    MULTIPLICACAO = 204
    DIVISAO = 205