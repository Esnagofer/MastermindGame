package com.esnagofer.lib.cqrs.commandquery;

/**
 * The Class CommandQuery.
 * 
 * No es una implementación final adecuada, se debe únicamente a falta
 * de tiempo para una implementación correcta únicamente con CMD/QRY
 *
 * @param <R> the generic type
 */
public class CommandQuery<R> {
	
	/** The return type. */
	private Class<R> returnType;
	
	/**
	 * Instantiates a new command query.
	 *
	 * @param queryReturnType the query return type
	 */
	protected CommandQuery(Class<R> queryReturnType) {
		super();
		this.returnType = queryReturnType;
	}

	/**
	 * Return type.
	 *
	 * @return the class
	 */
	public Class<R> returnType() {
		return returnType;
	}

	/**
	 * New instance.
	 *
	 * @param <R> the generic type
	 * @param returnType the query return type
	 * @return the command query
	 */
	public static <R> CommandQuery<R> newInstance(Class<R> returnType) {
		return new CommandQuery<>(returnType);
	}

}
