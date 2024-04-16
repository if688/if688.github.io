import sys
from lex import *

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
        self.program()
        self.match(TokenType.EOF)

    # program ::= statement
    def program(self):
        while not self.checkToken(TokenType.EOF):
            self.statement()

    # statement ::= 
    #   PRINT expression nl |
    #   INPUT IDENTIFICADOR nl |
    #   LET IDENTIFICADOR "=" expression nl |
    #   WHILE expression REPEAT nl {statement} ENDWHILE nl |
    #   IF expression "THEN" nl {statement} ENDIF nl
    def statement(self):
        #   PRINT expression nl |
        if self.checkToken(TokenType.PRINT):
            self.match(TokenType.PRINT)
            self.expression()
        #   INPUT IDENTIFICADOR nl |
        elif self.checkToken(TokenType.INPUT):
            self.match(TokenType.INPUT)
            self.match(TokenType.IDENTIFICADOR)
        #   LET IDENTIFICADOR "=" expression nl |
        elif self.checkToken(TokenType.LET):
            self.match(TokenType.LET)
            self.match(TokenType.IDENTIFICADOR)
            self.match(TokenType.EQ)
            self.expression()
            
        #   WHILE expression REPEAT nl {statement} ENDWHILE nl |
        
        #   IF expression "THEN" nl {statement} ENDIF nl
        
        self.nl()

    def nl(self):
        self.match(TokenType.QUEBRA_LINHA)

    # expression ::== equality
    def expression(self):
        self.equality()

    # equality ::== comparison ( ("==" | "!=" ) comparison)*
    def equality(self):
        self.comparison()

    # comparison ::== term ( ("<" | "<=" | ">" | ">=" ) term)*
    def comparison(self):
        self.term()

    # term ::== factor {("-" | "+") factor}
    def term(self):
        self.factor()

    # factor ::== unary {("*" | "/") unary}
    def factor(self):
        self.unary()

    # unary ::== ["-" | "+" ] unary | primary
    def unary(self):
        self.primary()

    # primary ::== NUM | ID | STRING
    def primary(self):
        if self.checkToken(TokenType.NUMERO):
            self.match(TokenType.NUMERO)
        elif self.checkToken(TokenType.IDENTIFICADOR):
            self.match(TokenType.IDENTIFICADOR)
        elif self.checkToken(TokenType.STRING_LITERAL):
            self.match(TokenType.STRING_LITERAL)
        else:
            self.erro("Token inesperado")