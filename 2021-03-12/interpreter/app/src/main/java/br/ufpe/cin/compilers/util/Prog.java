package br.ufpe.cin.compilers.util;

import br.ufpe.cin.compilers.ast.*;

//@formatter:off
public class Prog {

    public static String testPrints = "PRINT \"hello, world!\"\n" +
            "PRINT \"second line\"\n" +
            "PRINT \"and a third...\"\n";

    public static String simpler = "PRINT \"Simple program\"\n" +
            "PRINT \"\"\n" +
            "\n" +
            "LET a = 5\n" +
            "LET b = 3\n" +
            "PRINT a\n" +
            "PRINT b\n";

    public static String simple = "PRINT \"Simple program\"\n" +
            "PRINT \"\"\n" +
            "\n" +
            "LET a = 2\n" +
            "LET b = 3\n" +
            "LET c = a+b\n" +
            "PRINT a\n" +
            "PRINT b\n" +
            "PRINT c\n";

    public static String fibonacci = "PRINT \"How many fibonacci numbers do you want?\"\n" +
            "INPUT nums\n" +
            "PRINT \"\"\n" +
            "\n" +
            "LET a = 0\n" +
            "LET b = 1\n" +
            "WHILE nums > 0 REPEAT\n" +
            "    PRINT a\n" +
            "    LET c = a + b\n" +
            "    LET a = b\n" +
            "    LET b = c\n" +
            "    LET nums = nums - 1\n" +
            "ENDWHILE\n";
/*
    // a=5+3; b=(print(a,a-1),10*a); print(b)
    public static Stm prog =
            new CompoundStm(
                    new AssignStm(
                            "a",
                            new OpExp(
                                    new NumExp(5),
                                    OpExp.Plus, new NumExp(3)
                            )
                    ),
                    new CompoundStm(
                            new AssignStm(
                                    "b",
                                    new EseqExp(
                                            new PrintStm(
                                                    new PairExpList(
                                                            new IdExp("a"),
                                                            new LastExpList(
                                                                    new OpExp(
                                                                            new IdExp("a"),
                                                                            OpExp.Minus,
                                                                            new NumExp(1)
                                                                    )
                                                            )
                                                    )
                                            ),
                                            new OpExp(
                                                    new NumExp(10),
                                                    OpExp.Times,
                                                    new IdExp("a")
                                            )
                                    )
                            ),
                            new PrintStm(
                                    new LastExpList(
                                            new IdExp("b")
                                    )
                            )
                    )
            );

    // print(4)
    public static Stm print =
            new PrintStm(
                    new LastExpList(
                            new NumExp(4)
                    )
            );

    // print(0,1,2,3,4)
    public static Stm print1234 =
            new PrintStm(
                    new PairExpList(
                            new NumExp(0),
                            new PairExpList(
                                    new NumExp(1),
                                    new PairExpList(
                                            new NumExp(2),
                                            new PairExpList(
                                                    new NumExp(3),
                                                    new LastExpList(
                                                            new NumExp(4)
                                                    )
                                            )
                                    )
                            )
                    )
            );

    // print(print(0,1,2,3,4),5)
    public static Stm printPrint =
            new PrintStm(
                    new LastExpList(
                            new EseqExp(
                                    print1234,
                                    new NumExp(5)
                            )
                    )
            );

    //a=512+3; print(a-3)
    public static Stm prog2 = new CompoundStm(
            new AssignStm(
                    "a",
                    new OpExp(
                            new NumExp(512),
                            OpExp.Plus,
                            new NumExp(3)
                    )
            ),
            new PrintStm(
                    new LastExpList(
                            new OpExp(
                                    new IdExp("a"),
                                    OpExp.Minus,
                                    new NumExp(3)
                            )
                    )
            )
    );

    // a=512+3; a=515+3;
    public static Stm prog3 =
            new CompoundStm(
                    new AssignStm(
                            "a",
                            new OpExp(
                                    new NumExp(512),
                                    OpExp.Plus,
                                    new NumExp(3)
                            )
                    ),
                    new AssignStm(
                            "a",
                            new OpExp(
                                    new NumExp(515),
                                    OpExp.Plus,
                                    new NumExp(3)
                            )
                    )
            );

    //print( (a = 512,a) )
    public static Stm printEseqExp = new PrintStm(
            new LastExpList(
                    new EseqExp(
                            new AssignStm(
                                    "a",
                                    new NumExp(512)

                            ),
                            new IdExp("a")
                    )
            )
    );

    //b=32; print( b, (a=512; a/b) )
    public static Stm progEseqExp = new CompoundStm(
            new AssignStm(
                    "b",
                    new NumExp(32)
            ),
            new PrintStm(
                    new PairExpList(
                            new IdExp("b"),
                            new LastExpList(
                                    new EseqExp(
                                            new AssignStm(
                                                    "a",
                                                    new NumExp(512)
                                            ),
                                            new OpExp(
                                                    new IdExp("a"),
                                                    OpExp.Div,
                                                    new IdExp("b")
                                            )
                                    )
                            )
                    )
            )
    );

*/
}
