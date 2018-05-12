package br.ufpe.cin.if688.minijava.ast;

import java.util.LinkedList;
import java.util.List;

public class ExpList {
	private List<Exp> list;

	public ExpList() {
		list = new LinkedList<Exp>();
	}

	public void addElement(Exp n) {
		list.add(n);
	}

	public Exp elementAt(int i) {
		return list.get(i);
	}

	public int size() {
		return list.size();
	}
}
