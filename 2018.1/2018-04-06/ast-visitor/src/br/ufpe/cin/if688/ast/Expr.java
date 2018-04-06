package br.ufpe.cin.if688.ast;

import br.ufpe.cin.if688.visitor.IVisitor;
import br.ufpe.cin.if688.visitor.IntVisitor;
import br.ufpe.cin.if688.visitor.VoidVisitor;

public abstract class Expr {	
	
	//Caso não façamos a separação entre sintaxe e interpretação,
	//teríamos que ter uma função para cada interpretação definida,
	//conforme vemos abaixo:
	public abstract double eval();
	public abstract String prettyPrint();
	public abstract String posFixa();
	
	//Ao separar sintaxe de interpretação, definimos interpretações
	//em termos de Visitors, que precisam apenas de um método accept
	public abstract <T> T accept(IVisitor<T> v);

	//O caso acima é mais geral e compreende qualquer tipo de visitor
	//que desejemos implementar. Se não usássemos Generics, teríamos
	//de ter algo como o abaixo - um accept para cada tipo diferente de
	//visitor.
	public abstract void accept(VoidVisitor v);
	public abstract int accept(IntVisitor v);
}