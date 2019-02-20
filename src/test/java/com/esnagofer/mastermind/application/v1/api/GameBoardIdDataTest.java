package com.esnagofer.mastermind.application.v1.api;

import org.junit.Assert;
import org.junit.Test;

import com.esnagofer.mastermind.application.v1.api.GameBoardIdData;

/**
 * The Class GameBoardIdDataTest.
 */
public class GameBoardIdDataTest {

	/**
	 * Should create game board id data.
	 */
	@Test
	public void shouldCreateGameBoardIdData() {
		GameBoardIdData gameBoardIdData = GameBoardIdData.newInstance("gameBoardIdData1");
		Assert.assertNotNull(gameBoardIdData);
	}
	
}
