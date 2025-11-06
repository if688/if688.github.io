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

class BuildSymbolTable(GenericVisitor):
    def __init__(self, tree):
        super().__init__(tree)
        self.symbolTable = SymbolTable()
    
    def buildTable(self):
        self.traverse()
        return self.symbolTable
    
    def visit_VarDeclStmt(self, node):
        nomeVariavel = node.id
        if self.symbolTable.lookup(nomeVariavel) is None:
            tipoVariavel = self.symbolTable.lookup(node.type)
            simbolo = VarSymbol(nomeVariavel, tipoVariavel)
            self.symbolTable.insert(nomeVariavel, simbolo)
        else:
            self.erro('Variável ' + nomeVariavel + ' já foi declarada.')

class TypeCheckVisitor(GenericVisitor):
    def __init__(self, tree):
        super().__init__(tree)
        visitor = BuildSymbolTable(tree)
        self.symbolTable = visitor.buildTable()

    def typecheck(self):
        self.traverse()
        return True
    
    def INT(self):
        return self.symbolTable.lookup('INT')
    def BOOLEAN(self):
        return self.symbolTable.lookup('BOOLEAN')
    def STRING(self):
        return self.symbolTable.lookup('STRING')
    
    def visit_StringExpr(self, node):
        return self.STRING()
    def visit_NumExpr(self, node):
        return self.INT()
    def visit_IdExpr(self,node):
        nomeVariavel = node.id
        simbolo = self.symbolTable.lookup(nomeVariavel)
        if simbolo is None: 
            self.erro('variável %s não foi declarada' % nomeVariavel)
        else:
            return simbolo.type
    
    def visit_GreaterThanExpr(self, node):
        tipoLadoEsquerdo = self.visit(node.left)
        tipoLadoDireito = self.visit(node.right)
        if tipoLadoEsquerdo == tipoLadoDireito: 
            return self.BOOLEAN()
        else:
            self.erro('Tipos incompatíveis: ' + str(tipoLadoEsquerdo) + ' e ' + str(tipoLadoDireito))

    def visit_SumExpr(self, node):
        tipoLadoEsquerdo = self.visit(node.left)
        tipoLadoDireito = self.visit(node.right)
        if tipoLadoEsquerdo == tipoLadoDireito: 
            return self.INT()
        else:
            self.erro('Tipos incompatíveis: ' + str(tipoLadoEsquerdo) + ' e ' + str(tipoLadoDireito))

    def visit_InputStmt(self, node):
        nomeVariavel = node.id
        if self.symbolTable.lookup(nomeVariavel) is None:
            self.erro('variável %s não foi declarada' % nomeVariavel)
        
    def visit_IfStmt(self, node):
        condicao = node.cond
        tipoCondicao = self.visit(condicao)
        if tipoCondicao == self.BOOLEAN():
            for stm in node.body:
                self.visit(stm)
        else:
            self.erro('Condição do IF deve ser booleano')

    def visit_WhileStmt(self, node):
        condicao = node.cond
        tipoCondicao = self.visit(condicao)
        if tipoCondicao == self.BOOLEAN():
            for stm in node.body:
                self.visit(stm)
        else:
            self.erro('Condição do WHILE deve ser booleano')
        
    def visit_LetStmt(self, node):
        #olha para o nome da variavel (lado esquerdo)
        nomeVariavel = node.id
        #checa se ela existe, e se existir pega o tipo dela na tabela de simbolos
        simbolo = self.symbolTable.lookup(nomeVariavel)
        if simbolo is None:
            self.erro('Variável não foi declarada: %s' % nomeVariavel)
        else:
            # olha para a expressão do lado direito 
            expressao = node.exp
            tipoVariavel = simbolo.type
            
            tipoExpressao = self.visit(expressao)
            
            # e verifica o tipo
            # se os tipos casarem (igualdade), tudo ok
            if tipoVariavel != tipoExpressao: 
                self.erro('Tipos incompatíveis: ' + str(tipoVariavel) + ' e ' + str(tipoExpressao))
            
class GenPythonCodeVisitor(GenericVisitor):
    def __init__(self, tree):
        super().__init__(tree)
        visitor = TypeCheckVisitor(tree)
        if not visitor.typecheck():
            self.erro('Programa tem erros de tipo')

    def genPython(self):
        return self.visit(self.ast)

    def visit_Program(self,node):
        code = ''
        for stmt in node.stmts:
            resultado = self.visit(stmt)
            if resultado is not None:
                code += resultado + '\n'
        return code


    def visit_InputStmt(self, node):
        nomeVariavel = node.id
        return f'input({nomeVariavel})'

    def visit_LetStmt(self,node):
        nomeVariavel = node.id
        expressao = self.visit(node.exp)
        return f'{nomeVariavel} = {expressao}'

    def visit_PrintStmt(self,node):
        oQueImprimir = self.visit(node.exp)
        return f'print({oQueImprimir})'

    def visit_IdExpr(self,node):
        return node.id #nome da variável
    def visit_NumExpr(self,node):
        return node.v #número
    
    def visit_StringExpr(self, node):
        return f'"{node.str}"' #string literal

    def visit_SumExpr(self, node):
        ladoEsq = self.visit(node.left)
        ladoDir = self.visit(node.right)
        return f'{ladoEsq} + {ladoDir}'
