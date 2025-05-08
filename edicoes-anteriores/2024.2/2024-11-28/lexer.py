import enum
import sys

class Lexer:
    def __init__(self, input):
        self.source = input + '\n' #código-fonte (entrada)
        self.curChar = '' #caractere atual dentro do código-fonte
        self.curPos = -1
        self.nextChar()
        pass

    # Processa o proximo caractere
    def nextChar(self):
        self.curPos = self.curPos + 1
        if self.curPos >= len(self.source):
            self.curChar = '\0' #EOF
        else:
            self.curChar = self.source[self.curPos]

    # Retorna o caractere seguinte (ainda não lido).
    def peek(self):
        if self.curPos+1 >= len(self.source):
            return '\0'
        else: 
            return self.source[self.curPos+1]

    # Token inválido encontrado, método usado para imprimir mensagem de erro e encerrar.
    def abort(self, message):
        sys.exit("Erro léxico! " + message)
		
    # Pular espaço em branco, exceto novas linhas, que são usadas como separadores.
    def skipWhitespace(self):
        while self.curChar == ' ' or self.curChar == '\n' or self.curChar == '\t' or self.curChar == '\r':
            self.nextChar()
		
    # Pular comentários.
    def skipComment(self):
        if self.curChar=='#':
            while self.curChar != '\n':
                self.nextChar()

    # Return o próximo token.
    def getToken(self):
        self.skipWhitespace()
        self.skipComment()
        token = None
        if self.curChar == '+':
            token = Token(self.curChar, TokenType.PLUS)
        elif self.curChar == '-':
            token = Token(self.curChar, TokenType.MINUS)
        elif self.curChar == '*':
            token = Token(self.curChar, TokenType.ASTERISK)
        elif self.curChar == '/':
            token = Token(self.curChar, TokenType.SLASH)
        elif self.curChar == '(':
            token = Token(self.curChar, TokenType.L_PAREN)
        elif self.curChar == ')':
            token = Token(self.curChar, TokenType.R_PAREN)
        elif self.curChar == ';':
            token = Token(self.curChar, TokenType.SEMICOLON)
        elif self.curChar == '\0':
            token = Token(self.curChar, TokenType.EOF)
        #se for = EQ, se for == EQEQ
        elif self.curChar == '=':
            if self.peek() == '=':
                c = self.curChar
                self.nextChar()
                token = Token(c + self.curChar, TokenType.EQEQ)
            else: 
                token = Token(self.curChar, TokenType.EQ)
        elif self.curChar == '!':
            if self.peek() == '=':
                c = self.curChar
                self.nextChar()
                token = Token(c + self.curChar, TokenType.NOTEQ)
            else: 
                self.abort("Esperava o símbolo de = e recebeu "+self.peek())
        elif self.curChar == '>':
            if self.peek() == '=':
                c = self.curChar
                self.nextChar()
                token = Token(c + self.curChar, TokenType.GTEQ)
            else: 
                token = Token(self.curChar, TokenType.GT)
        elif self.curChar == '<':
            if self.peek() == '=':
                c = self.curChar
                self.nextChar()
                token = Token(c + self.curChar, TokenType.LTEQ)
            else: 
                token = Token(self.curChar, TokenType.LT)
        elif self.curChar == '\"':
            self.nextChar()
            startPos = self.curPos
            while self.curChar != '\"':
                if self.curChar == '\\' or self.curChar == '\t' or self.curChar == '\r'  or self.curChar == '%':
                    self.abort("Caractere ilegal dentro de uma string")
                self.nextChar()
            stringText = self.source[startPos : self.curPos]
            token = Token(stringText, TokenType.STRING)
        elif self.curChar.isdigit():
            startPos = self.curPos
            while self.peek().isdigit():
                self.nextChar()
            if self.peek() == '.': #decimais
                self.nextChar()
                if not self.peek().isdigit():
                    self.abort("Caractere ilegal dentro de um número: "+ self.peek())
                while self.peek().isdigit():
                    self.nextChar()
            number = self.source[startPos : self.curPos + 1]
            token = Token(number, TokenType.NUMBER)
        elif self.curChar.isalpha():
            startPos = self.curPos
            while self.peek().isalnum():
                self.nextChar()
            word = self.source[startPos : self.curPos + 1]
            keyword = Token.checkIfKeyword(word)
            if keyword == None:
                token = Token(word, TokenType.IDENT)
            else: 
                token = Token(word, keyword)
        else: 
            #Token desconhecido
            self.abort("Token desconhecido: "+self.curChar)
        
        self.nextChar()
        return token

class Token:
    def __init__(self, tokenText, tokenKind):
        self.text = tokenText #lexema, a instância específica encontrada
        self.kind = tokenKind # o tipo de token (TokenType) classificado
    
    @staticmethod
    def checkIfKeyword(word):
        for kind in TokenType:
            if kind.name == word.upper() and kind.value > 100 and kind.value < 200:
                return kind
        return None

class TokenType(enum.Enum):
    EOF = -1
    NUMBER = 1
    IDENT = 2
    STRING = 3
    SEMICOLON = 4
    L_PAREN = 5
    R_PAREN = 6
    #PALAVRAS RESERVADAS
    PRINT = 101
    TRUE = 102
    FALSE = 103
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


if __name__ == '__main__':
    if len(sys.argv) != 2:
        sys.exit("Erro: Precisamos de um arquivo como argumento.")
    with open(sys.argv[1], 'r') as inputFile:
        input = inputFile.read()
    lexer = Lexer(input)
    tokenAtual = lexer.getToken()
    while tokenAtual.tipo!=TipoToken.EOF:
        print(str(tokenAtual.tipo) + '\n')
        tokenAtual = lexer.getToken()