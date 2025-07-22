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

class PythonGenVisitor(GenericVisitor):
    def __init__(self, tree):
        super().__init__(tree)
        self.nivelIndentacao = 0
        visitor = BuildSymbolTable(tree)
        self.symbolTable = visitor.buildTable()
    
    def generatePythonCode(self):
        return self.visit(self.ast)
    
    def visit_Program(self, node):
        codigo = ""
        for stmt in node.stmts:
            codigo = codigo + self.visit(stmt)
        return codigo
    
    def visit_VarDeclStmt(self, node):
        return ""

    def visit_InputStmt(self, node):
        nomeVariavel = node.id
        simbolo = self.symbolTable.lookup(nomeVariavel)
        if simbolo is None:
            self.erro('variável %s não foi declarada' % nomeVariavel)
        else:
            tipo = simbolo.type
            if tipo == self.symbolTable.lookup('INT'):
                return node.id + " = int(input())\n"
            elif tipo == self.symbolTable.lookup('BOOLEAN'):
                return node.id + " = bool(input())\n"
            else:
                return node.id + " = input()\n"
        

    def visit_LetStmt(self, node):
        return node.id + " = " + self.visit(node.exp) + "\n"

    def visit_PrintStmt(self, node):
        return "print(str("+ self.visit(node.exp) +"))\n"

    def visit_IfStmt(self, node):
        codigo = "if "+ self.visit(node.cond) +" :\n"
        self.nivelIndentacao+=1
        for stmt in node.body:
            codigo = codigo + "".ljust(self.nivelIndentacao*2) + self.visit(stmt)
        self.nivelIndentacao-=1
        return codigo

    def visit_WhileStmt(self, node):
        codigo = "while "+ self.visit(node.cond) +" :\n"
        self.nivelIndentacao+=1
        for stmt in node.body:
            codigo = codigo + "".rjust(self.nivelIndentacao*2) + self.visit(stmt)
        self.nivelIndentacao-=1
        return codigo

    def visit_NumExpr(self, node):
        return str(node.v)
    
    def visit_IdExpr(self, node):
        return node.id

    def visit_StringExpr(self, node):
        return '"'+node.str+'"'

    def visit_GreaterThanExpr(self, node):
        return self.visit(node.left) + " > " + self.visit(node.right)
    def visit_GreaterThanEqualsExpr(self, node):
        return self.visit(node.left) + " >= " + self.visit(node.right)
    def visit_LessThanExpr(self, node):
        return self.visit(node.left) + " < " + self.visit(node.right)
    def visit_LessThanEqualsExpr(self, node):
        return self.visit(node.left) + " <= " + self.visit(node.right)
    def visit_EqualsExpr(self, node):
        return self.visit(node.left) + " == " + self.visit(node.right)
    def visit_NotEqualsExpr(self, node):
        return self.visit(node.left) + " != " + self.visit(node.right)

    def visit_UnaryPlusExpr(self, node):
        return "+" + self.visit(node.e)
    def visit_UnaryMinusExpr(self, node):
        return "-" + self.visit(node.e)


    def visit_SumExpr(self, node):
        return self.visit(node.left) + " + " + self.visit(node.right)
    def visit_SubExpr(self, node):
        return self.visit(node.left) + " - " + self.visit(node.right)
    def visit_MulExpr(self, node):
        return self.visit(node.left) + " * " + self.visit(node.right)
    def visit_DivExpr(self, node):
        return self.visit(node.left) + " / " + self.visit(node.right)
    

class Interpreter(GenericVisitor):
    def __init__(self, tree):
        super().__init__(tree)
        self.typeChecker = TypeCheckVisitor(tree)
    
    def st(self):
        return self.typeChecker.symbolTable
    
    def interpret(self):
        if self.typeChecker.typecheck():
            self.visit(self.ast)
        else:
            self.erro('Problema na checagem de tipos')
   
    def visit_InputStmt(self, node):
        nomeVariavel = node.id
        simbolo = self.st().lookup(nomeVariavel)    
        tipo = simbolo.type
        if tipo == self.st().lookup('INT'):
            entrada_usuario = int(input())
        elif tipo == self.st().lookup('BOOLEAN'):
            entrada_usuario = bool(input())
        else:
            entrada_usuario = input()
        novoSimbolo = VarSymbol(nomeVariavel, tipo, entrada_usuario)
        self.st().update(nomeVariavel,novoSimbolo)

    def visit_PrintStmt(self, node):
        print(str(self.visit(node.exp)))

    def visit_NumExpr(self, node):
        return node.v
    
    def visit_IdExpr(self, node):
        nomeVariavel = node.id
        simbolo = self.st().lookup(nomeVariavel)    
        return simbolo.value

    def visit_StringExpr(self, node):
        return node.str

    def visit_LetStmt(self, node):
        nomeVariavel = node.id
        simbolo = self.st().lookup(nomeVariavel)    
        novoValor = self.visit(node.exp)
        novoSimbolo = VarSymbol(nomeVariavel, simbolo.type, novoValor)
        self.st().update(nomeVariavel,novoSimbolo)

    def visit_IfStmt(self, node):
        condicaoIf = self.visit(node.cond)
        if condicaoIf:
            for stmt in node.body:
                self.visit(stmt)

    def visit_WhileStmt(self, node):
        condicaoWhile = self.visit(node.cond)
        while condicaoWhile:
            for stmt in node.body:
                self.visit(stmt)
            condicaoWhile = self.visit(node.cond)

    def visit_GreaterThanExpr(self, node):
        return self.visit(node.left) > self.visit(node.right)
    def visit_GreaterThanEqualsExpr(self, node):
        return self.visit(node.left) >= self.visit(node.right)
    def visit_LessThanExpr(self, node):
        return self.visit(node.left) < self.visit(node.right)
    def visit_LessThanEqualsExpr(self, node):
        return self.visit(node.left) <= self.visit(node.right)
    def visit_EqualsExpr(self, node):
        return self.visit(node.left) == self.visit(node.right)
    def visit_NotEqualsExpr(self, node):
        return self.visit(node.left) != self.visit(node.right)

    def visit_UnaryPlusExpr(self, node):
        return +self.visit(node.e)
    def visit_UnaryMinusExpr(self, node):
        return -self.visit(node.e)

    def visit_SumExpr(self, node):
        return self.visit(node.left) + self.visit(node.right)
    def visit_SubExpr(self, node):
        return self.visit(node.left) - self.visit(node.right)
    def visit_MulExpr(self, node):
        return self.visit(node.left) * self.visit(node.right)
    def visit_DivExpr(self, node):
        return self.visit(node.left) / self.visit(node.right)