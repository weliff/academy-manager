package br.com.academyflash.dao;

public class ExecuteUpdateException extends Exception{

	public ExecuteUpdateException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExecuteUpdateException(String message) {
		super(message);
	}

}
