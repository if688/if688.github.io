grammar arithmetic;

exps: expression EOF;

expression:   expression (TIMES | DIV) expression
            | expression (PLUS | MINUS) expression
            | LPAREN expression RPAREN
            | atom
            ;

atom: number | variable ;
variable : VARIABLE;
number: NUMBER;

LPAREN : '(';
RPAREN : ')';
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIV: '/';
NUMBER: ('0'..'9')+;
fragment ALPHANUMERIC: INICIO_VALIDO | ('0'..'9');
VARIABLE: INICIO_VALIDO ALPHANUMERIC*;
fragment INICIO_VALIDO: ('a'..'z') | ('A'..'Z');
