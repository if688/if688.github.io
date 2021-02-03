package br.ufpe.cin.if688.infpos.v0;

public class InfixaPosfixa {

	public static void main(String[] args) {
		// idealmente seria lido de um arquivo ou algo do tipo
		String input = "2+2";//22+
		//input = "2-1+3+4-2-1+9";//?
		//input = "2 + 3 * 4";//234*+
		System.out.println( input + "==" + posfixa(input));
		
	}

	//obviamente não é a melhor solução
	private static String posfixa(String expr) {
		StringBuilder sb = new StringBuilder().append(expr.charAt(0)).append(expr.charAt(2)).append(expr.charAt(1));
		return sb.toString();
	}
}
