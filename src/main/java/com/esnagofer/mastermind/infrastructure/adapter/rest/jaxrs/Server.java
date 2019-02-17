package com.esnagofer.mastermind.infrastructure.adapter.rest.jaxrs;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

@Path("/_server")
public class Server {
	
	/**
	 * Ping.
	 *
	 * @param ar the ar
	 */
	@GET
	@Path("/ping")
	@Produces("text/plain")
	public void ping(@Suspended AsyncResponse ar) {
		try {
			ar.resume(Response.ok((new Date()).getTime()).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
