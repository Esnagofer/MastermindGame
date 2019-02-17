package com.esnagofer.mastermind.application.v1.api;

/**
 * The Class BadRequestException.
 */
public class BadRequestException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 889453004642955368L;

	/**
	 * Instantiates a new bad request exception.
	 *
	 * @param string the string
	 */
	public BadRequestException(String string) {
		super(string);
	}
	
}
