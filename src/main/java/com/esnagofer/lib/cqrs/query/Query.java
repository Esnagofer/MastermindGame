package com.esnagofer.lib.cqrs.query;

/**
 * The Class Query.
 *
 * @param <T> the generic type
 */
public class Query<T> {

	/** The result type. */
	private Class<T> resultType;

	
	/**
	 * Result type.
	 *
	 * @return the class
	 */
	public Class<T> resultType() {
		return resultType;
	}
	
}