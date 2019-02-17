/**
 * 
 */
package com.esnagofer.lib.ddd.domain.model.repository;

/**
 * The Class RepositoryException.
 */
public class RepositoryException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2006876344905911958L;

	/**
	 * Instantiates a new repository exception.
	 */
	public RepositoryException() {
	}

	/**
	 * Instantiates a new repository exception.
	 *
	 * @param message the message
	 */
	public RepositoryException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new repository exception.
	 *
	 * @param cause the cause
	 */
	public RepositoryException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new repository exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new repository exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public RepositoryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
