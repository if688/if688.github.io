package br.ufpe.cin.if688.parsing.grammar;

import java.util.*;

import br.ufpe.cin.if688.parsing.analysis.GeneralSymbol;

public final class Production implements Iterable<GeneralSymbol> {

    private final Nonterminal nt;
    private final List<GeneralSymbol> production;

    public Production(Nonterminal nt, List<GeneralSymbol> production) {
        
        if (nt == null || production == null)
            throw new NullPointerException("Argumentos para producao nao podem ser nulos.");

        this.nt = nt;
        this.production = production;
    }

    public Nonterminal getNonterminal() {
        return nt;
    }

    public List<GeneralSymbol> getProduction() {
        return Collections.unmodifiableList(production);
    }

    public Iterator<GeneralSymbol> iterator() {
        return getProduction().iterator();
    }

    @Override 
    public String toString() {
        return nt + " -> " + production;
    }
} 
