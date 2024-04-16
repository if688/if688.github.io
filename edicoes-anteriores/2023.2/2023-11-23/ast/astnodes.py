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
        return "IdExpr("+str(self.valor)+")"

class SumExpr(Expr):
    def __init__(self, e_esq, e_dir):
        self.esq = e_esq
        self.dir = e_dir
    def __str__(self):
        return "SumExpr("+str(self.esq)+","+str(self.dir)+")"

class SubExpr(Expr):
    def __init__(self, e_esq, e_dir):
        self.esq = e_esq
        self.dir = e_dir
    def __str__(self):
        return "SubExpr("+str(self.esq)+","+str(self.dir)+")"

class MulExpr(Expr):
    def __init__(self, e_esq, e_dir):
        self.esq = e_esq
        self.dir = e_dir
    def __str__(self):
        return "MulExpr("+str(self.esq)+","+str(self.dir)+")"

class DivExpr(Expr):
    def __init__(self, e_esq, e_dir):
        self.esq = e_esq
        self.dir = e_dir
    def __str__(self):
        return "DivExpr("+str(self.esq)+","+str(self.dir)+")"
