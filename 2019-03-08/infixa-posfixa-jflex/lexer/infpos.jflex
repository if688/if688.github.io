package br.ufpe.cin.if688.infpos.lexer;

import br.ufpe.cin.if688.infpos.lexer.Op;
import br.ufpe.cin.if688.infpos.lexer.Num;
import br.ufpe.cin.if688.infpos.lexer.Tag;
import br.ufpe.cin.if688.infpos.lexer.Token;
import br.ufpe.cin.if688.infpos.lexer.Word;

%%

%line
%column
%unicode
//%debug
%public
%class InfPosLexer
%type Token
%function getNextToken
%eofclose

letter          = [A-Za-z]
digit           = [0-9]
integer         = {digit}+
alphanumeric    = {letter}|{digit}
identifier      = {letter}({alphanumeric})*
whitespace      = [ \n\t]


%%
/**
 * REGRAS LEXICAS:
 */
"*"             { return new Op(yytext()); }
"+"             { return new Op(yytext()); }
"-"             { return new Op(yytext()); }
"/"             { return new Op(yytext()); }
{identifier}    { return new Word(Tag.ID,yytext()); }
{integer}       { return new Num(yytext()); }
{whitespace}    { /* Ignorar whitespace. */ }
.               { throw new RuntimeException("Illegal char, '" + yytext() + "' line: " + yyline + ", column: " + yycolumn); }










