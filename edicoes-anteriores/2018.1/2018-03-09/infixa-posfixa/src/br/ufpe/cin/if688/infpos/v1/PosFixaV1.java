package br.ufpe.cin.if688.infpos.v1;

import java.io.IOException;

public class PosFixaV1 {
	public static void main(String[] args) throws IOException {
		ParserV1 parse = new ParserV1();
		parse.expr();
		System.out.write('\n');
	}
}