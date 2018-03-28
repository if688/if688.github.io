package br.ufpe.cin.if688.parsing.analysis;

public final class SpecialSymbol extends GeneralSymbol {
    public static SpecialSymbol EPSILON = new SpecialSymbol("\u03B5");

    public static SpecialSymbol EOF = new SpecialSymbol("$");

    private final String name;
    
    private SpecialSymbol(String name) {
        this.name = name;
    }

    @Override 
    public String toString() {
        return name.toString();
    }
} 
