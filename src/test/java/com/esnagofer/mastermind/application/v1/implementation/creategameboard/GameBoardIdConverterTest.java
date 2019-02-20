package com.esnagofer.mastermind.application.v1.implementation.creategameboard;

import org.junit.Assert;
import org.junit.Test;

import com.esnagofer.mastermind.application.v1.api.GameBoardIdData;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardId;

/**
 * The Class GameBoardIdConverterTest.
 */
public class GameBoardIdConverterTest {

	/**
	 * Should convert create game board id.
	 */
	@Test
	public void shouldConvertCreateGameBoardId() {
		GameBoardId gameBoardId = GameBoardId.newInstance("gameBoardId1");
		GameBoardIdData gameBoardIdData = GameBoardIdConverter.fromDomainToApplication(gameBoardId);
		Assert.assertNotNull(gameBoardIdData);
		Assert.assertEquals(gameBoardId.value(), gameBoardIdData.value);
	}

}
