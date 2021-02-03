package br.ufpe.cin.if688.jflex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		new MiniJava(new BufferedReader(new InputStreamReader(System.in))).yylex();
	}
}
