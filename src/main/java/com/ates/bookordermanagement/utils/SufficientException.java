package com.ates.bookordermanagement.utils;

public class SufficientException extends Exception {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SufficientException(String message) {
		super(message);
	}


	public SufficientException(Exception exception, String message) {
		super(message);
	}

}
