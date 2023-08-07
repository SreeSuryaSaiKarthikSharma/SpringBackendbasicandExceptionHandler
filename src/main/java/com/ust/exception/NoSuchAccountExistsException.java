package com.ust.exception;

public class NoSuchAccountExistsException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public NoSuchAccountExistsException(String message) {
		super();
		this.message = message;
	}
	
	public NoSuchAccountExistsException() {
		
	}

}
