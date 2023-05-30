class NodeVisitor(object):
    def visit(self, node):
        method_name = 'visit_' + type(node).__name__
        visitor = getattr(self, method_name, self.generic_visit)
        return visitor(node)

    def generic_visit(self, node):
        raise Exception('No visit_{} method'.format(type(node).__name__))

class PythonGenVisitor(NodeVisitor):
    def __init__(self,tree):
        self.ast = tree
        self.nivelIndentacao = 0

    def generatePython(self):
        return self.visit(self.ast)
    
    def visit_Program(self,node):
        code = ""
        for stmt in node.stmts:
            code = code + self.visit(stmt)
        return code

    
    # Incluir um método def visit_NomeDoNoDaAST para cada Nó da AST
    def visit_LetStmt(self, node):
        #O Nó LetStmt
        return node.id + " = " + self.visit(node.exp) + "\n"
    
    def visit_VarDeclStmt(self,node):
        return ""

    def visit_PrintStmt(self,node):
        return "print(str("+self.visit(node.exp)+"))\n"

    def visit_InputStmt(self,node):
        return node.id + " = int(input())\n"
    
    def visit_BlockStmt(self,node):
        code = ""
        for stm in node.body: 
            code = code + self.visit(stm)
        return code

    def visit_WhileStmt(self,node):
        code = "while " + self.visit(node.cond) + ":\n"
        self.nivelIndentacao += 1
        for stm in node.body: 
            code = code + "".ljust(self.nivelIndentacao*2) + self.visit(stm)
        self.nivelIndentacao -= 1
        return code
    
    def visit_IfStmt(self,node):
        code = "if " + self.visit(node.cond) + ":\n"
        self.nivelIndentacao += 1
        for stm in node.body: 
            code = code + "".ljust(self.nivelIndentacao*2) + self.visit(stm)
        self.nivelIndentacao -= 1
        return code

    def visit_NumExpr(self, node):
        return str(node.v)
    
    def visit_IdExpr(self,node):
        return node.id
    
    def visit_StringExpr(self, node):
        return "\"" + node.str + "\""
    
    def visit_GreaterThanExpr(self,node):
        return self.visit(node.left) + " > " + self.visit(node.right)
    def visit_GreaterThanEqualsExpr(self,node):
        return self.visit(node.left) + " >= " + self.visit(node.right)
    def visit_LessThanExpr(self,node):
        return self.visit(node.left) + " < " + self.visit(node.right)
    def visit_LessThanEqualsExpr(self,node):
        return self.visit(node.left) + " <= " + self.visit(node.right)
    def visit_EqualsExpr(self,node):
        return self.visit(node.left) + " == " + self.visit(node.right)
    def visit_NotEqualsExpr(self,node):
        return self.visit(node.left) + " != " + self.visit(node.right)
    
    def UnaryPlusExpr(self,node):
        return "+" + self.visit(node.e)
    def UnaryMinusExpr(self,node):
        return "-" + self.visit(node.e)
    
    def visit_SumExpr(self,node):
        return self.visit(node.left) + " + " + self.visit(node.right)
    def visit_SubExpr(self,node):
        return self.visit(node.left) + " - " + self.visit(node.right)
    def visit_MulExpr(self,node):
        return self.visit(node.left) + " * " + self.visit(node.right)
    def visit_DivExpr(self,node):
        return self.visit(node.left) + " / " + self.visit(node.right)