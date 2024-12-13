class NodeVisitor(object):
    def visit(self, node):
        method_name = 'visit_' + type(node).__name__
        visitor = getattr(self, method_name, self.generic_visit)
        return visitor(node)

    def generic_visit(self, node):
        raise Exception('No visit_{} method'.format(type(node).__name__))

class PrettyPrint(NodeVisitor):
    def __init__(self, ast):
        self.ast = ast
    def prettyPrint(self):
        return self.visit(self.ast)
    def visit_SumExpr(self, node):
        return self.visit(node.esq) + ' + ' + self.visit(node.dir)
    def visit_MulExpr(self, node):
        return self.visit(node.esq) + ' * ' + self.visit(node.dir)
    def visit_NumExpr(self,node):
        return str(node.valor)
        
class PosFixa(NodeVisitor):
    def __init__(self, ast):
        self.ast = ast
    def posFixa(self):
        return self.visit(self.ast)
    def visit_SumExpr(self, node):
        return self.visit(node.esq) + self.visit(node.dir) + ' + '
    def visit_MulExpr(self, node):
        return self.visit(node.esq) + self.visit(node.dir) + ' * '
    def visit_NumExpr(self,node):
        return str(node.valor)+' '
        
class Eval(NodeVisitor):
    def __init__(self, ast):
        self.ast = ast
    def eval(self):
        return self.visit(self.ast)
    def visit_SumExpr(self, node):
        return self.visit(node.esq) + self.visit(node.dir)
    def visit_MulExpr(self, node):
        return self.visit(node.esq) * self.visit(node.dir)
    def visit_NumExpr(self,node):
        return node.valor





