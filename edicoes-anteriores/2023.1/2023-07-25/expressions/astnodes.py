class Program(object):
    def __init__(self, decls, exps) -> None:
        super().__init__()
        self.declarations = decls
        self.expressions = exps

class Declaration(object):
    def __init__(self, nome, exp) -> None:
        super().__init__()
        self.nome = nome
        self.exp = exp
    def __str__(self): 
        return "Declaration("+str(self.nome)+","+str(self.exp)+")"
class Expr(object):
    pass

class SumExpr(Expr):
    def __init__(self, left, right) -> None:
        super().__init__()
        self.esq = left
        self.dir = right
    def __str__(self): 
        return "SumExpr("+str(self.esq)+","+str(self.dir)+")"
    # def eval(self):
    #     return self.esq.eval()+self.dir.eval()
    # def posFixa(self):
    #     return self.esq.posFixa() + " " + self.dir.posFixa() + " +" 
class SubExpr(Expr):
    def __init__(self, left, right) -> None:
        super().__init__()
        self.esq = left
        self.dir = right
    def __str__(self): 
        return "SubExpr("+str(self.esq)+","+str(self.dir)+")"
    # def eval(self):
    #     return self.esq.eval()-self.dir.eval()
    # def posFixa(self):
    #     return self.esq.posFixa() + " " + self.dir.posFixa() + " -" 
class MulExpr(Expr):
    def __init__(self, left, right) -> None:
        super().__init__()
        self.esq = left
        self.dir = right
    def __str__(self): 
        return "MulExpr("+str(self.esq)+","+str(self.dir)+")"
    # def eval(self):
    #     return self.esq.eval()*self.dir.eval()
    # def posFixa(self):
    #     return self.esq.posFixa() + " " + self.dir.posFixa() + " *" 
class DivExpr(Expr):
    def __init__(self, left, right) -> None:
        super().__init__()
        self.esq = left
        self.dir = right
    def __str__(self): 
        return "DivExpr("+str(self.esq)+","+str(self.dir)+")"
    # def eval(self):
    #     parteDeBaixo = self.dir.eval()
    #     if parteDeBaixo == 0:
    #         raise ValueError('Divisão por zero!')
    #     return self.esq.eval()/self.dir.eval()
    # def posFixa(self):
    #     return self.esq.posFixa() + " " + self.dir.posFixa() + " /" 
class NumExpr(Expr):
    def __init__(self, valor) -> None:
        super().__init__()
        self.valor = valor
    def __str__(self): 
        return "NumExpr("+str(self.valor)+")"
    # def eval(self):
    #     return self.valor
    # def posFixa(self):
    #     return str(self.valor) 
    
class IdExpr(Expr):
    def __init__(self, nome) -> None:
        super().__init__()
        self.nome = nome
    def __str__(self): 
        return "IdExpr("+str(self.nome)+")"
    # def posFixa(self):
    #     return str(self.nome) 
    