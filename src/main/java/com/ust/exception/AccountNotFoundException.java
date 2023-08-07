package com.ust.exception;

public class AccountNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public AccountNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	public AccountNotFoundException() {
		
	}

}
