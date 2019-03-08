package br.ufpe.cin.if688.jflex;

%%

/* N�o altere as configura��es a seguir */

%line
%column
%unicode
//%debug
%public
%standalone
%class MiniJava
%eofclose

/* Insira as regras l�xicas abaixo */

%%
    
/* Insira as regras l�xicas no espa�o acima */     
     
. { throw new RuntimeException("Caractere ilegal! '" + yytext() + "' na linha: " + yyline + ", coluna: " + yycolumn); }
