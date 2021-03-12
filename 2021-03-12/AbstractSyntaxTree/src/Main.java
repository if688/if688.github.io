import br.ufpe.cin.if688.ast.Expr;
import br.ufpe.cin.if688.ast.NumExpr;
import br.ufpe.cin.if688.lexer.ILexer;
import br.ufpe.cin.if688.lexer.LexerManual;
import br.ufpe.cin.if688.parser.Parser;

public class Main {

    public static void main(String[] args) {

        ILexer lexer = new LexerManual("2+3*5");
        Parser parser = new Parser(lexer);
        Expr e = parser.parse();
        System.out.println(e.prettyPrint() + " == " + e.posFixa() + " = " + e.eval());

        //Expr e  = new SumExpr(new NumExpr(2),new NumExpr(3));
        //System.out.println(e.toString() + " == " + e.posFixa() + " = " + e.eval());


    }
}
