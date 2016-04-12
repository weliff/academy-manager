package br.com.academyflash.business;

public class ArgumentoInvalidoException extends Exception{

	public ArgumentoInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ArgumentoInvalidoException(String message) {
		super(message);
	}
	
	

}
