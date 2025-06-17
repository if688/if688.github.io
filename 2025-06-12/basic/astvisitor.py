class NodeVisitor(object):
    def visit(self, node):
        method_name = 'visit_' + type(node).__name__
        visitor = getattr(self, method_name, self.generic_visit)
        return visitor(node)

    def generic_visit(self, node):
        raise Exception('No visit_{} method'.format(type(node).__name__))

class GenericVisitor(NodeVisitor):
    def __init__(self, ast):
        self.ast = ast
    def traverse(self):
        self.visit(self.ast)
    def visit_Program(self,node):
        for stmt in node.stmts:
            self.visit(stmt)
    def visit_PrintStmt(self,node):
        self.visit(node.exp)
    def visit_InputStmt(self,node):
        pass
    def visit_LetStmt(self,node):
        self.visit(node.exp)
    def visit_IfStmt(self,node):
        self.visit(node.cond)
        for stm in node.body:
            self.visit(stm)
    def visit_WhileStmt(self,node):
        self.visit(node.cond)
        for stm in node.body:
            self.visit(stm)
    def visit_StringExpr(self,node):
        pass
    def visit_NumExpr(self,node):
        pass
    def visit_IdExpr(self,node):
        pass
    def visit_SumExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_SubExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_MulExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_DivExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_UnaryPlusExpr(self,node):
        self.visit(node.exp)
    def visit_UnaryMinusExpr(self,node):
        self.visit(node.exp)
    
    def visit_EqualsExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_NotEqualsExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_GreaterThanEqualsExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_GreaterThanExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_LessThanEqualsExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_LessThanExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)

class CountVars(GenericVisitor):
    def __init__(self, ast):
        self.ast = ast
        self.qtdeVars = 0
    def count(self):
        self.qtdeVars = 0
        self.visit(self.ast)
        return self.qtdeVars
    def visit_VarDeclStmt(self, node):
        self.qtdeVars += 1