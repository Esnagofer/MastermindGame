package com.esnagofer.mastermind.domain.model.gameboard;

import org.junit.Assert;
import org.junit.Test;

import com.esnagofer.mastermind.domain.model.codemaker.CodeMakerSecretPattern;
import com.esnagofer.mastermind.domain.model.codepeg.CodePegColor;
import com.esnagofer.mastermind.domain.model.gameboard.exception.GameBoardIsEmptyException;
import com.esnagofer.mastermind.domain.model.gameboard.exception.GameBoardIsFullException;

/**
 * The Class GameBoardTest.
 */
public class GameBoardTest {

	/**
	 * Creates the game board.
	 *
	 * @return the game board
	 */
	private GameBoard createGameBoard() {
		GameBoardId id = GameBoardId.newInstance("id1");
		CodeMakerSecretPattern secretPattern = CodeMakerSecretPattern.newInstance();
		GameBoard gameBoard = GameBoard.builder()
			.withId(id)
			.withSecretPattern(secretPattern)
		.build();
		return gameBoard;
	}
	
	/**
	 * Should create game board.
	 */
	@Test
	public void shouldCreateGameBoard() {
		GameBoard gameBoard = createGameBoard();
		Assert.assertNotNull(gameBoard);
		Assert.assertNotNull(gameBoard.secretPattern());
		Assert.assertNotNull(gameBoard.guessLog());
		Assert.assertEquals(0, gameBoard.guessLog().size());
		Assert.assertTrue(gameBoard.isLogGuessEmpty());
		Assert.assertFalse(gameBoard.isLogGuessFull());		
	}

	/**
	 * Should fails get last log when board is empty.
	 */
	@Test(expected=GameBoardIsEmptyException.class)
	public void shouldFailsGetLastLogWhenBoardIsEmpty() {
		GameBoard gameBoard = createGameBoard();
		Assert.assertNotNull(gameBoard);
		gameBoard.lastLogGuess();
	}
	
	/**
	 * Should log one guess.
	 */
	@Test
	public void shouldLogOneGuess() {
		GameBoard gameBoard = createGameBoard();
		GameBoardGuessLogItem gameBoardGuessLogItem = GameBoardData.createGameBoardGuessLogItem(CodePegColor.CYAN, CodePegColor.BLACK);
		Assert.assertEquals(0, gameBoard.guessLog().size());
		gameBoard.logGuess(gameBoardGuessLogItem);
		Assert.assertEquals(1, gameBoard.guessLog().size());		
		Assert.assertFalse(gameBoard.isLogGuessEmpty());
		Assert.assertFalse(gameBoard.isLogGuessFull());		
		Assert.assertFalse(gameBoard.isThereWinner());		
	}

	/**
	 * Should log guess.
	 */
	@Test
	public void shouldFullLogGuess() {
		GameBoard gameBoard = createGameBoard();
		GameBoardGuessLogItem gameBoardGuessLogItem = GameBoardData.createGameBoardGuessLogItem(CodePegColor.CYAN, CodePegColor.BLACK);			
		for (int i = 0; i < GameBoard.ROWS; i++) {
			gameBoard.logGuess(gameBoardGuessLogItem);
		}
		Assert.assertEquals(GameBoard.ROWS, gameBoard.guessLog().size());		
		Assert.assertFalse(gameBoard.isLogGuessEmpty());
		Assert.assertTrue(gameBoard.isLogGuessFull());		
		Assert.assertFalse(gameBoard.isThereWinner());		
	}

	/**
	 * Should fail when log guess on full log.
	 */
	@Test(expected=GameBoardIsFullException.class)
	public void shouldFailWhenLogGuessOnFullLog() {
		GameBoard gameBoard = createGameBoard();
		GameBoardGuessLogItem gameBoardGuessLogItem = GameBoardData.createGameBoardGuessLogItem(CodePegColor.CYAN, CodePegColor.BLACK);			
		for (int i = 0; i <= GameBoard.ROWS; i++) {
			gameBoard.logGuess(gameBoardGuessLogItem);
		}
	}

	/**
	 * Should win game.
	 */
	@Test
	public void shouldWinGame() {
		GameBoard gameBoard = createGameBoard();
		GameBoardGuessLogItem gameBoardGuessLogItem = GameBoardData.createGameBoardGuessLogItem(CodePegColor.BLACK, CodePegColor.BLACK);			
		gameBoard.logGuess(gameBoardGuessLogItem);
		Assert.assertTrue(gameBoard.isThereWinner());		
	}

}
