package br.ufpe.cin.if688.minijava.ast;

import java.util.LinkedList;
import java.util.List;

public class MethodDeclList {
	private List<MethodDecl> list;

	public MethodDeclList() {
		list = new LinkedList<MethodDecl>();
	}

	public void addElement(MethodDecl n) {
		list.add(n);
	}

	public MethodDecl elementAt(int i) {
		return list.get(i);
	}

	public int size() {
		return list.size();
	}
}
