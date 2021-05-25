package br.ufpe.cin.compilers.symboltable;

import java.util.Map;

public class SymbolTable {

    private Map<String, Double> symbolTable;

    public SymbolTable(Map<String, Double> st) {
        symbolTable = st;
    }

    public boolean addVariable(String id, double value) {
        if (containsVariable(id)) {
            return false;
        } else {
            symbolTable.put(id, value);
            return true;
        }
    }

    public boolean updateVariable(String id, double value) {
        symbolTable.put(id, value);
        return true;
    }

    public Double getValue(String id) {
        return symbolTable.get(id);
    }

    public boolean containsVariable(String id) {
        return symbolTable.containsKey(id);
    }
}
