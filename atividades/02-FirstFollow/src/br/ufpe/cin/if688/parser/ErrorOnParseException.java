package br.ufpe.cin.if688.parser;

public class ErrorOnParseException extends Exception {
	
	public ErrorOnParseException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ErrorOnParseException(Throwable cause) {
		super(cause);
	}
	
	public ErrorOnParseException(String message) {
		super(message);
	}
	
	public ErrorOnParseException() {
		super();
	}

}
