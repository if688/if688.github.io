class Expr(object):
    pass

class NumExpr(Expr):
    def __init__(self, valor):
        self.valor = valor        
    def __str__(self):
        return f'NumExpr({self.valor})'

class IdExpr(Expr):
    def __init__(self, nome):
        self.nome = nome        
    def __str__(self):
        return f'IdExpr({self.nome})'
    
class SumExpr(Expr):
    def __init__(self, esq, dir):
        self.ladoEsq = esq
        self.ladoDir = dir
    def __repr__(self):
        return self.__str__()
    def __str__(self):
        return f'SumExpr({self.ladoEsq}, {self.ladoDir})'

class SubExpr(Expr):
    def __init__(self, esq, dir):
        self.ladoEsq = esq
        self.ladoDir = dir
    def __repr__(self):
        return self.__str__()
    def __str__(self):
        return f'SubExpr({self.ladoEsq}, {self.ladoDir})'

class MulExpr(Expr):
    def __init__(self, esq, dir):
        self.ladoEsq = esq
        self.ladoDir = dir
    def __repr__(self):
        return self.__str__()
    def __str__(self):
        return f'MulExpr({self.ladoEsq}, {self.ladoDir})'

class DivExpr(Expr):
    def __init__(self, esq, dir):
        self.ladoEsq = esq
        self.ladoDir = dir
    def __repr__(self):
        return self.__str__()
    def __str__(self):
        return f'DivExpr({self.ladoEsq}, {self.ladoDir})'
