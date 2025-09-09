from astnodes import *

class NodeVisitor(object):
    def visit(self, node):
        method_name = 'visit_' + type(node).__name__
        visitor = getattr(self, method_name, self.generic_visit)
        return visitor(node)

    def generic_visit(self, node):
        raise Exception('No visit_{} method'.format(type(node).__name__))

class EvalVisitor(NodeVisitor):
    def __init__(self, ast):
        self.ast = ast
    def eval(self):
        return self.visit(self.ast)
    def visit_ParentesesExpr(self, node):
        return self.visit(node.expr)
    def visit_SomaExpr(self, node):
        return self.visit(node.ladoEsquerdo) + self.visit(node.ladoDireito)
    def visit_SubExpr(self, node):
        return self.visit(node.ladoEsquerdo) - self.visit(node.ladoDireito)
    def visit_MulExpr(self, node):
        return self.visit(node.ladoEsquerdo) * self.visit(node.ladoDireito)
    def visit_DivExpr(self, node):
        if self.visit(node.ladoDireito) == 0:
            raise Exception('Não pode dividir por 0!')
        else:
            return self.visit(node.ladoEsquerdo) / self.visit(node.ladoDireito)
    def visit_NumExpr(self,node):
        return node.valor

class PosFixa(NodeVisitor):
    def __init__(self, ast):
        self.ast = ast
    def posFixa(self):
        return self.visit(self.ast)
    def visit_NumExpr(self, node):
        return str(node.valor) + ' '
    def visit_IdExpr(self, node):
        return node.nome + ' '
    def visit_SomaExpr(self,node):
        return self.visit(node.ladoEsquerdo) + self.visit(node.ladoDireito) + '+ '
    def visit_SubExpr(self,node):
        return self.visit(node.ladoEsquerdo) + self.visit(node.ladoDireito) + '- '
    def visit_MulExpr(self,node):
        return self.visit(node.ladoEsquerdo) + self.visit(node.ladoDireito) + '* '
    def visit_DivExpr(self,node):
        return self.visit(node.ladoEsquerdo) + self.visit(node.ladoDireito) + '/ '
    def visit_ParentesesExpr(self, node):
        return self.visit(node.expr)


if __name__== '__main__':    #2 3 +
    # 2 + 3
    expr = SomaExpr(NumExpr(2),IdExpr('x'))
    # # 2 + 3 * 4
    # expr = SomaExpr(NumExpr(2),MulExpr(NumExpr(3),NumExpr(4)))
    # # 2 + (32 / (2-2))
    # expr = SomaExpr(NumExpr(2),DivExpr(NumExpr(32),SubExpr(NumExpr(4),NumExpr(2))))
    # print(expr)
    visitor = EvalVisitor(expr)
    # valor = visitor.eval()
    valor = 0
    # print(valor)
    visitor = PosFixa(expr)
    posFixa = visitor.posFixa()
    print (str(expr) + ' == ' + posFixa + ' == ' + str(valor))