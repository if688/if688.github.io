package atividade1;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class TesteBinaryTree {

	@Test
	public void test() throws IOException {
		BufferedReader input = new BufferedReader(new FileReader("src/test/resources/BinaryTree.java"));
		Minijava lexer = new Minijava(input);		
		assertEquals(lexer.yylex(), -1);
	}

}
