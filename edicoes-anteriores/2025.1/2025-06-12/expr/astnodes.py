class Expr(object):
    pass

class NumExpr(Expr):
    def __init__(self, valor):
        self.valor = valor
    def __str__(self):
        return "NumExpr("+str(self.valor)+")"

class IdExpr(Expr):
    def __init__(self, nome):
        self.nome = nome
    def __str__(self):
        return "IdExpr("+str(self.nome)+")"

class SomaExpr(Expr):
    def __init__(self, esq, dir):
        self.ladoEsquerdo = esq
        self.ladoDireito = dir
    def __str__(self):
        return "SomaExpr("+str(self.ladoEsquerdo)+", "+str(self.ladoDireito)+")"

class MulExpr(Expr):
    def __init__(self, esq, dir):
        self.ladoEsquerdo = esq
        self.ladoDireito = dir
    def __str__(self):
        return "MulExpr("+str(self.ladoEsquerdo)+", "+str(self.ladoDireito)+")"

class SubExpr(Expr):
    def __init__(self, esq, dir):
        self.ladoEsquerdo = esq
        self.ladoDireito = dir
    def __str__(self):
        return "SubExpr("+str(self.ladoEsquerdo)+", "+str(self.ladoDireito)+")"

class DivExpr(Expr):
    def __init__(self, esq, dir):
        self.ladoEsquerdo = esq
        self.ladoDireito = dir
    def __str__(self):
        return "DivExpr("+str(self.ladoEsquerdo)+", "+str(self.ladoDireito)+")"

class ParentesesExpr(Expr):
    def __init__(self, expr):
        self.expr = expr
    def __str__(self):
        return "ParentesesExpr("+str(self.expr)+")"
 