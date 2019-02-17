package com.esnagofer.lib.cqrs;

import com.esnagofer.lib.cqrs.commandquery.CommandQuery;

/**
 * The Interface InvokeCommandQuery.
 */
public interface InvokeCommandQuery<T extends CommandQuery<R>, R> {

	/**
	 * Invoke command query.
	 *
	 * @param <R> the generic type
	 * @param commandQuery the command query
	 * @param listener the listener
	 */
	public void invokeCommandQuery(T commandQuery, CommandQueryReturnTypeListener<R> listener);
	
}
