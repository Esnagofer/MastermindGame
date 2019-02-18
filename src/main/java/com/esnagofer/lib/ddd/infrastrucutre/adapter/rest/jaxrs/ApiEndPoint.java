package com.esnagofer.lib.ddd.infrastrucutre.adapter.rest.jaxrs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.Response;

import com.esnagofer.mastermind.application.v1.api.BadRequestException;

/**
 * The Class ApiEndPoint.
 */
public class ApiEndPoint {

	/** The exception mapping. */
	private static Map<Class<?>, Response.Status> exceptionMapping;
	
	/**
	 * Mappings.
	 *
	 * @return the map
	 */
	private Map<Class<?>, Response.Status> mappings() {
		if (exceptionMapping == null) {
			synchronized (this) {
				if (exceptionMapping == null) {
					exceptionMapping = new HashMap<>();
					exceptionMapping.put(BadRequestException.class, Response.Status.BAD_REQUEST);
				}
			}
		}
		return exceptionMapping;
	}
	
	/**
	 * Finalize with exception.
	 * 
	 * Parece que el Mapping de Exceptions <--> StatusCode de Jax-RS no acaba
	 * de funcionar (ver todas las *ExceptionMapper classes) -> lo haremos "a mano"
	 *
	 * @param asyncResponse the async response
	 * @param exception the e
	 */
	protected void finalizeWithException(AsyncResponse asyncResponse, Exception exception) {
		if (mappings().containsKey(exception.getClass())) {
			asyncResponse.resume(
				Response.status(mappings().get(exception.getClass()))
				.entity(exception.getMessage())
				.build()
			);
		} else {
			asyncResponse.resume(exception);
		}
	}
	
}
