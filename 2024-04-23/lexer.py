import enum

class Lexer: 
    def __init__(self, codigo) -> None:
        self.source = codigo + '\n'
        self.curChar = ''
        self.curPos = -1
        self.nextChar()
    def nextChar(self):
        self.curPos = self.curPos+1
        if self.curPos >= len(self.source):
            self.curChar = '\0'
        else:
            self.curChar = self.source[self.curPos]
    def peek(self):
        if self.curPos+1 >= len(self.source):
            return '\0'
        else:
            return self.source[self.curPos+1]
    def skipWhitespace(self): 
        while self.curChar==' ' or self.curChar=='\t' or self.curChar=='\r':
            self.nextChar()
    
    def getToken(self):
        self.skipWhitespace()
        token = None
        if self.curChar == '=':
            token = Token(self.curChar, TipoToken.ATRIBUICAO)
        elif self.curChar == '+':
            token = Token(self.curChar, TipoToken.SOMA)
        elif self.curChar == '-':
            token = Token(self.curChar, TipoToken.SUBTRACAO)
        elif self.curChar == '>':
            token = Token(self.curChar, TipoToken.MAIOR_QUE)
        elif self.curChar == '\n':
            token = Token('\n', TipoToken.QUEBRA_LINHA)
        elif self.curChar == '\0':
            token = Token('\0', TipoToken.EOF)
        elif self.curChar.isalpha():
            posicaoInicial = self.curPos
            while self.peek().isalnum():
                self.nextChar()
            lexema = self.source[posicaoInicial : self.curPos + 1]
            tipoToken = Token.checaPalavraReservada(lexema)
            if tipoToken is None:
                token = Token(lexema, TipoToken.IDENT)
            else:
                token = Token(lexema, tipoToken)
        elif self.curChar.isnumeric():
            posicaoInicial = self.curPos
            while self.peek().isnumeric():
                self.nextChar()
            numero = self.source[posicaoInicial : self.curPos + 1]
            token = Token(numero, TipoToken.NUMERO)
        else:
            raise(Exception("caractere não reconhecido: "+self.curChar))
        self.nextChar()
        return token



class Token:
    def __init__(self, lexema, tipo) -> None:
        self.lexema = lexema
        self.tipo = tipo
    #tratar palavra reservada
    @staticmethod
    def checaPalavraReservada(lexema):
        for tipo in TipoToken:
            if tipo.name == lexema and tipo.value>100 and tipo.value<200:
                return tipo
        return None

class TipoToken(enum.Enum):
    EOF = -1
    QUEBRA_LINHA = 0
    NUMERO = 1
    IDENT = 2
    STRING = 3
    #PALAVRAS RESERVADAS(100<n<200)
    PRINT = 101
    INPUT = 102
    LET = 103
    WHILE = 104
    REPEAT = 105
    ENDWHILE = 106
    IF = 107
    THEN = 108
    ENDIF = 109
    #ATRIBUICAO
    ATRIBUICAO = 200
    #OPERADORES (>200)
    SOMA = 201
    SUBTRACAO = 202
    MAIOR_QUE = 203
    