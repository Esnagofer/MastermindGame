package com.esnagofer.mastermind.infrastructure.adapter.rest.jaxrs.codemaker;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esnagofer.mastermind.application.v1.api.CodeBreakerGuessPatternData;
import com.esnagofer.mastermind.application.v1.api.GameBoardIdData;
import com.esnagofer.mastermind.application.v1.api.creategameboard.CreateGameBoardCmdQry;
import com.esnagofer.mastermind.application.v1.api.creategameboard.CreateGameBoardCmdQryInvocation;
import com.esnagofer.mastermind.application.v1.api.creategameboard.CreateGameBoardCmdQryInvocationSelector;
import com.esnagofer.mastermind.application.v1.api.trytoguesssecretpattern.TryToGuessSecretPatternCmdQry;
import com.esnagofer.mastermind.application.v1.api.trytoguesssecretpattern.TryToGuessSecretPatternCmdQryInvocation;
import com.esnagofer.mastermind.application.v1.api.trytoguesssecretpattern.TryToGuessSecretPatternCmdQryInvocationSelector;

/**
 * The Class CodeMakerApi.
 */
@Component
@Path("/mastermind/api/codemaker/v1")
public class CodeMakerApi {

	/** The invoke create game board cmd qry. */
	@Autowired
	@CreateGameBoardCmdQryInvocationSelector
	private CreateGameBoardCmdQryInvocation invokeCreateGameBoardCmdQry;
	
	/** The invoke try to guess secret pattern cmd qry. */
	@Autowired
	@TryToGuessSecretPatternCmdQryInvocationSelector
	private TryToGuessSecretPatternCmdQryInvocation invokeTryToGuessSecretPatternCmdQry;
	
	/**
	 * Creates the game board.
	 *
	 * @param asyncResponse the async response
	 * @return the game board
	 */
	@GET
	@Path("/gameboard")
	@Produces("application/json")
	public void getGameBoard(@Suspended final AsyncResponse asyncResponse) {
		CreateGameBoardCmdQry createGameBoardCmdQry = CreateGameBoardCmdQry.newInstance();
		try {
			invokeCreateGameBoardCmdQry.invokeCommandQuery(createGameBoardCmdQry, gameBoardIdData -> {
				asyncResponse.resume(
					Response.status(Response.Status.OK)
					.entity(gameBoardIdData)
					.build()
				);
			});			
		} catch (Exception e) {
			asyncResponse.resume(e);			
		}		
	}

	/**
	 * Try to guess secret pattern.
	 *
	 * @param asyncResponse the async response
	 * @param gameBoardId the game board id
	 * @param candidate the candidate
	 */
	@POST
	@Path("/gameboard/{gameBoardId}/try/guess/secret/pattern")
	@Consumes("application/json")
	@Produces("application/json")
	public void tryToGuessSecretPattern(
		@Suspended final AsyncResponse asyncResponse, 
		@PathParam("gameBoardId") String gameBoardId,
		CodeBreakerGuessPatternData codeBreakerGuessPatternData
	) {
		GameBoardIdData gameBoardIdData = GameBoardIdData.newInstance(gameBoardId);
		TryToGuessSecretPatternCmdQry tryToGuessSecretPatternCmdQry = TryToGuessSecretPatternCmdQry.newInstance(
			gameBoardIdData, 
			codeBreakerGuessPatternData
		);
		try {
			invokeTryToGuessSecretPatternCmdQry.invokeCommandQuery(tryToGuessSecretPatternCmdQry, codeMakerFeedbackData -> {
				asyncResponse.resume(
					Response.status(Response.Status.OK)
					.entity(codeMakerFeedbackData)
					.build()
				);
			});			
		} catch (Exception e) {
			asyncResponse.resume(e);			
		}		
	}
	
}
