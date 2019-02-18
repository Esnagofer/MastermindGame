package com.esnagofer.mastermind.domain.model.gameboard;

import org.junit.Assert;
import org.junit.Test;

import com.esnagofer.mastermind.domain.model.codebreaker.CodeBreakerGuessPattern;
import com.esnagofer.mastermind.domain.model.codemaker.CodeMakerFeedback;
import com.esnagofer.mastermind.domain.model.codemaker.CodeMakerSecretPattern;
import com.esnagofer.mastermind.domain.model.codepeg.CodePegColor;

/**
 * The Class GameBoardGuessLogItemTest.
 */
public class GameBoardGuessLogItemTest {

	/**
	 * Should create game board guess log item.
	 */
	@Test
	public void shouldCreateGameBoardGuessLogItem() {
		CodeBreakerGuessPattern codeBreakerGuessPattern = GameBoardData.createCodeBreakerGuessPattern(CodePegColor.BLACK);
		CodeMakerSecretPattern codeMakerSecretPattern = GameBoardData.createCodeMakerSecretPattern(CodePegColor.RED);
		CodeMakerFeedback codeMakerFeedback = CodeMakerFeedback.newInstance(codeMakerSecretPattern, codeBreakerGuessPattern, 1);
		GameBoardGuessLogItem gameBoardGuessLogItem = GameBoardGuessLogItem.newInstance(codeBreakerGuessPattern, codeMakerFeedback);
		Assert.assertNotNull(codeMakerFeedback);
		Assert.assertNotNull(gameBoardGuessLogItem.codeBreakerGuessPattern());
		Assert.assertNotNull(gameBoardGuessLogItem.codeMakerFeedback());		
		Assert.assertEquals(codeBreakerGuessPattern, gameBoardGuessLogItem.codeBreakerGuessPattern());
		Assert.assertEquals(codeMakerFeedback, gameBoardGuessLogItem.codeMakerFeedback());
	}

	/**
	 * Should be two instances with same state equals.
	 */
	@Test
	public void shouldBeTwoInstancesWithSameStateEquals() {
		GameBoardGuessLogItem guessLogItem1 = GameBoardData.createGameBoardGuessLogItem(CodePegColor.RED, CodePegColor.RED);
		GameBoardGuessLogItem guessLogItem2 = GameBoardData.createGameBoardGuessLogItem(CodePegColor.RED, CodePegColor.RED);
		Assert.assertEquals(guessLogItem1, guessLogItem2);
	}

	/**
	 * Should be two instances with same state equals.
	 */
	@Test
	public void shouldBeTwoInstancesWithoutSameStateDiferents() {
		GameBoardGuessLogItem guessLogItem1 = GameBoardData.createGameBoardGuessLogItem(CodePegColor.RED, CodePegColor.RED);
		GameBoardGuessLogItem guessLogItem2 = GameBoardData.createGameBoardGuessLogItem(CodePegColor.RED, CodePegColor.BLUE);
		Assert.assertNotEquals(guessLogItem1, guessLogItem2);
	}

}
