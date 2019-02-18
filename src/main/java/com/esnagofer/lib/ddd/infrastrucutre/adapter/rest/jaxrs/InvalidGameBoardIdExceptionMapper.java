/**
 * 
 */
package com.esnagofer.lib.ddd.infrastrucutre.adapter.rest.jaxrs;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.esnagofer.mastermind.application.v1.api.InvalidGameBoardIdException;

/**
 * The Class InvalidGameBoardIdExceptionMapper.
 */
@Provider
public class InvalidGameBoardIdExceptionMapper implements ExceptionMapper<InvalidGameBoardIdException> {

	/**
	 * Instantiates a new invalid game board id exception mapper.
	 */
	public InvalidGameBoardIdExceptionMapper() {
		super();
	}

	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(InvalidGameBoardIdException exception) {
		return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
	}

}
