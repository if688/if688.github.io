package br.ufpe.cin.if688.parsing.analysis;

public final class SpecialSymbol extends GeneralSymbol {

	public static SpecialSymbol EPSILON = new SpecialSymbol("^");

	public static SpecialSymbol EOF = new SpecialSymbol("$");

	private final String name;

	private SpecialSymbol(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SpecialSymbol)) {
			return false;
		}

		SpecialSymbol other = (SpecialSymbol) obj;

		return this.name.equals(other.name);
	}
}
