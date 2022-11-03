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

    def count(self):
        self.numVars = 0
        super().traverse()
        return self.numVars
    
    def visit_VarDeclStmt(self,node):
        self.numVars+=1

class CountPrint(GenericVisitor):
    def __init__(self, tree):
        super().__init__(tree)
        self.numPrint = 0

    def count(self):
        self.numPrint = 0
        super().traverse()
        return self.numPrint
    
    def visit_PrintStmt(self, node):
        self.numPrint+=1

#Ignora escopo de blocos por enquanto
class BuildSymbolTableVisitor(GenericVisitor):
    def __init__(self, tree):
        super().__init__(tree)
        self.symbolTable = SymbolTable()
    
    def build(self):
        self.traverse()
        return self.symbolTable
    
    def visit_VarDeclStmt(self, node):
        nome = node.id
        if self.symbolTable.lookup(nome) is None:
            #var não declarada
            tipo = self.symbolTable.lookup(node.type)
            simbolo = VarSymbol(nome,tipo)
            self.symbolTable.insert(nome,simbolo)
        else:
            #var já declarada
            self.erro("Variável já foi declarada antes: %s" % nome)
        
class TypeCheckVisitor(GenericVisitor):
    def __init__(self, tree):
        super().__init__(tree)
        visitor = BuildSymbolTableVisitor(tree)
        self.symbolTable = visitor.build()

    def typecheck(self):
        self.traverse()
    
    def BOOLEAN(self):
        return self.symbolTable.lookup('BOOLEAN')
    def INT(self):
        return self.symbolTable.lookup('INT')
    def STRING(self):
        return self.symbolTable.lookup('STRING')

    def visit_InputStmt(self, node):
        if self.symbolTable.lookup(node.id) is None:
            self.erro("Variável não declarada: %s" % node.id)
    def visit_LetStmt(self, node):
        nome_var = node.id
        sym_var = self.symbolTable.lookup(nome_var)
        if sym_var is None:
            self.erro("Variável não declarada: %s" % nome_var)
        else:
            tipo_var = sym_var.type
            tipo_exp = self.visit(node.exp)
            if tipo_var.name != tipo_exp.name:
                self.erro('Variável ' + nome_var + ' espera por valor de tipo ' + str(tipo_var) + ', mas recebeu valor de tipo ' + str(tipo_exp))

    def visit_WhileStmt(self, node):
        tipo_condicao = self.visit(node.cond)
        if tipo_condicao == self.BOOLEAN():
            for stm in node.body:
                self.visit(stm)
        else:
            self.erro('Condição do WHILE deveria ser BOOLEAN, ao invés de ' + str(tipo_condicao))

    def visit_IfStmt(self, node):
        tipo_condicao = self.visit(node.cond)
        if tipo_condicao == self.BOOLEAN():
            for stm in node.body:
                self.visit(stm)
        else:
            self.erro('Condição do IF deveria ser BOOLEAN, ao invés de ' + str(tipo_condicao))

    def visit_NumExpr(self, node):
        return self.INT()
    def visit_StringExpr(self, node):
        return self.STRING()
    def visit_IdExpr(self, node):
        symbol = self.symbolTable.lookup(node.id)
        if symbol is None:
            self.erro("Variável não declarada: %s" % node.id)
        else: 
            return symbol.type

    def visit_SumExpr(self, node):
        left_type = self.visit(node.left)
        right_type = self.visit(node.right)
        if left_type == self.INT() and right_type == self.INT():
            return self.INT()
        else:
            self.erro('Operação aritmética deveria envolver apenas inteiros, ao invés de ' + str(left_type) + ' & ' + str(right_type))
    def visit_SubExpr(self, node):
        left_type = self.visit(node.left)
        right_type = self.visit(node.right)
        if left_type == self.INT() and right_type == self.INT():
            return self.INT()
        else:
            self.erro('Operação aritmética deveria envolver apenas inteiros, ao invés de ' + str(left_type) + ' & ' + str(right_type))
    def visit_DivExpr(self, node):
        left_type = self.visit(node.left)
        right_type = self.visit(node.right)
        if left_type == self.INT() and right_type == self.INT():
            return self.INT()
        else:
            self.erro('Operação aritmética deveria envolver apenas inteiros, ao invés de ' + str(left_type) + ' & ' + str(right_type))
    def visit_MulExpr(self, node):
        left_type = self.visit(node.left)
        right_type = self.visit(node.right)
        if left_type == self.INT() and right_type == self.INT():
            return self.INT()
        else:
            self.erro('Operação aritmética deveria envolver apenas inteiros, ao invés de ' + str(left_type) + ' & ' + str(right_type))
    
    def visit_GreaterThanExpr(self, node):
        left_type = self.visit(node.left)
        right_type = self.visit(node.right)
        if left_type == right_type:
            return self.BOOLEAN()
        else: 
            self.erro('Operação relacional deveria envolver apenas elementos do mesmo tipo, ao invés de ' + str(left_type) + ' & ' + str(right_type))
    def visit_GreaterThanEqualsExpr(self, node):
        left_type = self.visit(node.left)
        right_type = self.visit(node.right)
        if left_type == right_type:
            return self.BOOLEAN()
        else: 
            self.erro('Operação relacional deveria envolver apenas elementos do mesmo tipo, ao invés de ' + str(left_type) + ' & ' + str(right_type))
    def visit_LessThanEqualsExpr(self, node):
        left_type = self.visit(node.left)
        right_type = self.visit(node.right)
        if left_type == right_type:
            return self.BOOLEAN()
        else: 
            self.erro('Operação relacional deveria envolver apenas elementos do mesmo tipo, ao invés de ' + str(left_type) + ' & ' + str(right_type))
    def visit_LessThanExpr(self, node):
        left_type = self.visit(node.left)
        right_type = self.visit(node.right)
        if left_type == right_type:
            return self.BOOLEAN()
        else: 
            self.erro('Operação relacional deveria envolver apenas elementos do mesmo tipo, ao invés de ' + str(left_type) + ' & ' + str(right_type))
    def visit_EqualsExpr(self, node):
        left_type = self.visit(node.left)
        right_type = self.visit(node.right)
        if left_type == right_type:
            return self.BOOLEAN()
        else: 
            self.erro('Operação relacional deveria envolver apenas elementos do mesmo tipo, ao invés de ' + str(left_type) + ' & ' + str(right_type))
    def visit_NotEqualsExpr(self, node):
        left_type = self.visit(node.left)
        right_type = self.visit(node.right)
        if left_type == right_type:
            return self.BOOLEAN()
        else: 
            self.erro('Operação relacional deveria envolver apenas elementos do mesmo tipo, ao invés de ' + str(left_type) + ' & ' + str(right_type))
    
class Interpreter(GenericVisitor):
    def __init__(self, tree):
        super().__init__(tree)
        typechecker = TypeCheckVisitor(tree)
        typechecker.typecheck()
        self.symbolTable = typechecker.symbolTable
    
    def interpret(self):
        self.traverse()
    
    def visit_PrintStmt(self, node):
        print(self.visit(node.exp))
    
    def visit_InputStmt(self, node):
        nome = node.id
        tipo = self.symbolTable.lookup(nome).type
        entrada_usuario = input()
        if tipo.name == 'INT':
            valor = int(entrada_usuario)
        elif tipo.name == 'BOOLEAN':
            true_values = ['True', 'true', 'T', 't', 'TRUE']
            false_values = ['False', 'false', 'F', 'f', 'FALSE']
            if entrada_usuario in true_values:
                valor = True
            elif entrada_usuario in false_values:
                valor = False
            else: 
                self.erro('Digite um valor booleano válido.')
        else: 
            valor = str(entrada_usuario)
        symbol = VarSymbol(nome,tipo,valor)
        self.symbolTable.update(nome,symbol)
    
    def visit_LetStmt(self, node):
        nome = node.id
        tipo = self.symbolTable.lookup(nome).type
        valor = self.visit(node.exp)
        symbol = VarSymbol(nome,tipo,valor)
        self.symbolTable.update(nome,symbol)
    
    def visit_WhileStmt(self, node):
        while self.visit(node.cond):
            for stm in node.body:
                self.visit(stm)

    def visit_IfStmt(self, node):
        if self.visit(node.cond):
            for stm in node.body:
                self.visit(stm)

    def visit_NumExpr(self,node):
        return node.v
    def visit_StringExpr(self, node):
        return node.str
    def visit_IdExpr(self,node):
        return self.symbolTable.lookup(node.id).value
    
    def visit_UnaryMinusExpr(self, node):
        return -(self.visit(node.exp))
    def visit_UnaryPlusExpr(self, node):
        return +(self.visit(node.exp))

    def visit_SumExpr(self, node):
        return self.visit(node.left) + self.visit(node.right)
    def visit_SubExpr(self, node):
        return self.visit(node.left) - self.visit(node.right)
    def visit_DivExpr(self, node):
        return self.visit(node.left) / self.visit(node.right)
    def visit_MulExpr(self, node):
        return self.visit(node.left) * self.visit(node.right)
    
    def visit_GreaterThanExpr(self, node):
        return self.visit(node.left) > self.visit(node.right)
    def visit_GreaterThanEqualsExpr(self, node):
        return self.visit(node.left) >= self.visit(node.right)
    def visit_LessThanEqualsExpr(self, node):
        return self.visit(node.left) <= self.visit(node.right)
    def visit_LessThanExpr(self, node):
        return self.visit(node.left) < self.visit(node.right)
    def visit_EqualsExpr(self, node):
        return self.visit(node.left) == self.visit(node.right)
    def visit_NotEqualsExpr(self, node):
        return self.visit(node.left) != self.visit(node.right)
    