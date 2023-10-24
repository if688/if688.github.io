class SymbolTable(object):
    def __init__(self) -> None:
        self.tabela = {}
    def presente(self,nome):
        return nome in self.tabela.keys()
    def lookup(self,nome):
        if self.presente(nome):
            return self.tabela[nome]
        else:
            return None
    def inserir(self,nome,valor):
        self.tabela[nome] = valor