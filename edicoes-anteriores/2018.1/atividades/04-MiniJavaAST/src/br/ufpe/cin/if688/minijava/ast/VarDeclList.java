package br.ufpe.cin.if688.minijava.ast;

import java.util.LinkedList;
import java.util.List;

public class VarDeclList {
	private List<VarDecl> list;

	public VarDeclList() {
		list = new LinkedList<VarDecl>();
	}

	public void addElement(VarDecl n) {
		list.add(n);
	}

	public VarDecl elementAt(int i) {
		return list.get(i);
	}

	public int size() {
		return list.size();
	}
}
