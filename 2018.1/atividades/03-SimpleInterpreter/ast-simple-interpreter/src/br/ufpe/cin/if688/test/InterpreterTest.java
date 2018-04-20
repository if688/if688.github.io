package br.ufpe.cin.if688.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufpe.cin.if688.symboltable.Table;
import br.ufpe.cin.if688.visitor.Interpreter;

public class InterpreterTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(System.out);
		System.setErr(System.err);
	}

	@Test
	public void test1() {
		Interpreter interpreter = new Interpreter(null);
		Table t = interpreter.visit(Prog.print);
		assertEquals("4.0\n", outContent.toString());
	}

	@Test
	public void test2() {
		Interpreter interpreter = new Interpreter(null);
		Table t = interpreter.visit(Prog.prog);
		assertEquals("8.0\n7.0\n80.0\n", outContent.toString());
	}

	@Test
	public void test3() {
		Interpreter interpreter = new Interpreter(null);
		Table t = interpreter.visit(Prog.prog2);
		assertEquals("512.0\n", outContent.toString());
	}
	
	@Test
	public void test4() {
		Interpreter interpreter = new Interpreter(null);
		Table t = interpreter.visit(Prog.printEseqExp);
		assertEquals("512.0\n", outContent.toString());
	}
	
	@Test
	public void test5() {
		Interpreter interpreter = new Interpreter(null);
		Table t = interpreter.visit(Prog.print1234);
		assertEquals("0.0\n1.0\n2.0\n3.0\n4.0\n", outContent.toString());
	}
	
	@Test
	public void test6() {
		Interpreter interpreter = new Interpreter(null);
		Table t = interpreter.visit(Prog.printPrint);
		assertEquals("0.0\n1.0\n2.0\n3.0\n4.0\n5.0\n", outContent.toString());
	}

}
