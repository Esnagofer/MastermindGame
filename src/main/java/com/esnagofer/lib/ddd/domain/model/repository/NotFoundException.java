/**
 * 
 */
package com.esnagofer.lib.ddd.domain.model.repository;


/**
 * The Class NotFoundException.
 */
public class NotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2006876344905911958L;

	/**
	 * Instantiates a new not found exception.
	 */
	public NotFoundException() {
	}

	/**
	 * Instantiates a new not found exception.
	 *
	 * @param message the message
	 */
	public NotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new not found exception.
	 *
	 * @param cause the cause
	 */
	public NotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public NotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
