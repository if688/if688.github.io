import br.ufpe.cin.if688.ast.Expr;
import br.ufpe.cin.if688.ast.NumExpr;
import br.ufpe.cin.if688.lexer.ILexer;
import br.ufpe.cin.if688.lexer.LexerManual;
import br.ufpe.cin.if688.parser.Parser;
import br.ufpe.cin.if688.visitor.EvalVisitor;
import br.ufpe.cin.if688.visitor.IVisitor;
import br.ufpe.cin.if688.visitor.PosFixaVisitor;

public class Main {

    public static void main(String[] args) {

        ILexer lexer = new LexerManual("(((2+3))*(5))");
        Parser parser = new Parser(lexer);
        Expr e = parser.parse();
        //System.out.println(e.prettyPrint() + " == " + e.posFixa() + " = " + e.eval());

        EvalVisitor evalVisitor = new EvalVisitor();
        double resultado = evalVisitor.visit(e);

        PosFixaVisitor posFixaVisitor = new PosFixaVisitor();
        String posFixa = posFixaVisitor.visit(e);
        System.out.println("Pós-fixa é: "+posFixa+". Resultado é: "+resultado);

        //Expr e  = new SumExpr(new NumExpr(2),new NumExpr(3));
        //System.out.println(e.toString() + " == " + e.posFixa() + " = " + e.eval());


    }
}
