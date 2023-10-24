import sys
from lexer import *
from astnodes import *

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
        return self.program()

    # program ::= statement
    def program(self):
        stmts = []
        self.match(TokenType.PROGRAM)
        nomePrograma = self.tokenAtual.lexema
        self.match(TokenType.IDENTIFICADOR)
        self.match(TokenType.BEGIN)
        self.nl()
        while not self.checkToken(TokenType.ENDPROGRAM):
            stmts.append(self.statement())
        self.match(TokenType.ENDPROGRAM)
        self.nl()
        self.match(TokenType.EOF)
        return Program(nomePrograma, stmts)

    # statement ::= 
    #   PRINT expression nl |
    #   INPUT IDENTIFICADOR nl |
    #   DECL IDENTIFICADOR ":" (INT | BOOLEAN | STRING) nl |
    #   LET IDENTIFICADOR "=" expression nl |
    #   BLOCK IDENT BEGIN nl {statement} ENDBLOCK nl |
    #   WHILE expression REPEAT nl {statement} ENDWHILE nl |
    #   IF expression "THEN" nl {statement} ENDIF nl
    def statement(self):
        stm = None
        #   PRINT expression nl |
        if self.checkToken(TokenType.PRINT):
            self.match(TokenType.PRINT)
            e = self.expression()
            stm = PrintStmt(e)
        #   INPUT IDENTIFICADOR nl |
        elif self.checkToken(TokenType.INPUT):
            self.match(TokenType.INPUT)
            nome = self.tokenAtual.lexema
            self.match(TokenType.IDENTIFICADOR)
            stm = InputStmt(nome)
        #   LET IDENTIFICADOR "=" expression nl |
        elif self.checkToken(TokenType.DECL):
            self.match(TokenType.DECL)
            nome = self.tokenAtual.lexema
            self.match(TokenType.IDENTIFICADOR)
            self.match(TokenType.COLON)
            if self.checkToken(TokenType.INT) or self.checkToken(TokenType.BOOLEAN) or self.checkToken(TokenType.STRING):
                tipo = self.tokenAtual.lexema
                self.nextToken()
            else:
                self.abort('Esperava por um tipo válido dentre INT, BOOLEAN, ou STRING, recebeu ' + self.tokenAtual.lexema)
            stm = VarDeclStmt(nome,tipo)
        #   LET IDENTIFICADOR "=" expression nl |
        elif self.checkToken(TokenType.LET):
            self.match(TokenType.LET)
            nome = self.tokenAtual.lexema
            self.match(TokenType.IDENTIFICADOR)
            self.match(TokenType.EQ)
            e = self.expression()
            stm = LetStmt(nome,e)
        #   BLOCK IDENT BEGIN nl {statement} ENDBLOCK nl |
        elif self.checkToken(TokenType.BLOCK):
            self.match(TokenType.BLOCK)
            nome = self.tokenAtual.lexema
            self.match(TokenType.IDENTIFICADOR)
            self.match(TokenType.BEGIN)
            self.nl()
            body = []
            while not self.checkToken(TokenType.ENDBLOCK):
                body.append(self.statement())
            self.match(TokenType.ENDBLOCK)
            stm = BlockStmt(nome,body)
        #   WHILE expression REPEAT nl {statement} ENDWHILE nl |
        elif self.checkToken(TokenType.WHILE):
            self.match(TokenType.WHILE)
            cond = self.expression()
            self.match(TokenType.REPEAT)
            self.nl()
            body = []
            while not self.checkToken(TokenType.ENDWHILE):
                body.append(self.statement())
            self.match(TokenType.ENDWHILE)
            stm = WhileStmt(cond,body)
        #   IF expression "THEN" nl {statement} ENDIF nl
        elif self.checkToken(TokenType.IF):
            self.match(TokenType.IF)
            cond = self.expression()
            self.match(TokenType.THEN)
            self.nl()
            body = []
            while not self.checkToken(TokenType.ENDIF):
                body.append(self.statement())
            self.match(TokenType.ENDIF)
            stm = IfStmt(cond, body)
        else:
            self.abort("Problema com " + self.tokenAtual.lexema + " (" + self.tokenAtual.tipo.name + ")")
        self.nl()
        return stm

    def nl(self):
        self.match(TokenType.QUEBRA_LINHA)
        while self.checkToken(TokenType.QUEBRA_LINHA):
            self.match(TokenType.QUEBRA_LINHA)

    # expression ::== equality
    def expression(self):
        return self.equality()
    # equality ::== comparison ( ("==" | "!=" ) comparison)*
    def equality(self):
        e = self.comparison()
        while self.checkToken(TokenType.EQEQ) or  self.checkToken(TokenType.NOTEQ):
            if self.checkToken(TokenType.EQEQ):
                self.match(TokenType.EQEQ)
                tmp = self.comparison()
                e = EqualsExpr(e,tmp)
            elif self.checkToken(TokenType.NOTEQ):
                self.match(TokenType.NOTEQ)
                tmp = self.comparison()
                e = NotEqualsExpr(e,tmp)
        return e
    # comparison ::== term ( ("<" | "<=" | ">" | ">=" ) term)*
    def comparison(self):
        e = self.term()
        while self.checkToken(TokenType.LT) or self.checkToken(TokenType.LTEQ) or self.checkToken(TokenType.GT) or self.checkToken(TokenType.GTEQ):
            if self.checkToken(TokenType.LT):
                self.match(TokenType.LT)
                tmp = self.term()
                e = LessThanExpr(e,tmp)
            elif self.checkToken(TokenType.LTEQ):
                self.match(TokenType.LTEQ)
                tmp = self.term()
                e = LessThanEqualsExpr(e,tmp)
            elif self.checkToken(TokenType.GT):
                self.match(TokenType.GT)
                tmp = self.term()
                e = GreaterThanExpr(e,tmp)
            elif self.checkToken(TokenType.GTEQ):
                self.match(TokenType.GTEQ)
                tmp = self.term()
                e = GreaterThanEqualsExpr(e,tmp)
        return e

    # term ::== factor {("-" | "+") factor}
    def term(self):
        e = self.factor()
        while self.checkToken(TokenType.MINUS) or self.checkToken(TokenType.PLUS):
            if self.checkToken(TokenType.MINUS):
                self.match(TokenType.MINUS)
                tmp = self.factor()
                e = SubExpr(e,tmp)
            elif self.checkToken(TokenType.PLUS):
                self.match(TokenType.PLUS)
                tmp = self.factor()
                e = SumExpr(e,tmp)
        return e
    # factor ::== unary {("*" | "/") unary}
    def factor(self):
        e = self.unary()
        while self.checkToken(TokenType.ASTERISK) or self.checkToken(TokenType.SLASH):
            if self.checkToken(TokenType.ASTERISK):
                self.match(TokenType.ASTERISK)
                tmp = self.unary()
                e = MulExpr(e,tmp)
            elif self.checkToken(TokenType.SLASH):
                self.match(TokenType.SLASH)
                tmp = self.unary()
                e = DivExpr(e,tmp)
        return e
    # unary ::== ["-" | "+" ] unary | primary
    def unary(self):
        e = None
        if self.checkToken(TokenType.MINUS):
            self.match(TokenType.MINUS)
            e = UnaryMinusExpr(self.unary())
        elif self.checkToken(TokenType.PLUS):
            self.match(TokenType.PLUS)
            e = UnaryPlusExpr(self.unary())
        else:
            e = self.primary()
        return e 
    # primary ::== NUM | ID | STRING
    def primary(self):
        e = None
        if self.checkToken(TokenType.NUMERO):
            str_numero = self.tokenAtual.lexema
            val_numero = int(str_numero)
            e = NumExpr(val_numero)
            self.match(TokenType.NUMERO)
        elif self.checkToken(TokenType.IDENTIFICADOR):
            nome_var = self.tokenAtual.lexema
            e = IdExpr(nome_var)
            self.match(TokenType.IDENTIFICADOR)
        elif self.checkToken(TokenType.STRING_LITERAL):
            valor_string = self.tokenAtual.lexema
            e = StringExpr(valor_string)
            self.match(TokenType.STRING_LITERAL)
        else:
            self.abort("Token inesperado, esperava por NUMERO, IDENTIFICADOR, ou STRING_LITERAL, apareceu: " + self.tokenAtual.tipo.name + " (" + self.tokenAtual.lexema + ")")
        return e