package br.ufpe.cin.if688.symboltable;

public class Table {
	public String id;
	public int value;
	public Table tail;
	public Table(String i, int v, Table t) {
		id = i;
		value = v;
		tail = t;
	}
}
