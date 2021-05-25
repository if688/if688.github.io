package br.ufpe.cin.compilers;

import br.ufpe.cin.compilers.ast.Program;
import br.ufpe.cin.compilers.lexer.ILexer;
import br.ufpe.cin.compilers.lexer.LexerManual;
import br.ufpe.cin.compilers.parser.Parser;
import br.ufpe.cin.compilers.symboltable.SymbolTable;
import br.ufpe.cin.compilers.util.Prog;
import br.ufpe.cin.compilers.visitor.Interpreter;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        ILexer lexer = new LexerManual(Prog.simpler);
        Parser parser = new Parser(lexer);
        Program p = parser.parse();
        Interpreter interpreter = new Interpreter(new SymbolTable(new HashMap<>()));
        interpreter.visit(p);
    }
}
