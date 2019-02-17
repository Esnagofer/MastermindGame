package com.esnagofer.mastermind.application.v1.implementation.creategameboard;

import com.esnagofer.mastermind.application.v1.api.GameBoardIdData;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardId;

/**
 * The Class GameBoardIdConverter.
 */
public class GameBoardIdConverter {

	/**
	 * From domain to application.
	 *
	 * @param gameBoardId the game board id
	 * @return the game board id data
	 */
	public static GameBoardIdData fromDomainToApplication(GameBoardId gameBoardId) {
		return GameBoardIdData.newInstance(gameBoardId.value());
	}
	
}
