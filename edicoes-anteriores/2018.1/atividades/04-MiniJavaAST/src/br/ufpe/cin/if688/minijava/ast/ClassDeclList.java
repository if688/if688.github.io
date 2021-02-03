package br.ufpe.cin.if688.minijava.ast;

import java.util.LinkedList;
import java.util.List;

public class ClassDeclList {
	private List<ClassDecl> list;

	public ClassDeclList() {
		list = new LinkedList<ClassDecl>();
	}

	public void addElement(ClassDecl n) {
		list.add(n);
	}

	public ClassDecl elementAt(int i) {
		return list.get(i);
	}

	public int size() {
		return list.size();
	}
}
