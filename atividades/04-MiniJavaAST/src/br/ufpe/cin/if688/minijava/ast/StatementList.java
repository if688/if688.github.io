package br.ufpe.cin.if688.minijava.ast;

import java.util.LinkedList;
import java.util.List;

public class StatementList {
	private List<Statement> list;

	public StatementList() {
		list = new LinkedList<Statement>();
	}

	public void addElement(Statement n) {
		list.add(n);
	}

	public Statement elementAt(int i) {
		return list.get(i);
	}

	public int size() {
		return list.size();
	}
}
