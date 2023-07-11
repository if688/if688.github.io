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
        self.posicaoAtual += 1
        if self.posicaoAtual >= len(self.source):
            self.caractereAtual = '\0' #EOF --> End of File
        else:
            self.caractereAtual = self.source[self.posicaoAtual]

    # Retorna o caractere de lookahead (qual o que vem aí)
    def peek(self):
        if self.posicaoAtual+1 >= len(self.source):
            return '\0' #EOF --> End of File
        else:
            return self.source[self.posicaoAtual+1]


    # Token inválido, imprime mensagem de erro
    def abort(self, message):
        sys.exit("Erro léxico. "+message)
		
    # Pula espaços em branco
    def skipWhitespace(self):
        while self.caractereAtual == ' ' or self.caractereAtual == '\t' or self.caractereAtual == '\r':
            self.proximoCaractere()
		
    # Pula comentários
    def skipComment(self):
        pass

    # Retorna o próximo token
    def getToken(self):
        self.skipWhitespace()
        token = None

        if self.caractereAtual == '+':
            token = Token(self.caractereAtual, TipoToken.SOMA)
        elif self.caractereAtual == '-':
            token = Token(self.caractereAtual, TipoToken.SUBTRACAO)
        elif self.caractereAtual == '*':
            token = Token(self.caractereAtual, TipoToken.MULT)
        elif self.caractereAtual == '/':
            token = Token(self.caractereAtual, TipoToken.DIVISAO)
        elif self.caractereAtual == '=':
            token = Token(self.caractereAtual, TipoToken.ATRIBUICAO)
        elif self.caractereAtual == '\n':
            token = Token(self.caractereAtual, TipoToken.QUEBRA_LINHA)
        elif self.caractereAtual == '\0':
            token = Token(self.caractereAtual, TipoToken.EOF)
        elif self.caractereAtual == '>':
            if self.peek() == '=':
                token = Token('>=', TipoToken.MAIOR_IGUAL)
                self.proximoCaractere()
            else:
                token = Token(self.caractereAtual, TipoToken.MAIOR_QUE)
        elif self.caractereAtual.isdigit():
            posicaoInicial = self.posicaoAtual
            while self.peek().isdigit():
                self.proximoCaractere()
            lexema = self.source[posicaoInicial : self.posicaoAtual + 1]
            token = Token(lexema, TipoToken.NUMERO)
        elif self.caractereAtual.isalpha():
            posicaoInicial = self.posicaoAtual
            while self.peek().isalnum():
                self.proximoCaractere()
            lexema = self.source[posicaoInicial : self.posicaoAtual + 1]
            tipo = Token.checaPalavraReservada(lexema)
            #verificar se é palavra reservada
            if tipo == None:
                token = Token(lexema, TipoToken.IDENT)
            else:
                token = Token(lexema, tipo)
        else:#Símbolo/Token desconhecido
            self.abort("Símbolo desconhecido: " + self.caractereAtual)
        self.proximoCaractere()
        return token

class Token:
    def __init__(self, lexema, tipo) -> None:
        self.lexema = lexema
        self.tipo = tipo
    @staticmethod
    def checaPalavraReservada(lexema):
        for tipo in TipoToken:
            if tipo.name == lexema and tipo.value >=100 and tipo.value <200:
                return tipo
        return None

class TipoToken(enum.Enum):
    EOF = -1
    QUEBRA_LINHA = 0
    NUMERO = 1
    IDENT = 2
    STRING = 3
    #PALAVRAS RESERVADAS (ENTRE 100 E 200)
    a = 101
    b = 102
    c = 103
    d = 104
    e = 105
    #OPERADORES (>200)
    ATRIBUICAO = 201
    SOMA = 202
    SUBTRACAO = 203
    MULT = 204
    DIVISAO = 205
    MAIOR_QUE = 206
    MAIOR_IGUAL = 207