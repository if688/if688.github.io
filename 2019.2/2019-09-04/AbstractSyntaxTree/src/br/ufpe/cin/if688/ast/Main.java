package br.ufpe.cin.if688.ast;

public class Main {

    public static void main(String[] args) {

        //Idealmente a gente digitaria alguma coisa no console: "42+(57+22)" e montaria a árvore
        //Aqui estamos montando manualmente
        Expr soma;
        NumExpr n42 = new NumExpr(42);
        NumExpr n57 = new NumExpr(57);
        NumExpr n22 = new NumExpr(22);
        SumExpr n57_PLUS_22 = new SumExpr(n57,n22);
        soma = new SumExpr(n42,n57_PLUS_22);
        System.out.println(soma + " --- "+ soma.posFixa() + " --- "+soma.eval());

        EvalVisitor ev = new EvalVisitor();
        double resultado = ev.visit(soma);
        PosFixaVisitor pfv = new PosFixaVisitor();
        pfv.visit(soma);

        System.out.println(soma + " == " + pfv.posFixa() + " = " + resultado);
    }
}
