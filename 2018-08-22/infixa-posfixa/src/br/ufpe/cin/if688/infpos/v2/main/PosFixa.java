package br.ufpe.cin.if688.infpos.v2.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import br.ufpe.cin.if688.infpos.v2.lexer.Lexer;
import br.ufpe.cin.if688.infpos.v2.parser.Parser;

public class PosFixa {
	public static final String file = "examples/exp.in";
	
	public static void main(String[] args) throws IOException {
		String expression = readFile(file, StandardCharsets.UTF_8);
		Lexer lexer = new Lexer(expression);
		//System.out.println(lexer.tokens());
		Parser parse = new Parser(lexer);
		parse.expr();
		System.out.write('\n');
		/**/
	}

	static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}
