class NodeVisitor(object):
    def visit(self,node):
        method_name = 'visit_'+type(node).__name__
        visitor = getattr(self, method_name, self.generic_visit)
        return visitor(node)
    def generic_visit(self, node):
        raise Exception('Não tem método visit_{}'.format(type(node).__name__))
    
class Eval(NodeVisitor):
    def __init__(self, tree):
         self.ast = tree
    def eval(self):
        return self.visit(self.ast)
    def visit_SumExpr(self,node):
        return self.visit(node.esq)+self.visit(node.dir)
    def visit_MulExpr(self,node):
        return self.visit(node.esq)*self.visit(node.dir)
    def visit_DivExpr(self,node):
        return self.visit(node.esq)/self.visit(node.dir)
    def visit_SubExpr(self,node):
        return self.visit(node.esq)-self.visit(node.dir)
    def visit_NumExpr(self,node):
        return node.valor
    def visit_IdExpr(self,node):
        raise Exception('tabelas de símbolos ainda não foram implementadas')
    
class PosFixa(NodeVisitor):
    def __init__(self, tree):
         self.ast = tree
    def posfixa(self):
        return self.visit(self.ast)
    def visit_SumExpr(self,node):
        return self.visit(node.esq) + self.visit(node.dir) + '+ '
    def visit_MulExpr(self,node):
        return self.visit(node.esq) + self.visit(node.dir) + '* '
    def visit_DivExpr(self,node):
        return self.visit(node.esq) + self.visit(node.dir) + '/ '
    def visit_SubExpr(self,node):
        return self.visit(node.esq) + self.visit(node.dir) + '- '
    def visit_NumExpr(self,node):
        return str(node.valor) + ' '
    def visit_IdExpr(self,node):
        return node.nome + ' '
    