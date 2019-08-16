%%

%public
%class ScannerJF
%function token
%type Token

%%

[ \n\r\t] { }

[0-9]+ { return new Token(Token.NUM, yytext()); }

print { return new Token(Token.PRINT, yytext()); }

[a-zA-Z]+ { return new Token(Token.ID, yytext()); } 
[+]|[-]|;|[(]|[)]|[=] { return new Token(yytext().charAt(0), yytext()); } 
<<EOF>> { return new Token(Token.EOF, “<<EOF>>”); }

. { throw new RuntimeException("caractere inválido "+yytext()); }










