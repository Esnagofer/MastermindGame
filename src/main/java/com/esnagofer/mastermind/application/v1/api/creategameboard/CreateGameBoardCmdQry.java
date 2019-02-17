/**
 * 
 */
package com.esnagofer.mastermind.application.v1.api.creategameboard;

import com.esnagofer.lib.cqrs.commandquery.CommandQuery;
import com.esnagofer.mastermind.application.v1.api.GameBoardIdData;

/**
 * The Class CreateGameBoardCmdQry.
 */
public class CreateGameBoardCmdQry extends CommandQuery<GameBoardIdData> {

	/**
	 * Instantiates a new creates the game board cmd qry.
	 */
	protected CreateGameBoardCmdQry() {
		super(GameBoardIdData.class);
	}

	/**
	 * New instance.
	 *
	 * @return the creates the game board command
	 */
	public static CreateGameBoardCmdQry newInstance() {
		return new CreateGameBoardCmdQry();
	}
	
}
