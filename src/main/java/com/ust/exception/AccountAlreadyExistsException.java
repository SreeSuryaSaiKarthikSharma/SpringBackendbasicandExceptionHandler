package com.ust.exception;

public class AccountAlreadyExistsException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public AccountAlreadyExistsException(String message) {
		super();
		this.message = message;
	}
	
	public AccountAlreadyExistsException() {
		
	}

}
