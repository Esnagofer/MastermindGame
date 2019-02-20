package com.esnagofer.mastermind.application.v1.api.trytoguesssecretpattern;

import org.junit.Assert;
import org.junit.Test;

import com.esnagofer.mastermind.application.v1.api.CodeBreakerGuessPatternData;
import com.esnagofer.mastermind.application.v1.api.GameBoardIdData;
import com.esnagofer.mastermind.application.v1.api.trytoguesssecretpattern.TryToGuessSecretPatternCmdQry;

/**
 * The Class TryToGuessSecretPatternCmdQryTest.
 */
public class TryToGuessSecretPatternCmdQryTest {

	/** The Constant gameBoardIdData. */
	private static final GameBoardIdData gameBoardIdData = GameBoardIdData.newInstance("gameBoardIdData1");

	/** The Constant codeBreakerGuessPatternData. */
	private static final CodeBreakerGuessPatternData codeBreakerGuessPatternData = CodeBreakerGuessPatternData.newInstance(
		"RED", 
		"BLUE", 
		"YELLOW", 
		"BROWN"
	);

	/**
	 * Should create create game board cmd qry.
	 */
	@Test
	public void shouldCreateCreateGameBoardCmdQry() {
		TryToGuessSecretPatternCmdQry cmdQry = TryToGuessSecretPatternCmdQry.newInstance(
			gameBoardIdData,
			codeBreakerGuessPatternData
		);
		Assert.assertNotNull(cmdQry);
		Assert.assertNotNull(cmdQry.gameBoardIdData());
		Assert.assertNotNull(cmdQry.codeBerakerGuessPatternData());
	}

	/**
	 * Should fail create create game board cmd qry whitout game board data id.
	 */
	@Test(expected=IllegalStateException.class)
	public void shouldFailCreateCreateGameBoardCmdQryWhitoutGameBoardDataId() {
		TryToGuessSecretPatternCmdQry.newInstance(
			null,
			codeBreakerGuessPatternData
		);
	}

	/**
	 * Should fail create create game board cmd qry whitout guess secret pattern.
	 */
	@Test(expected=IllegalStateException.class)
	public void shouldFailCreateCreateGameBoardCmdQryWhitoutGuessSecretPattern() {
		TryToGuessSecretPatternCmdQry.newInstance(
			gameBoardIdData,
			null
		);
	}

}
