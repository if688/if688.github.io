package br.ufpe.cin.compilers.parser;


import br.ufpe.cin.compilers.ast.Program;
import br.ufpe.cin.compilers.ast.boolexp.*;
import br.ufpe.cin.compilers.ast.exp.*;
import br.ufpe.cin.compilers.ast.stm.*;
import br.ufpe.cin.compilers.lexer.ILexer;
import br.ufpe.cin.compilers.lexer.Num;
import br.ufpe.cin.compilers.lexer.TipoToken;
import br.ufpe.cin.compilers.lexer.Token;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    ILexer lexer;
    private Token curToken, peekToken;

    boolean debugModeOn = false;

    public Parser(ILexer l) {
        lexer = l;
        curToken = null;
        peekToken = null;
        nextToken();
        nextToken();
    }

    boolean checkToken(TipoToken kind) {
        return kind == curToken.tipo;
    }

    boolean checkPeek(TipoToken kind) {
        return kind == curToken.tipo;
    }

    void nextToken() {
        curToken = peekToken;
        peekToken = lexer.getToken();
    }

    void abort(String msg) {
        throw new ParsingException(msg);
    }

    void match(TipoToken kind) {
        if (checkToken(kind)) {
            nextToken();
        } else {
            abort("Esperava por token do tipo " + kind.name() + ", apareceu " + curToken.tipo.name());
        }
    }

    public Program parse() {
        return program();
    }

//    https://github.com/AZHenley/teenytinycompiler
//    program ::= {statement}
//    statement ::= "PRINT" (expression | string) nl
//            | "IF" comparison "THEN" nl {statement} "ENDIF" nl
//            | "WHILE" comparison "REPEAT" nl {statement} "ENDWHILE" nl
//            | "LABEL" ident nl
//            | "GOTO" ident nl
//            | "LET" ident "=" expression nl
//            | "INPUT" ident nl
//    comparison ::= expression (("==" | "!=" | ">" | ">=" | "<" | "<=") expression)+
//    expression ::= term {( "-" | "+" ) term}
//    term ::= unary {( "/" | "*" ) unary}
//    unary ::= ["+" | "-"] primary
//    primary ::= number | ident
//    nl ::= '\n'+

    Program program() {
        debug("PROGRAM");
        Program p = new Program(new ArrayList<Stm>());

        while (checkToken(TipoToken.QUEBRA_LINHA)) {
            nextToken();
        }

        while (!checkToken(TipoToken.EOF)) {
            Stm s = statement();
            p.addStatement(s);
        }

        return p;
    }

    Stm statement() {
        Stm s = null;
        if (checkToken(TipoToken.PRINT)) {
            debug("STM-PRINT");
            nextToken();
            Exp exp = null;
            if (checkToken(TipoToken.STRING)) {
                debug("STRING-EXP");
                exp = new StringExp(curToken.lexema);
                nextToken();
            } else {
                exp = expression();
            }
            s = new PrintStm(exp);
        } else if (checkToken(TipoToken.IF)) {
            debug("STM-IF");
            nextToken();
            BooleanExp booleanExp = comparison();
            match(TipoToken.THEN);
            nl();
            List<Stm> stmList = new ArrayList<>();
            while (!checkToken(TipoToken.ENDIF)) {
                Stm stm = statement();
                stmList.add(stm);
            }
            match(TipoToken.ENDIF);
            s = new IfStm(booleanExp, stmList);
        } else if (checkToken(TipoToken.WHILE)) {
            debug("STM-WHILE");
            nextToken();
            BooleanExp booleanExp = comparison();
            match(TipoToken.REPEAT);
            nl();
            List<Stm> stmList = new ArrayList<>();
            while (!checkToken(TipoToken.ENDWHILE)) {
                Stm stm = statement();
                stmList.add(stm);
            }
            match(TipoToken.ENDWHILE);
            s = new WhileStm(booleanExp, stmList);
        } else if (checkToken(TipoToken.LABEL)) {
            debug("STM-LABEL");
            nextToken();
            if (checkToken(TipoToken.ID)) {
                s = new LabelStm(curToken.lexema);
            }
            match(TipoToken.ID);
        } else if (checkToken(TipoToken.GOTO)) {
            debug("STM-GOTO");
            nextToken();
            if (checkToken(TipoToken.ID)) {
                s = new GotoStm(curToken.lexema);
            }
            match(TipoToken.ID);
        } else if (checkToken(TipoToken.LET)) {
            debug("STM-LET");
            nextToken();
            if (checkToken(TipoToken.ID)) {
                String id = curToken.lexema;
                nextToken();
                match(TipoToken.ATRIBUICAO);
                Exp e = expression();
                s = new AssignStm(id, e);
            }
        } else if (checkToken(TipoToken.INPUT)) {
            debug("STM-INPUT");
            nextToken();
            if (checkToken(TipoToken.ID)) {
                s = new InputStm(curToken.lexema);
            }
            match(TipoToken.ID);
        } else {
            abort("Statement inválido: " + curToken.lexema + " (" + curToken.tipo.name() + ")");
        }

        nl();

        return s;
    }

    void nl() {
        debug("NEWLINE");
        match(TipoToken.QUEBRA_LINHA);
        while (checkToken(TipoToken.QUEBRA_LINHA)) {
            nextToken();
        }
    }


    BooleanExp comparison() {
        debug("COMPARISON");
        Exp e_l = expression();
        BooleanExp booleanExp = null;
        if (checkToken(TipoToken.MAIOR_QUE)) {
            nextToken();
            Exp e_r = expression();
            booleanExp = new GreatherThanExp(e_l, e_r);
        } else if (checkToken(TipoToken.MAIOR_QUE_OU_IGUAL)) {
            nextToken();
            Exp e_r = expression();
            booleanExp = new GreatherThanEqualsExp(e_l, e_r);
        } else if (checkToken(TipoToken.MENOR_QUE)) {
            nextToken();
            Exp e_r = expression();
            booleanExp = new LessThanExp(e_l, e_r);
        } else if (checkToken(TipoToken.MENOR_QUE_OU_IGUAL)) {
            nextToken();
            Exp e_r = expression();
            booleanExp = new LessThanEqualsExp(e_l, e_r);
        } else if (checkToken(TipoToken.IGUAL_A)) {
            nextToken();
            Exp e_r = expression();
            booleanExp = new EqualsExp(e_l, e_r);
        } else if (checkToken(TipoToken.DIFERENTE_DE)) {
            nextToken();
            Exp e_r = expression();
            booleanExp = new NotEqualsExp(e_l, e_r);
        } else {
            abort("Esperava operador de comparacão em " + curToken.lexema);
        }

        //TODO loop para mais comparadores
//        while(isComparisonOperator()) {
//            nextToken();
//              expression();
//        }

        return booleanExp;
    }

    Exp expression() {
        debug("EXPRESSION");
        Exp t = term();
        Exp e = t;
        while (curToken.tipo == TipoToken.ADICAO || curToken.tipo == TipoToken.SUBTRACAO) {
            if (curToken.tipo == TipoToken.ADICAO) {
                nextToken();
                Exp t_2 = term();
                e = new SumExp(e, t_2);
            } else if (curToken.tipo == TipoToken.SUBTRACAO) {
                nextToken();
                Exp t_2 = term();
                e = new SubExp(e, t_2);
            }
        }

        return e;
    }

    Exp term() {
        debug("TERM");
        Exp t = unary();
        Exp e = t;
        while (curToken.tipo == TipoToken.MULTIPLICACAO || curToken.tipo == TipoToken.DIVISAO) {
            if (curToken.tipo == TipoToken.MULTIPLICACAO) {
                nextToken();
                Exp t_2 = term();
                e = new MulExp(e, t_2);
            } else if (curToken.tipo == TipoToken.DIVISAO) {
                nextToken();
                Exp t_2 = term();
                e = new DivExp(e, t_2);
            }
        }

        return e;
    }

    Exp unary() {
        debug("UNARY");
        //TODO introduzir expressões unárias
        return primary();
    }

    Exp primary() {
        debug("PRIMARY");
        Exp e = null;

        if (curToken.tipo == TipoToken.NUM) {
            Num num = (Num) curToken;
            nextToken();
            e = new NumExp(num.valor);
        } else if (curToken.tipo == TipoToken.ID) {
            e = new IdExp(curToken.lexema);
            nextToken();
        }
        //TODO introduzir parenteses
//        else if (curToken.tipo == TipoToken.PARENTESES_ESQ) {
//            match(TipoToken.PARENTESES_ESQ);
//            e = expression();
//            match(TipoToken.PARENTESES_DIR);
//        }
        else {
            abort("Token inesperado: " + curToken.lexema + " (" + curToken.tipo.name() + ")");
        }

        return e;
    }


    boolean isComparisonOperator() {
        return checkToken(TipoToken.MAIOR_QUE)
                || checkToken(TipoToken.MAIOR_QUE_OU_IGUAL)
                || checkToken(TipoToken.MENOR_QUE)
                || checkToken(TipoToken.MENOR_QUE_OU_IGUAL)
                || checkToken(TipoToken.IGUAL_A)
                || checkToken(TipoToken.DIFERENTE_DE);
    }

    void debug(String s) {
        if (debugModeOn) {
            System.out.println(s);
        }
    }

}
