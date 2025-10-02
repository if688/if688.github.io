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
        elif self.caractereAtual == 'a':
            token = Token(self.caractereAtual, TipoToken.a)
        elif self.caractereAtual == 'b':
            token = Token(self.caractereAtual, TipoToken.b)
        elif self.caractereAtual == 'c':
            token = Token(self.caractereAtual, TipoToken.c)
        elif self.caractereAtual == 'd':
            token = Token(self.caractereAtual, TipoToken.d)
        elif self.caractereAtual == 'e':
            token = Token(self.caractereAtual, TipoToken.e)
        elif self.caractereAtual == '+':
            token = Token(self.caractereAtual, TipoToken.SOMA)
        elif self.caractereAtual == '-':
            token = Token(self.caractereAtual, TipoToken.SUBTRACAO)
        elif self.caractereAtual.isdigit():
            token = Token(self.caractereAtual, TipoToken.DIGITO)
        else:
            self.abort("Caractere não reconhecido: "+self.caractereAtual)
        self.proximoCaractere()
        return token

class Token:
    def __init__(self, lexema, tipo) -> None:
        self.lexema = lexema
        self.tipo = tipo

class TipoToken(enum.Enum):
    EOF = -1
    a = 1
    b = 2
    c = 3
    d = 4
    e = 5
    SOMA = 6
    SUBTRACAO = 7
    DIGITO = 8

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