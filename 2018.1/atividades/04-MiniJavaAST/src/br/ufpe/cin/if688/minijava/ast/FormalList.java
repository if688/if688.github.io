package br.ufpe.cin.if688.minijava.ast;

import java.util.LinkedList;
import java.util.List;

public class FormalList {
	private List<Formal> list;

	public FormalList() {
		list = new LinkedList<Formal>();
	}

	public void addElement(Formal n) {
		list.add(n);
	}

	public Formal elementAt(int i) {
		return list.get(i);
	}

	public int size() {
		return list.size();
	}
}
