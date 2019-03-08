package generated.lexer;

/* JFlex example: partial Java language lexer specification */

import java_cup.runtime.*;

/**
 * This class is a simple example lexer.
 */
%%

%class LexerJFlex
%unicode
%cup
%debug
%line
%column


%{
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value);
  }
%}
/**/


LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

//TraditionalComment is the expression that matches the string /* followed by a character that is not a *, followed by anything that does not contain, but ends in */. As this would not match comments like /****/, we add /* followed by an arbitrary number (at least one) of * followed by the closing /. This is not the only, but one of the simpler expressions matching non-nesting Java comments. It is tempting to just write something like the expression /* .* */, but this would match more than we want. It would for instance match the entire input /* */ x = 0; /* */, instead of two comments and four real tokens. See the macros DocumentationComment and CommentContent for an alternative.
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"

// Comment can be the last line of the file, without line terminator.
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?

DocumentationComment = "/**" {CommentContent} "*"+"/"
CommentContent   = ( [^*] | \*+ [^/*] )*

//Identifier matches each string that starts with a character of class jletter followed by zero or more characters of class jletterdigit. jletter and jletterdigit are predefined character classes. jletter includes all characters for which the Java function Character.isJavaIdentifierStart returns true and jletterdigit all characters for that Character.isJavaIdentifierPart returns true.
Identifier = [:jletter:] [:jletterdigit:]*

DecIntegerLiteral = 0 | [1-9][0-9]*

%state STRING

%%

/* keywords */
<YYINITIAL> "abstract"   { return symbol(sym.ABSTRACT); }
<YYINITIAL> "boolean"    { return symbol(sym.BOOLEAN); }
<YYINITIAL> "break"      { return symbol(sym.BREAK); }

<YYINITIAL> {
  /* identifiers */ 
  {Identifier}   { return symbol(sym.IDENTIFIER); }
 
  /* literals */
  {DecIntegerLiteral}   { return symbol(sym.INTEGER_LITERAL); }
  \"  { string.setLength(0); yybegin(STRING); }

  /* operators */
  "="   { return symbol(sym.EQ); }
  "=="  { return symbol(sym.EQEQ); }
  "+"   { return symbol(sym.PLUS); }

  /* comments */
  {Comment}  { /* ignore */ }
 
  /* whitespace */
  {WhiteSpace}   { /* ignore */ }
}

<STRING> {
  \" 			{ yybegin(YYINITIAL); return symbol(sym.STRING_LITERAL, string.toString()); }
  [^\n\r\"\\]+  { string.append( yytext() ); }
  \\t			{ string.append('\t'); }
  \\n			{ string.append('\n'); }
  \\r   		{ string.append('\r'); }
  \\\"   		{ string.append('\"'); }
  \\     		{ string.append('\\'); }
}

/* error fallback */
[^]  { throw new Error("Illegal character <"+yytext()+">"); }
