package br.ufpe.cin.if688.jflex;

import java.io.File;

/* Ap�s implementar as suas regras l�xicas no arquivo Minijava.jflex que est� em src/main/resources, rode essa classe "Gerador"
   e ent�o a classe Minijava ser� gerada na pasta resources.
 */
/* N�o h� necessidade de alterar nada nesta classe, apenas rod�-la. */

public class Gerador {
		public static void main(String[] args) {
			String loginAluno = "MiniJava";
			String path = "src/main/resources/";   
			String arquivo = path + loginAluno + ".jflex";    
			File file = new File(arquivo);	
			jflex.Main.generate(file);	
		}
	}
