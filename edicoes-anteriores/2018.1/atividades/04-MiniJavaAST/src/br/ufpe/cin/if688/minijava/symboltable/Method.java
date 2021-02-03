package br.ufpe.cin.if688.minijava.symboltable;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import br.ufpe.cin.if688.minijava.ast.Type;

public class Method {

	String id;
	Type type;
	Vector<Variable> params;
	Hashtable<Object, Variable> vars;

	public Method(String id, Type type) {
		this.id = id;
		this.type = type;
		vars = new Hashtable<Object, Variable>();
		params = new Vector<Variable>();
	}

	public String getId() {
		return id;
	}

	public Type type() {
		return type;
	}

	public boolean addParam(String id, Type type) {
		if (containsParam(id))
			return false;
		else {
			params.addElement(new Variable(id, type));
			return true;
		}
	}

	public Enumeration getParams() {
		return params.elements();
	}

	public Variable getParamAt(int i) {
		if (i < params.size())
			return (Variable) params.elementAt(i);
		else
			return null;
	}

	public boolean addVar(String id, Type type) {
		if (vars.containsKey(id))
			return false;
		else {
			vars.put(id, new Variable(id, type));
			return true;
		}
	}

	public boolean containsVar(String id) {
		return vars.containsKey(id);
	}

	public boolean containsParam(String id) {
		for (int i = 0; i < params.size(); i++)
			if (((Variable) params.elementAt(i)).id.equals(id))
				return true;
		return false;
	}

	public Variable getVar(String id) {
		if (containsVar(id))
			return (Variable) vars.get(id);
		else
			return null;
	}

	public Variable getParam(String id) {

		for (int i = 0; i < params.size(); i++)
			if (((Variable) params.elementAt(i)).id.equals(id))
				return (Variable) (params.elementAt(i));

		return null;
	}

} // Method