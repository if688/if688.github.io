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

public interface IVisitor<T> {
	public T visit(Program n);

	public T visit(MainClass n);

	public T visit(ClassDeclSimple n);

	public T visit(ClassDeclExtends n);

	public T visit(VarDecl n);

	public T visit(MethodDecl n);

	public T visit(Formal n);

	public T visit(IntArrayType n);

	public T visit(BooleanType n);

	public T visit(IntegerType n);

	public T visit(IdentifierType n);

	public T visit(Block n);

	public T visit(If n);

	public T visit(While n);

	public T visit(Print n);

	public T visit(Assign n);

	public T visit(ArrayAssign n);

	public T visit(And n);

	public T visit(LessThan n);

	public T visit(Plus n);

	public T visit(Minus n);

	public T visit(Times n);

	public T visit(ArrayLookup n);

	public T visit(ArrayLength n);

	public T visit(Call n);

	public T visit(IntegerLiteral n);

	public T visit(True n);

	public T visit(False n);

	public T visit(IdentifierExp n);

	public T visit(This n);

	public T visit(NewArray n);

	public T visit(NewObject n);

	public T visit(Not n);

	public T visit(Identifier n);
}
