class NodeVisitor(object):
    def visit(self,node):
        #Se node é SumExpr, method_name é visit_SumExpr
        method_name = 'visit_'+ type(node).__name__
        visitor = getattr(self, method_name, self.generic_visit)
        return visitor(node)
    def generic_visit(self,node):
        raise Exception('Nenhum método visit_{}'.format(type(node).__name__))
    
class EvalVisitor(NodeVisitor):
    def __init__(self, ast, symbolTable): 
        self.ast = ast
        self.symbolTable = symbolTable
    def eval(self):
        return self.visit(self.ast)
    #node é um nó do tipo SumExpr
    def visit_SumExpr(self,node):
        return self.visit(node.esq) + self.visit(node.dir)
    def visit_MulExpr(self,node):
        return self.visit(node.esq) * self.visit(node.dir)
    def visit_SubExpr(self,node):
        return self.visit(node.esq) - self.visit(node.dir)
    def visit_DivExpr(self,node):
        return self.visit(node.esq) / self.visit(node.dir)
    def visit_NumExpr(self,node):
        return int(node.valor)
    def visit_IdExpr(self,node):
        return self.visit(self.symbolTable.lookup(node.nome))