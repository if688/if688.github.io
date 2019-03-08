package br.ufpe.cin.if688.infpos.main;

import java.io.IOException;

import br.ufpe.cin.if688.infpos.lexer.InfPosLexer;
import br.ufpe.cin.if688.infpos.parser.Parser;

public class InfixaPosFixa {
	public static final String teste = "teste/exp.in";
	
	public static void main(String[] args) throws IOException {
		String encodingName = "UTF-8";
		InfPosLexer scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(teste);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new InfPosLexer(reader);
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+teste+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+teste+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
		
		Parser parse = new Parser(scanner);
		parse.expr();
		System.out.write('\n');
	}
}
