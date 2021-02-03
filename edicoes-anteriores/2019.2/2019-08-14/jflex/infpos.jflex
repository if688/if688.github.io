package br.ufpe.cin.if688.infpos.lexer;

import br.ufpe.cin.if688.infpos.lexer.Num;
import br.ufpe.cin.if688.infpos.lexer.Tag;
import br.ufpe.cin.if688.infpos.lexer.Token;

%%

%line
%column
%unicode
//%debug
%public
%class InfPosLexer
%type Token
%function getNextToken
%implements ILexer<Token>
%eofclose

%{
	@Override
    public int getLine() {
		return yyline;
	}

	@Override
	public int getColumn() {
		//TODO considerar column-1
		return yycolumn;
	}
%}


digit           = [0-9]
integer         = {digit}+
whitespace      = [ \n\t]


%%
/**
 * REGRAS LEXICAS:
 */
"*"             { return new Token(yytext()); }
"+"             { return new Token(yytext()); }
"-"             { return new Token(yytext()); }
"/"             { return new Token(yytext()); }
{integer}       { return new Num(yytext()); }
{whitespace}    { /* Ignorar whitespace. */ }
.               { throw new RuntimeException("Illegal char, '" + yytext() + "' line: " + yyline + ", column: " + yycolumn); }










