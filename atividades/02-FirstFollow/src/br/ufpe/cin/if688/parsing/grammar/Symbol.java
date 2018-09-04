package br.ufpe.cin.if688.parsing.grammar;

import br.ufpe.cin.if688.parsing.analysis.GeneralSymbol;

public abstract class Symbol extends GeneralSymbol {
    private final String name;

    private final boolean terminal;

    Symbol(String name, boolean isTerminal) {
        if (name == null || name.isEmpty())
            throw new RuntimeException("nome invalido: " + name);

        this.name = name;
        this.terminal = isTerminal;
    }

   
    public final boolean isTerminal() {
        return terminal;
    }

   
    public final String getName() {
        return name;
    }

    
    public int hashCode() {
        return 31 * name.hashCode() + (terminal? 1 : 0);
    }

    
    public boolean equals(Object o) {
        if (!(o instanceof Symbol)) return false;

        Symbol other = (Symbol) o;

        return terminal == other.terminal && name.equals(other.name);
    }

   
    public String toString() {
        if (terminal) return name;
        
        return "<" + name + ">";
    }
}
