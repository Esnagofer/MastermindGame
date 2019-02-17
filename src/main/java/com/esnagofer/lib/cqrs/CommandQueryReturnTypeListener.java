package com.esnagofer.lib.cqrs;

/**
 * The listener interface for receiving commandQueryReturnType events.
 * The class that is interested in processing a commandQueryReturnType
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addCommandQueryReturnTypeListener<code> method. When
 * the commandQueryReturnType event occurs, that object's appropriate
 * method is invoked.
 *
 * @param <R> the generic type
 * @see CommandQueryReturnTypeEvent
 */
@FunctionalInterface
public interface CommandQueryReturnTypeListener<R> {

	/**
	 * Notify result.
	 *
	 * @param result the result
	 */
	public void notifyResult(R result);
	
}
