from ply import lex

tokens = (
    'QUEBRA_LINHA',
    'NUMERO',
    'STRING',
    'IF',
    'THEN',
    'ENDIF',
    'WHILE',
    'REPEAT',
    'ENDWHILE',
    'ATRIBUICAO',
    'SOMA',
    'SUBTRACAO',
    'MULT',
    'DIVISAO',
    'MAIOR_QUE',
    'MAIOR_IGUAL',
    'IDENT'
)

t_ATRIBUICAO = r'='
t_SOMA = r'\+'
t_SUBTRACAO = r'-'
t_MULT = r'\*'
t_DIVISAO = r'/'
t_MAIOR_QUE = r'>'
t_MAIOR_IGUAL = r'>='
t_IF = r'IF'
t_IDENT = r'[a-zA-Z][a-zA-Z0-9]*'

def t_NUMERO(t):
    r'\d+'
    t.value = int(t.value)
    return t

t_ignore = ' '

def t_error(t): 
    print("Caractere ilegal '%s'" % t.value[0])

lexer = lex.lex()

data = "IF 32+16*10 >= 12"
lexer.input(data)
while True: 
    token = lexer.token()
    if not token: 
        break
    print(token)
