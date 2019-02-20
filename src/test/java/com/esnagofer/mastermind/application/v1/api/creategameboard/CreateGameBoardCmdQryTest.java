package com.esnagofer.mastermind.application.v1.api.creategameboard;

import org.junit.Assert;
import org.junit.Test;

import com.esnagofer.mastermind.application.v1.api.creategameboard.CreateGameBoardCmdQry;

/**
 * The Class CreateGameBoardCmdQryTest.
 */
public class CreateGameBoardCmdQryTest {

	/**
	 * Should create create game board cmd qry.
	 */
	@Test
	public void shouldCreateCreateGameBoardCmdQry() {
		CreateGameBoardCmdQry cmdQry = CreateGameBoardCmdQry.newInstance();
		Assert.assertNotNull(cmdQry);
	}
	
}
