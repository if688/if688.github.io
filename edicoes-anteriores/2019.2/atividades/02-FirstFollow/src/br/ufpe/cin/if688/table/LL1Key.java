package br.ufpe.cin.if688.table;

import br.ufpe.cin.if688.parsing.analysis.GeneralSymbol;
import br.ufpe.cin.if688.parsing.grammar.Nonterminal;

public class LL1Key {
    private final Nonterminal nonterminal;

    private final GeneralSymbol terminal;

    public LL1Key(Nonterminal nonterminal, GeneralSymbol terminal) {
        if (nonterminal == null || terminal == null)
            throw new NullPointerException();

        this.nonterminal = nonterminal;
        this.terminal = terminal;
    }

    @Override 
    public boolean equals(Object o) {
        if (!(o instanceof LL1Key)) return false;

        LL1Key other = (LL1Key) o;

        return terminal.equals(other.terminal) &&
               nonterminal.equals(other.nonterminal);
    }

    @Override 
    public int hashCode() {
        return 31 * nonterminal.hashCode() + terminal.hashCode();
    }

    @Override 
    public String toString() {
        return "(" + nonterminal + ", " + terminal + ")";
    }

}
