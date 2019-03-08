package br.ufpe.cin.if688.infpos.v0;

import java.util.Stack;

public class InfixaPosfixa {

	public static void main(String[] args) {
		String input ;
		// idealmente seria lido de um arquivo ou algo do tipo
		input = "2+2";// 22+
		System.out.println(input + "==" + posfixa(input));
		input = "9-5+2";//?
		System.out.println(input + "==" + posfixa(input));
		input = "2+3-4";//?
		System.out.println(input + "==" + posfixa(input));
		input = "2-1+3+4-2-1+9";//?
		System.out.println(input + "==" + posfixa(input));
		input = "2+3*4";//234*+
		System.out.println(input + "==" + posfixa(input));
		input = "2 + 3 * 114";//2 3 114 * + 
		System.out.println(input + "==" + posfixa(input));
	}

	// obviamente não é a melhor solução
	private static String posfixa(String expr) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> pilha = new Stack<>();
		char c ;
		for (int i = 0; i < expr.length(); i++ ) {
			c = expr.charAt(i);
			if (! ( (c == '+') || (c == '-')) ) {
				sb.append(c);
			}
			else {
				if (!pilha.isEmpty()) {
					sb.append(pilha.pop());
				}
				pilha.push(c);
			}
		}
		sb.append(pilha.pop());
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
}