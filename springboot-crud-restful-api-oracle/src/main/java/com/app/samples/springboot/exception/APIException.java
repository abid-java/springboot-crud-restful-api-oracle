package com.app.samples.springboot.exception;

/**
 * The Class APIException.
 */
public class APIException extends RuntimeException{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new API exception.
	 *
	 * @param message the message
	 */
	public APIException(String message) {
		super(message);
	}

}
