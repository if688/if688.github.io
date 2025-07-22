class Program(object):
    def __init__(self,name,ls):
        self.name = name
        self.stmts = ls

class Stmt(object):
    pass

class PrintStmt(Stmt):
    def __init__(self, exp):
        self.exp = exp

class InputStmt(Stmt):
    def __init__(self, nome):
        self.id = nome

class VarDeclStmt(Stmt):
    def __init__(self, nome, t):
        self.id = nome
        self.type = t

class LetStmt(Stmt):
    def __init__(self, nome, e):
        self.id = nome
        self.exp = e

class BlockStmt(Stmt):
    def __init__(self, nome, corpo):
        self.name = nome
        self.body = corpo

class IfStmt(Stmt):
    def __init__(self, c, corpo):
        self.cond = c
        self.body = corpo

class WhileStmt(Stmt):
    def __init__(self, c, corpo):
        self.cond = c
        self.body = corpo

class Expr(object):
    pass

class IdExpr(Expr):
    def __init__(self, nome):
        self.id = nome

class StringExpr(Expr):
    def __init__(self, s):
        self.str = s

class ArithExpr(Expr):
    pass

class SumExpr(ArithExpr):
    def __init__(self, ladoEsquerdo, ladoDireito):
        self.left = ladoEsquerdo
        self.right = ladoDireito

class SubExpr(ArithExpr):
    def __init__(self, ladoEsquerdo, ladoDireito):
        self.left = ladoEsquerdo
        self.right = ladoDireito

class MulExpr(ArithExpr):
    def __init__(self, ladoEsquerdo, ladoDireito):
        self.left = ladoEsquerdo
        self.right = ladoDireito

class DivExpr(ArithExpr):
    def __init__(self, ladoEsquerdo, ladoDireito):
        self.left = ladoEsquerdo
        self.right = ladoDireito

class UnaryPlusExpr(ArithExpr):
    def __init__(self, e):
        self.exp = e

class UnaryMinusExpr(ArithExpr):
    def __init__(self, e):
        self.exp = e

class NumExpr(ArithExpr):
    def __init__(self, valor):
        self.v = valor

class BooleanExpr(Expr):
    pass

class EqualsExpr(BooleanExpr):# left == right
    def __init__(self, ladoEsquerdo, ladoDireito):
        self.left = ladoEsquerdo
        self.right = ladoDireito

class NotEqualsExpr(BooleanExpr):# left != right
    def __init__(self, ladoEsquerdo, ladoDireito):
        self.left = ladoEsquerdo
        self.right = ladoDireito

class GreaterThanEqualsExpr(BooleanExpr):# left >= right
    def __init__(self, ladoEsquerdo, ladoDireito):
        self.left = ladoEsquerdo
        self.right = ladoDireito

class GreaterThanExpr(BooleanExpr):# left > right
    def __init__(self, ladoEsquerdo, ladoDireito):
        self.left = ladoEsquerdo
        self.right = ladoDireito

class LessThanEqualsExpr(BooleanExpr):# left <= right
    def __init__(self, ladoEsquerdo, ladoDireito):
        self.left = ladoEsquerdo
        self.right = ladoDireito

class LessThanExpr(BooleanExpr):# left < right
    def __init__(self, ladoEsquerdo, ladoDireito):
        self.left = ladoEsquerdo
        self.right = ladoDireito