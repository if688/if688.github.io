from symboltable import *

class NodeVisitor(object):
    def visit(self, node):
        method_name = 'visit_' + type(node).__name__
        visitor = getattr(self, method_name, self.generic_visit)
        return visitor(node)

    def generic_visit(self, node):
        raise Exception('No visit_{} method'.format(type(node).__name__))

class GenericVisitor(NodeVisitor):
    def __init__(self,tree):
        self.ast = tree

    def traverse(self):
        self.visit(self.ast)
    def erro(self,msg):
        raise Exception(msg)

    def visit_Program(self,node):
        for stmt in node.stmts:
            self.visit(stmt)
    def visit_LetStmt(self, node):
        self.visit(node.exp)
    def visit_VarDeclStmt(self,node):
        pass
    def visit_PrintStmt(self,node):
        self.visit(node.exp)
    def visit_InputStmt(self,node):
        pass
    def visit_BlockStmt(self,node):
        for stm in node.body: 
            self.visit(stm)
    def visit_WhileStmt(self,node):
        self.visit(node.cond)
        for stm in node.body: 
            self.visit(stm)
    def visit_IfStmt(self,node):
        self.visit(node.cond)
        for stm in node.body: 
            self.visit(stm)

    def visit_NumExpr(self, node):
        pass
    def visit_IdExpr(self,node):
        pass
    def visit_StringExpr(self, node):
        pass    
    def visit_GreaterThanExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_GreaterThanEqualsExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_LessThanExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_LessThanEqualsExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_EqualsExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_NotEqualsExpr(self,node):
        self.visit(node.left)
        self.visit(node.right)
    def visit_UnaryPlusExpr(self,node):
        self.visit(node.exp)
    def visit_UnaryMinusExpr(self,node):
        self.visit(node.exp)    
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

class CountVars(GenericVisitor):
    def __init__(self, tree):
        super().__init__(tree)
        self.numVars = 0
    
    def visit_VarDeclStmt(self, node):
        self.numVars += 1

class CountPrint(GenericVisitor):
    def __init__(self, tree):
        super().__init__(tree)
        self.numPrint = 0
    
    def contar(self):
        self.numPrint = 0
        super().traverse()
        return self.numPrint
    
    def visit_PrintStmt(self, node):
        self.numPrint += 1


class PrintAST(GenericVisitor):
    def __init__(self, tree):
        super().__init__(tree)
        self.result = ''

    def printAST(self):
        super().traverse()
        return self.result

#Program(simples, [PrintStmt(StringExpr("Hello World"))PrintStmt(StringExpr("Outro hello"))])    
    def visit_Program(self, node):
        self.result = 'Program("'+node.name+'", ['
        for stmt in node.stmts:
            self.result += self.visit(stmt)+','
        self.result = self.result[:-1]
        self.result += '])'
    
    def visit_PrintStmt(self, node):
        return 'PrintStmt('+self.visit(node.exp)+')'
    
    def visit_StringExpr(self, node):
        return 'StringExpr("'+node.str+'")'
    

class BuildSymbolTable(GenericVisitor):
    def __init__(self, tree):
        super().__init__(tree)
        self.symbolTable = SymbolTable()
    
    def build(self): 
        self.traverse()
        return self.symbolTable
    
    def visit_VarDeclStmt(self, node):
        nomeVariavel = node.id
        if self.symbolTable.lookup(nomeVariavel) is None:
            tipoVariavel = self.symbolTable.lookup(node.type)
            simbolo = VarSymbol(nomeVariavel,tipoVariavel)
            self.symbolTable.insert(nomeVariavel, simbolo)
        else:
            self.erro('Variável já foi declarada!')

class TypeCheckVisitor(GenericVisitor): 
    def __init__(self, tree):
        super().__init__(tree)
        visitor = BuildSymbolTable(tree)
        self.symbolTable = visitor.build()
    
    def typecheck(self):
        self.traverse()
        return True
    
    def BOOLEAN(self):
        return self.symbolTable.lookup('BOOLEAN')
    def INT(self):
        return self.symbolTable.lookup('INT')
    def STRING(self):
        return self.symbolTable.lookup('STRING')
    
    def visit_InputStmt(self, node):
        if self.symbolTable.lookup(node.id) is None:
            self.erro('Variável não foi declarada: %s' % node.id)
    def visit_StringExpr(self, node):
        return self.STRING()
    def visit_NumExpr(self, node):
        return self.INT()
    def visit_IdExpr(self, node):
        simbolo = self.symbolTable.lookup(node.id)
        if simbolo is None:
            self.erro('Variável não foi declarada: %s' % node.id)
        else: 
            return simbolo.type
    def visit_GreaterThanExpr(self, node):
        tipoEsq = self.visit(node.left)
        tipoDir = self.visit(node.right)
        if tipoEsq == tipoDir:
            return self.BOOLEAN()
        else:
            self.erro('Tipos não são comparáveis: '+str(tipoEsq) + ' e '+str(tipoDir))

    def visit_LetStmt(self, node):
        nomeVariavel = node.id
        expressao = node.exp
        simbolo = self.symbolTable.lookup(nomeVariavel)
        if simbolo is None:
            self.erro('Variável não foi declarada: %s' % node.id)
        else:
            tipoVariavel = simbolo.type
            tipoExpressao = self.visit(expressao)
            if tipoVariavel != tipoExpressao:
              self.erro('Tipos não são compatíveis: '+str(tipoVariavel) + ' e '+str(tipoExpressao))
