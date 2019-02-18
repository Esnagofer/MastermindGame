/**
 * 
 */
package com.esnagofer.lib.ddd.infrastrucutre.adapter.rest.jaxrs;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.esnagofer.mastermind.application.v1.api.BadRequestException;

/**
 * The Class BadRequestExceptionMapper.
 */
@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

	/**
	 * Instantiates a new bad request exception mapper.
	 */
	public BadRequestExceptionMapper() {
		super();
	}

	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(BadRequestException exception) {
		return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
	}

}
