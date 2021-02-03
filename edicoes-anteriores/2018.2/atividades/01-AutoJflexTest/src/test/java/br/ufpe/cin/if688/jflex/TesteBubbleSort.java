package br.ufpe.cin.if688.jflex;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class TesteBubbleSort {

	@Test
	public void test() throws IOException {
		BufferedReader input = new BufferedReader(new FileReader("src/test/resources/BubbleSort.java"));
		MiniJava lexer = new MiniJava(input);
		assertEquals(lexer.yylex(), -1);
	}

}
