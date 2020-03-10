package br.ufpe.cin.if688.parsing.analysis;

 
public final class ConcreteSymbol extends GeneralSymbol {
   
    private final GeneralSymbol symbol;

    public ConcreteSymbol(GeneralSymbol s) {
        if (s == null) throw new NullPointerException();

        this.symbol = s;
    }

    public GeneralSymbol getSymbol() {
        return symbol;
    }

    @Override 
    public int hashCode() {
        return symbol.hashCode();
    }

    @Override 
    public boolean equals(Object o) {
        if (!(o instanceof ConcreteSymbol)) return false;

        return symbol.equals(((ConcreteSymbol)o).symbol);
    }

    @Override
    public String toString() {
        return symbol.toString();
    }
} 