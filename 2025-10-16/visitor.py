from astnodes import *

class NodeVisitor:
    def visit(self, node):
        print('visit de NodeVisitor')
        tipo_do_no = type(node).__name__
        nome_metodo = f'visit_{tipo_do_no}'
        print(f'vai chamar agora {nome_metodo}')
        visitor = getattr(self, nome_metodo, self.visit_generico)
        return visitor(node)
    def visit_generico(self,node):
        raise Exception(f'Nenhum método visit_{type(node).__name__} foi definido')


class EvalVisitor(NodeVisitor):
    def __init__(self, ast):
        self.ast = ast
    def eval(self):
        print('começando a visitar')
        return self.visit(self.ast)
    def visit_SumExpr(self, node):
        return self.visit(node.ladoEsq) + self.visit(node.ladoDir)
    def visit_SubExpr(self, node):
        return self.visit(node.ladoEsq) - self.visit(node.ladoDir)
    def visit_MulExpr(self, node):
        return self.visit(node.ladoEsq) * self.visit(node.ladoDir)
    def visit_DivExpr(self, node):
        if self.visit(node.ladoDir) == 0:
            raise ValueError('Não pode dividir por 0!')
        else:
            return self.visit(node.ladoEsq) / self.visit(node.ladoDir)
    def visit_NumExpr(self, node):
        print('entrou em visit_NumExpr')
        return node.valor 

if __name__ == '__main__':
    num2 = NumExpr(2)
    num3 = NumExpr(3)
    exp2mais3 = SumExpr(
        num2,
        num3
    )
    print(num2)
    print(num3)
    print(exp2mais3)
    # visitor = NodeVisitor()
    # visitor.visit(num2)
    visitor = EvalVisitor(exp2mais3)
    resultado = visitor.eval()
    print(resultado)
    # print(type(exp2mais3))
    # print(type(exp2mais3).__name__) 
    # print(type(type(exp2mais3).__name__))