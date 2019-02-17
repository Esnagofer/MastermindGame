package com.esnagofer.mastermind.domain.service.codemaker;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.esnagofer.lib.ddd.domain.model.event.DomainEventManager;
import com.esnagofer.mastermind.domain.model.codebreaker.CodeBreakerGuessPattern;
import com.esnagofer.mastermind.domain.model.codemaker.CodeMakerSecretPattern;
import com.esnagofer.mastermind.domain.model.codepeg.CodePeg;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoard;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardGuessLogItem;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardId;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardRepository;

/**
 * The Class CodeMakerTest.
 */
public class CodeMakerTest {

	/**
	 * Game board.
	 *
	 * @return the game board
	 */
	private GameBoard gameBoard() {
		return GameBoard.builder()
			.withId(GameBoardId.newInstance())
			.withSecretPattern(CodeMakerSecretPattern.newInstance())
		.build();
	}
	
	/**
	 * Code maker service.
	 *
	 * @return the code maker service
	 */
	private CodeMakerService codeMakerService() {
		GameBoardRepository gameBoardRepositoryMock = Mockito.mock(GameBoardRepository.class);
		Mockito.when(gameBoardRepositoryMock.get(Mockito.any())).thenReturn(gameBoard());
		DomainEventManager domainEventManagerMock = Mockito.mock(DomainEventManager.class);
		return new CodeMakerService(gameBoardRepositoryMock, domainEventManagerMock);
	}
	
	/**
	 * Should create game board.
	 */
	@Test
	public void shouldCreateGameBoard() {
		CodeMakerService codeMakerService = codeMakerService();
		Assert.assertNotNull(codeMakerService);
		GameBoardId gameBoardId = codeMakerService.createGameBoard();
		Assert.assertNotNull(gameBoardId);
	}

	/**
	 * Should guess secret pattern.
	 */
	@Test
	public void shouldGuessSecretPattern() {
		CodeMakerService codeMakerService = codeMakerService();
		Assert.assertNotNull(codeMakerService);
		GameBoardGuessLogItem gameBoardGuessLogItem = codeMakerService.tryToGuessSecretPattern(
			GameBoardId.newInstance(), 
			CodeBreakerGuessPattern.newInstance(
				CodePeg.newInstance(),
				CodePeg.newInstance(),
				CodePeg.newInstance(),
				CodePeg.newInstance()
			)
		);
		Assert.assertNotNull(gameBoardGuessLogItem);
	}

}
