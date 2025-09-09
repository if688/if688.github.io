class Symbol(object):
    def __init__(self, n, t=None, v=None):
        self.name = n
        self.type = t
        self.value = v

class BuiltInTypeSymbol(Symbol):
    def __init__(self, n):
        super().__init__(n)
    
    def __str__(self):
        return '<<{n}>>'.format(n=self.name)
    
    __repr__ = __str__

class VarSymbol(Symbol):
    def __init__(self, n, t, v=None):
        super().__init__(n, t, v=v)
    
    def __str__(self):
        return '<{n} : {t} = {v}>'.format(n=self.name, t=self.type, v=self.value)
    
    __repr__ = __str__

class SymbolTable(object):
    def __init__(self):
        self.symbols = {}
        for primitive in ['INT', 'BOOLEAN', 'STRING']:
            self.insert(primitive, BuiltInTypeSymbol(primitive))
    
    def insert(self, name, data):
        self.symbols[name] = data

    #Retorna um objeto Symbol, se houver algo associado a esta chave (name) ou None
    def lookup(self, name):
        return self.symbols.get(name)

    def update(self, name, data):
        if self.lookup(name) is None: 
            raise Exception('Símbolo inexistente: '+ name)
        else:
            self.insert(name,data)

    def __str__(self):
        symtab_header = '      Symbol Table      '
        lines = ['\n', symtab_header, '_' * len(symtab_header)]
        lines.extend(
            ('%2s: %r' % (key, value))
            for key, value in self.symbols.items()
        )
        lines.append('\n')
        s = '\n'.join(lines)
        return s
    
    __repr__ = __str__