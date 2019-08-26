package br.ufpe.cin.if688.parsing.grammar;

import java.util.*;

import br.ufpe.cin.if688.parsing.analysis.GeneralSymbol;
import br.ufpe.cin.if688.parsing.analysis.SpecialSymbol;


public final class Grammar implements Iterable<Production> {
   
    private final Collection<Production> productions;

    private final Set<Nonterminal> nonterminals = new HashSet<Nonterminal>();

    
    private final Set<Terminal> terminals = new HashSet<Terminal>();
    
    
    private final Set<SpecialSymbol> specialsymbols = new HashSet<SpecialSymbol>();

    
    private final Nonterminal start;

    
    public Grammar(Collection<Production> productions, Nonterminal start) {
        if (productions == null || start == null)
            throw new NullPointerException();

        this.productions = productions;
        this.start = start;

        
        for (Production p: productions) {
            nonterminals.add(p.getNonterminal());
            for (GeneralSymbol s: p.getProduction()) {
                if (s instanceof Nonterminal)
                    nonterminals.add((Nonterminal) s);
                else if (s instanceof Terminal)
                    terminals.add((Terminal) s);
                else
                	specialsymbols.add((SpecialSymbol) s);
                	
            }
        }
        nonterminals.add(start);
    }

    
    public Nonterminal getStartSymbol() {
        return start;
    }

    
    public Collection<Production> getProductions() {
        return Collections.unmodifiableCollection(productions);
    }

    
    public Iterator<Production> iterator() {
        return getProductions().iterator();
    }

    
    public Collection<Terminal> getTerminals() {
        return Collections.unmodifiableCollection(terminals);
    }

    
    public Collection<Nonterminal> getNonterminals() {
        return Collections.unmodifiableCollection(nonterminals);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Production p: this) {
            builder.append(p.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
} 