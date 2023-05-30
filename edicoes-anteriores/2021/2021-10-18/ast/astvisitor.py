class NodeVisitor(object):
    def visit(self, node):
        method_name = 'visit_' + type(node).__name__
        visitor = getattr(self, method_name, self.generic_visit)
        return visitor(node)

    def generic_visit(self, node):
        raise Exception('No visit_{} method'.format(type(node).__name__))

class Eval(NodeVisitor):
    def __init__(self, tree):
        self.ast = tree
    def visit_SumExpr(self,node):
        return self.visit(node.ladoEsquerdo) + self.visit(node.ladoDireito)
    def visit_SubExpr(self,node):
        return self.visit(node.ladoEsquerdo) - self.visit(node.ladoDireito)
    def visit_MulExpr(self,node):
        return self.visit(node.ladoEsquerdo) * self.visit(node.ladoDireito)
    def visit_DivExpr(self,node):
        return self.visit(node.ladoEsquerdo) / self.visit(node.ladoDireito)
    def visit_NumExpr(self,node):
        return node.valor
    def eval(self):
        return self.visit(self.ast)

class PosFixa(NodeVisitor):
    def __init__(self, tree):
        self.ast = tree
    # 21 + 34 --> 21 34 +
    def visit_SumExpr(self,node):
        return self.visit(node.ladoEsquerdo) + self.visit(node.ladoDireito) + "+ "
    def visit_SubExpr(self,node):
        return self.visit(node.ladoEsquerdo) + self.visit(node.ladoDireito) + "- "
    def visit_MulExpr(self,node):
        return self.visit(node.ladoEsquerdo) + self.visit(node.ladoDireito) + "* "
    def visit_DivExpr(self,node):
        return self.visit(node.ladoEsquerdo) + self.visit(node.ladoDireito) + "/ "
    def visit_NumExpr(self,node):
        return str(node.valor) + " "
    def visit_IdExpr(self,node):
        return node.nome + " "
    def posFixa(self):
        return self.visit(self.ast)    

class ParenthesisPrint(NodeVisitor):
    def __init__(self, tree):
        self.ast = tree
    def visit_SumExpr(self,node):
        return "(" + self.visit(node.ladoEsquerdo) + ") + (" + self.visit(node.ladoDireito) + ")"
    def visit_SubExpr(self,node):
        return "(" + self.visit(node.ladoEsquerdo) + ") - (" + self.visit(node.ladoDireito) + ")"
    def visit_MulExpr(self,node):
        return "(" + self.visit(node.ladoEsquerdo) + ") * (" + self.visit(node.ladoDireito) + ")"
    def visit_DivExpr(self,node):
        return "(" + self.visit(node.ladoEsquerdo) + ") / (" + self.visit(node.ladoDireito) + ")"
    def visit_NumExpr(self,node):
        return str(node.valor)
    def visit_IdExpr(self,node):
        return node.nome
    def parenthesize(self):
        return self.visit(self.ast)    