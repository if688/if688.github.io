package br.ufpe.cin.if688;

import br.ufpe.cin.if688.parsing.analysis.GeneralSymbol;
import br.ufpe.cin.if688.parsing.analysis.SpecialSymbol;
import br.ufpe.cin.if688.parsing.grammar.Grammar;
import br.ufpe.cin.if688.parsing.grammar.Nonterminal;
import br.ufpe.cin.if688.parsing.grammar.Production;
import br.ufpe.cin.if688.parsing.grammar.Terminal;
import br.ufpe.cin.if688.table.NotLL1Exception;
import br.ufpe.cin.if688.table.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Nao mexa aqui, so envie no Iudex

public class Main {
    public static void main(String[] args) {
        List<Production> ps = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String rule = scanner.nextLine();
                String[] hs = Arrays.stream(rule.split("->"))
                        .map(String::trim)
                        .collect(Collectors.toList())
                        .toArray(new String[]{});

                Nonterminal lhs = new Nonterminal(hs[0]);
                List<GeneralSymbol> rhs = Arrays.stream(hs[1].split(""))
                        .map(s -> {
                            char c = s.charAt(0);
                            if (c == '^')
                                return SpecialSymbol.EPSILON;
                            if (c == '$')
                                return SpecialSymbol.EOF;
                            if ('A' <= c && c <= 'Z')
                                return new Nonterminal(s);
                            return new Terminal(s);
                        })
                        .collect(Collectors.toList());

                Production p = new Production(lhs, rhs);
                ps.add(p);
            }
        }
        Grammar g = new Grammar(ps, ps.get(0).getNonterminal());

        try {
            Table.createTable(g);
        } catch (NotLL1Exception e) {
            throw new RuntimeException(e);
        }
    }
}
