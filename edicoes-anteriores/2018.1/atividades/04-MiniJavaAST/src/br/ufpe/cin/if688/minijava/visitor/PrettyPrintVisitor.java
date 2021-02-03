package br.ufpe.cin.if688.minijava.visitor;

import br.ufpe.cin.if688.minijava.ast.And;
import br.ufpe.cin.if688.minijava.ast.ArrayAssign;
import br.ufpe.cin.if688.minijava.ast.ArrayLength;
import br.ufpe.cin.if688.minijava.ast.ArrayLookup;
import br.ufpe.cin.if688.minijava.ast.Assign;
import br.ufpe.cin.if688.minijava.ast.Block;
import br.ufpe.cin.if688.minijava.ast.BooleanType;
import br.ufpe.cin.if688.minijava.ast.Call;
import br.ufpe.cin.if688.minijava.ast.ClassDeclExtends;
import br.ufpe.cin.if688.minijava.ast.ClassDeclSimple;
import br.ufpe.cin.if688.minijava.ast.False;
import br.ufpe.cin.if688.minijava.ast.Formal;
import br.ufpe.cin.if688.minijava.ast.Identifier;
import br.ufpe.cin.if688.minijava.ast.IdentifierExp;
import br.ufpe.cin.if688.minijava.ast.IdentifierType;
import br.ufpe.cin.if688.minijava.ast.If;
import br.ufpe.cin.if688.minijava.ast.IntArrayType;
import br.ufpe.cin.if688.minijava.ast.IntegerLiteral;
import br.ufpe.cin.if688.minijava.ast.IntegerType;
import br.ufpe.cin.if688.minijava.ast.LessThan;
import br.ufpe.cin.if688.minijava.ast.MainClass;
import br.ufpe.cin.if688.minijava.ast.MethodDecl;
import br.ufpe.cin.if688.minijava.ast.Minus;
import br.ufpe.cin.if688.minijava.ast.NewArray;
import br.ufpe.cin.if688.minijava.ast.NewObject;
import br.ufpe.cin.if688.minijava.ast.Not;
import br.ufpe.cin.if688.minijava.ast.Plus;
import br.ufpe.cin.if688.minijava.ast.Print;
import br.ufpe.cin.if688.minijava.ast.Program;
import br.ufpe.cin.if688.minijava.ast.This;
import br.ufpe.cin.if688.minijava.ast.Times;
import br.ufpe.cin.if688.minijava.ast.True;
import br.ufpe.cin.if688.minijava.ast.VarDecl;
import br.ufpe.cin.if688.minijava.ast.While;

public class PrettyPrintVisitor implements IVisitor<Void> {

	// MainClass m;
	// ClassDeclList cl;
	public Void visit(Program n) {
		n.m.accept(this);
		for (int i = 0; i < n.cl.size(); i++) {
			System.out.println();
			n.cl.elementAt(i).accept(this);
		}
		return null;
	}

	// Identifier i1,i2;
	// Statement s;
	public Void visit(MainClass n) {
		System.out.print("class ");
		n.i1.accept(this);
		System.out.println(" {");
		System.out.print("  public static Void main (String [] ");
		n.i2.accept(this);
		System.out.println(") {");
		System.out.print("    ");
		n.s.accept(this);
		System.out.println("");
		System.out.println("  }");
		System.out.println("}");
		return null;
	}

	// Identifier i;
	// VarDeclList vl;
	// MethodDeclList ml;
	public Void visit(ClassDeclSimple n) {
		System.out.print("class ");
		n.i.accept(this);
		System.out.println(" { ");
		for (int i = 0; i < n.vl.size(); i++) {
			System.out.print("  ");
			n.vl.elementAt(i).accept(this);
			if (i + 1 < n.vl.size()) {
				System.out.println();
			}
		}
		for (int i = 0; i < n.ml.size(); i++) {
			System.out.println();
			n.ml.elementAt(i).accept(this);
		}
		System.out.println();
		System.out.println("}");
		return null;
	}

	// Identifier i;
	// Identifier j;
	// VarDeclList vl;
	// MethodDeclList ml;
	public Void visit(ClassDeclExtends n) {
		System.out.print("class ");
		n.i.accept(this);
		System.out.print(" extends ");
		n.j.accept(this);
		System.out.println(" { ");
		for (int i = 0; i < n.vl.size(); i++) {
			System.out.print("  ");
			n.vl.elementAt(i).accept(this);
			if (i + 1 < n.vl.size()) {
				System.out.println();
			}
		}
		for (int i = 0; i < n.ml.size(); i++) {
			System.out.println();
			n.ml.elementAt(i).accept(this);
		}
		System.out.println();
		System.out.println("}");
		return null;
	}

	// Type t;
	// Identifier i;
	public Void visit(VarDecl n) {
		n.t.accept(this);
		System.out.print(" ");
		n.i.accept(this);
		System.out.print(";");
		return null;
	}

	// Type t;
	// Identifier i;
	// FormalList fl;
	// VarDeclList vl;
	// StatementList sl;
	// Exp e;
	public Void visit(MethodDecl n) {
		System.out.print("  public ");
		n.t.accept(this);
		System.out.print(" ");
		n.i.accept(this);
		System.out.print(" (");
		for (int i = 0; i < n.fl.size(); i++) {
			n.fl.elementAt(i).accept(this);
			if (i + 1 < n.fl.size()) {
				System.out.print(", ");
			}
		}
		System.out.println(") { ");
		for (int i = 0; i < n.vl.size(); i++) {
			System.out.print("    ");
			n.vl.elementAt(i).accept(this);
			System.out.println("");
		}
		for (int i = 0; i < n.sl.size(); i++) {
			System.out.print("    ");
			n.sl.elementAt(i).accept(this);
			if (i < n.sl.size()) {
				System.out.println("");
			}
		}
		System.out.print("    return ");
		n.e.accept(this);
		System.out.println(";");
		System.out.print("  }");
		return null;
	}

	// Type t;
	// Identifier i;
	public Void visit(Formal n) {
		n.t.accept(this);
		System.out.print(" ");
		n.i.accept(this);
		return null;
	}

	public Void visit(IntArrayType n) {
		System.out.print("int []");
		return null;
	}

	public Void visit(BooleanType n) {
		System.out.print("boolean");
		return null;
	}

	public Void visit(IntegerType n) {
		System.out.print("int");
		return null;
	}

	// String s;
	public Void visit(IdentifierType n) {
		System.out.print(n.s);
		return null;
	}

	// StatementList sl;
	public Void visit(Block n) {
		System.out.println("{ ");
		for (int i = 0; i < n.sl.size(); i++) {
			System.out.print("      ");
			n.sl.elementAt(i).accept(this);
			System.out.println();
		}
		System.out.print("    } ");
		return null;
	}

	// Exp e;
	// Statement s1,s2;
	public Void visit(If n) {
		System.out.print("if (");
		n.e.accept(this);
		System.out.println(") ");
		System.out.print("    ");
		n.s1.accept(this);
		System.out.println();
		System.out.print("    else ");
		n.s2.accept(this);
		return null;
	}

	// Exp e;
	// Statement s;
	public Void visit(While n) {
		System.out.print("while (");
		n.e.accept(this);
		System.out.print(") ");
		n.s.accept(this);
		return null;
	}

	// Exp e;
	public Void visit(Print n) {
		System.out.print("System.out.println(");
		n.e.accept(this);
		System.out.print(");");
		return null;
	}

	// Identifier i;
	// Exp e;
	public Void visit(Assign n) {
		n.i.accept(this);
		System.out.print(" = ");
		n.e.accept(this);
		System.out.print(";");
		return null;
	}

	// Identifier i;
	// Exp e1,e2;
	public Void visit(ArrayAssign n) {
		n.i.accept(this);
		System.out.print("[");
		n.e1.accept(this);
		System.out.print("] = ");
		n.e2.accept(this);
		System.out.print(";");
		return null;
	}

	// Exp e1,e2;
	public Void visit(And n) {
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" && ");
		n.e2.accept(this);
		System.out.print(")");
		return null;
	}

	// Exp e1,e2;
	public Void visit(LessThan n) {
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" < ");
		n.e2.accept(this);
		System.out.print(")");
		return null;
	}

	// Exp e1,e2;
	public Void visit(Plus n) {
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" + ");
		n.e2.accept(this);
		System.out.print(")");
		return null;
	}

	// Exp e1,e2;
	public Void visit(Minus n) {
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" - ");
		n.e2.accept(this);
		System.out.print(")");
		return null;
	}

	// Exp e1,e2;
	public Void visit(Times n) {
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" * ");
		n.e2.accept(this);
		System.out.print(")");
		return null;
	}

	// Exp e1,e2;
	public Void visit(ArrayLookup n) {
		n.e1.accept(this);
		System.out.print("[");
		n.e2.accept(this);
		System.out.print("]");
		return null;
	}

	// Exp e;
	public Void visit(ArrayLength n) {
		n.e.accept(this);
		System.out.print(".length");
		return null;
	}

	// Exp e;
	// Identifier i;
	// ExpList el;
	public Void visit(Call n) {
		n.e.accept(this);
		System.out.print(".");
		n.i.accept(this);
		System.out.print("(");
		for (int i = 0; i < n.el.size(); i++) {
			n.el.elementAt(i).accept(this);
			if (i + 1 < n.el.size()) {
				System.out.print(", ");
			}
		}
		System.out.print(")");
		return null;
	}

	// int i;
	public Void visit(IntegerLiteral n) {
		System.out.print(n.i);
		return null;
	}

	public Void visit(True n) {
		System.out.print("true");
		return null;
	}

	public Void visit(False n) {
		System.out.print("false");
		return null;
	}

	// String s;
	public Void visit(IdentifierExp n) {
		System.out.print(n.s);
		return null;
	}

	public Void visit(This n) {
		System.out.print("this");
		return null;
	}

	// Exp e;
	public Void visit(NewArray n) {
		System.out.print("new int [");
		n.e.accept(this);
		System.out.print("]");
		return null;
	}

	// Identifier i;
	public Void visit(NewObject n) {
		System.out.print("new ");
		System.out.print(n.i.s);
		System.out.print("()");
		return null;
	}

	// Exp e;
	public Void visit(Not n) {
		System.out.print("!");
		n.e.accept(this);
		return null;
	}

	// String s;
	public Void visit(Identifier n) {
		System.out.print(n.s);
		return null;
	}
}