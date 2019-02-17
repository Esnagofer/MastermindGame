package com.esnagofer.mastermind.infrastructure.adapter.rest.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esnagofer.mastermind.domain.model.Jander;
import com.esnagofer.mastermind.domain.model.JanderSelector;

/**
 * The Class HelloWorldEndpoint.
 */
@Component
@Path("/hello")
public class HelloWorldEndpoint {
    
	/** The jander. */
	@Autowired
	@JanderSelector
	Jander jander;
	
    /**
     * Test.
     *
     * @return the string
     */
    @GET
    @Path("/world")
    public String test() {
        return "Hello world with injections Javax " + jander.getJander();
    }
    
	/**
	 * Gets the game board.
	 *
	 * @param asyncResponse the async response
	 * @return the game board
	 */
	@GET
	@Path("/gameboard")
	@Produces("application/json")
	public void getGameBoard(@Suspended final AsyncResponse asyncResponse) {
		asyncResponse.resume(
			Response.status(Response.Status.OK)
			.entity(jander.data())
			.build()
		);
	}
    
}
