package br.ufpe.cin.if688.symboltable;

public class Table {

	public String id;
	public double value;
	public Table tail;

	public Table(String i, double v, Table t) {
		id = i;
		value = v;
		tail = t;
	}

	@Override
	public String toString() {
		return "[ " + id + "->" + value + " ==> " + tail + " ]";
	}

}
