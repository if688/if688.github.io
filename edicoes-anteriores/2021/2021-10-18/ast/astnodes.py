#     S' ::= S$
#     S ::= (E;)*
#     E ::= T (("+"|"-") T)*
#     T ::= F (("*"|"/") F)* 
#     F ::= num | id | "(" E ")"

class Expr(object):
    pass

class SumExpr(Expr):
    def __init__(self, left, right):
        self.ladoEsquerdo = left
        self.ladoDireito = right
    def __str__(self):
        return "SumExpr("+str(self.ladoEsquerdo)+","+str(self.ladoDireito)+")"
    def eval(self):
        return self.ladoEsquerdo.eval() + self.ladoDireito.eval()

class SubExpr(Expr):
    def __init__(self, left, right):
        self.ladoEsquerdo = left
        self.ladoDireito = right
    def __str__(self):
        return "SubExpr("+str(self.ladoEsquerdo)+","+str(self.ladoDireito)+")"
    def eval(self):
        return self.ladoEsquerdo.eval() - self.ladoDireito.eval()

class MulExpr(Expr):
    def __init__(self, left, right):
        self.ladoEsquerdo = left
        self.ladoDireito = right
    def __str__(self):
        return "MulExpr("+str(self.ladoEsquerdo)+","+str(self.ladoDireito)+")"
    def eval(self):
        return self.ladoEsquerdo.eval() * self.ladoDireito.eval()

class DivExpr(Expr):
    def __init__(self, left, right):
        self.ladoEsquerdo = left
        self.ladoDireito = right
    def __str__(self):
        return "DivExpr("+str(self.ladoEsquerdo)+","+str(self.ladoDireito)+")"
    def eval(self):
        return self.ladoEsquerdo.eval() / self.ladoDireito.eval()

class NumExpr(Expr):
    def __init__(self, valor):
        self.valor = valor
    def __str__(self):
        return "Num("+str(self.valor)+")"
    def eval(self):
        return self.valor

class IdExpr(Expr):
    def __init__(self, nome):
        self.nome = nome
    def __str__(self):
        return "Id("+str(self.nome)+")"
    def eval(self):
        pass
