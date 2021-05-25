//1ª parte - código copiado diretamente para o topo da classe gerada
package br.ufpe.cin.compilers.jflex;
//import...

%%
//2ª parte - configurar o analisador léxico

%line
%column

%unicode

//vai gerar um método main que permite que a classe seja chamada diretamente
%standalone

%class LexerGerado

%{
int qtdeIdentificadores = 0;

public void nomeMetodo() {}
%}

%eof{
    System.out.println("Terminou de ler o arquivo. Quantidade de identificadores: "+qtdeIdentificadores+".");
%eof}

//Nomear padrões
letra = [A-Za-z]
digito = [0-9]
inteiro = {digito}+
alfanumerico = {letra}|{digito}
identificador = ({letra})({alfanumerico} | [_])*
whitespace = [ \n]

%%
//3ª parte - Regras Léxicas

"+"             { System.out.println("TOKEN +"); }
"-"             { System.out.println("TOKEN -"); }
"(" | ")"       { System.out.println("TOKEN "+yytext()); }
";"             { System.out.println("TOKEN "+yytext()); }
"="             { System.out.println("TOKEN "+yytext()); }
"print"         { System.out.println("TOKEN PRINT"); }
{identificador} { qtdeIdentificadores++; System.out.println("TOKEN ID ("+yytext()+")"); }
{inteiro}       { System.out.println("TOKEN NUM ("+yytext()+")"); }
{whitespace}    {  }
. {System.out.println("Caractere ilegal: "+yytext());}

