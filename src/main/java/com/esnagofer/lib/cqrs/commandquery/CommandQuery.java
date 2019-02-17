package com.esnagofer.lib.cqrs.commandquery;

/**
 * The Class CommandQuery.
 * 
 * No es una implementaci�n final adecuada, se debe �nicamente a falta
 * de tiempo para una implementaci�n correcta �nicamente con CMD/QRY
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
