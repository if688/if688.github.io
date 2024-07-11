import enum
import sys

class Lexer:
    def __init__(self, input):
        self.codigoFonte = input + '\n'
        self.caractereAtual = ''
        self.posicaoAtual = -1
        self.nextChar()

    # Processa o proximo caractere
    def nextChar(self):
        self.posicaoAtual += 1
        if self.posicaoAtual >= len(self.codigoFonte): 
            self.caractereAtual = '\0' #EOF
        else:
            self.caractereAtual = self.codigoFonte[self.posicaoAtual]

    # Retorna o caractere seguinte (ainda não lido).
    def peek(self):
        if self.posicaoAtual + 1 >= len(self.codigoFonte):
            return '\0'
        return self.codigoFonte[self.posicaoAtual+1]

    # Token inválido encontrado, método usado para imprimir mensagem de erro e encerrar.
    def abort(self, message):
        sys.exit("Erro léxico! "+message)
		
    # Pular espaço em branco, exceto novas linhas, que são usadas como separadores.
    def skipWhitespace(self):
        while self.caractereAtual == ' ' or self.caractereAtual == '\t' or self.caractereAtual == '\r':
            self.nextChar()
		
    # Pular comentários.
    def skipComment(self):
        pass

    # Return o próximo token.
    def getToken(self):
        self.skipWhitespace()
        token = None

        # Olha para o caractere atual e vê se dá pra decidir qual o token
        if self.caractereAtual == '+':
            token = Token(self.caractereAtual, TokenType.PLUS) #RETORNAR SIMBOLO DE ADICAO
        elif self.caractereAtual == '-':
            token = Token(self.caractereAtual, TokenType.MINUS) #RETORNAR SIMBOLO DE SUBTRACAO
        elif self.caractereAtual == '*':
            token = Token(self.caractereAtual, TokenType.ASTERISK) #RETORNAR SIMBOLO DE MULTIPLICACAO
        elif self.caractereAtual == '/':
            token = Token(self.caractereAtual, TokenType.SLASH) #RETORNAR SIMBOLO DE DIVISAO
        elif self.caractereAtual == '\n':
            token = Token(self.caractereAtual, TokenType.QUEBRA_LINHA) #RETORNAR SIMBOLO DE QUEBRA DE LINHA
        elif self.caractereAtual == '\0':
            token = Token(self.caractereAtual, TokenType.EOF) #RETORNAR EOF
        elif self.caractereAtual == '=': 
            if self.peek() == '=':
                c = self.caractereAtual
                self.nextChar()
                token = Token(c + self.caractereAtual, TokenType.EQEQ) # RETORNAR Token '=='
            else: 
                token = Token(self.caractereAtual, TokenType.EQ) # RETORNAR Token '='
        elif self.caractereAtual == '>': 
            if self.peek() == '=':
                c = self.caractereAtual
                self.nextChar()
                token = Token(c + self.caractereAtual, TokenType.GTEQ) # RETORNAR Token '>='
            else: 
                token = Token(self.caractereAtual, TokenType.GT) # RETORNAR Token '>'
        elif self.caractereAtual == '<': 
            if self.peek() == '=':
                c = self.caractereAtual
                self.nextChar()
                token = Token(c + self.caractereAtual, TokenType.LTEQ) # RETORNAR Token '<='
            else: 
                token = Token(self.caractereAtual, TokenType.LT) # RETORNAR Token '<'
        elif self.caractereAtual == '!': 
            if self.peek() == '=':
                c = self.caractereAtual
                self.nextChar()
                token = Token(c + self.caractereAtual, TokenType.NOTEQ) # RETORNAR Token '!='
            else: 
                self.abort("Esperava !=, recebeu !"+self.peek())
        elif self.caractereAtual == '\"':
            self.nextChar()
            posicaoInicial = self.posicaoAtual
            while self.caractereAtual != '\"':
                if self.caractereAtual == '\r' or self.caractereAtual == '\n' or self.caractereAtual == '\t' or self.caractereAtual == '\\' or self.caractereAtual == '%':
                    self.abort("Caractere ilegal dentro da string: " + self.caractereAtual)
                self.nextChar()
            textoString = self.codigoFonte[posicaoInicial : self.posicaoAtual]
            token = Token(textoString, TokenType.STRING_LITERAL)
        elif self.caractereAtual.isdigit():
            posicaoInicial = self.posicaoAtual
            while self.peek().isdigit(): 
                self.nextChar()
            if self.peek() == '.':
                self.nextChar()
                if not self.peek().isdigit():
                    self.abort("Caractere ilegal dentro de um número: "+self.peek())
                while self.peek().isdigit():
                    self.nextChar()

            textoNumero = self.codigoFonte[posicaoInicial : self.posicaoAtual + 1]
            token = Token(textoNumero, TokenType.NUMERO)
        elif self.caractereAtual.isalpha(): 
            posicaoInicial = self.posicaoAtual
            while self.peek().isalnum(): 
                self.nextChar()
            
            textoToken = self.codigoFonte[posicaoInicial : self.posicaoAtual + 1]
            tipoToken = Token.checkIfKeyword(textoToken)
            if tipoToken == None:
                token = Token(textoToken, TokenType.IDENTIFICADOR)
            else: 
                token = Token(textoToken, tipoToken)
            
        else:
            self.abort("Token desconhecido iniciado com o caractere: " + self.caractereAtual)
        
        self.nextChar()
        return token

class Token:
    def __init__(self, lexema, tipo):#Token(23,NUMBER)
        self.lexema = lexema
        self.tipo = tipo
    
    @staticmethod
    def checkIfKeyword(lexema):
        for kind in TokenType:
            if kind.name == lexema and kind.value >= 100 and kind.value <200:
                return kind
        return None

class TokenType(enum.Enum):
    EOF = -1
    QUEBRA_LINHA = 0
    NUMERO = 1
    IDENTIFICADOR = 2
    STRING_LITERAL = 3
    #PALAVRAS RESERVADAS
    LABEL = 101
    GOTO = 102
    PRINT = 103
    INPUT = 104
    LET = 105
    IF = 106
    THEN = 107
    ENDIF = 108
    WHILE = 109
    REPEAT = 110
    ENDWHILE = 111
    #OPERADORES
    EQ = 201  
    PLUS = 202
    MINUS = 203
    ASTERISK = 204
    SLASH = 205
    EQEQ = 206
    NOTEQ = 207
    LT = 208
    LTEQ = 209
    GT = 210
    GTEQ = 211