package com.esnagofer.mastermind.infrastructure.adapter.db.domain.model.gameboard.repository;

import org.junit.Assert;
import org.junit.Test;

import com.esnagofer.lib.ddd.domain.model.repository.NotFoundException;
import com.esnagofer.mastermind.domain.model.codemaker.CodeMakerSecretPattern;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoard;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardId;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardRepository;


/**
 * The Class GameBoardRepositoryTest.
 */
public class GameBoardRepositoryTest {
	
	/** The Constant gameBoardId. */
	private static final GameBoardId gameBoardId = GameBoardId.newInstance("id1");

	/** The Constant secretPattern. */
	private static final CodeMakerSecretPattern secretPattern = CodeMakerSecretPattern.newInstance();
	
	/**
	 * Should add and get game board.
	 */
	@Test
	public void shouldAddAndGetGameBoard() {
		GameBoardRepository repository = new GameBoardRepositoryImpl();
		GameBoard gameBoard = GameBoard.builder()
			.withId(gameBoardId)
			.withSecretPattern(secretPattern)
		.build();
		repository.add(gameBoard);
		Assert.assertTrue(repository.contains(gameBoardId));
		GameBoard gameBoardReaded = repository.get(gameBoardId);
		Assert.assertEquals(gameBoard, gameBoardReaded);
	}

	/**
	 * Should add and remove game board.
	 */
	@Test
	public void shouldAddAndRemoveGameBoard() {
		GameBoardRepository repository = new GameBoardRepositoryImpl();
		GameBoard gameBoard = GameBoard.builder()
			.withId(gameBoardId)
			.withSecretPattern(secretPattern)
		.build();
		repository.add(gameBoard);
		Assert.assertTrue(repository.contains(gameBoardId));
		repository.remove(gameBoardId);
		Assert.assertFalse(repository.contains(gameBoardId));
	 }

	/**
	 * Should fail get.
	 */
	@Test(expected=NotFoundException.class)
	public void shouldFailWhenGet() {
		GameBoardRepository repository = new GameBoardRepositoryImpl();
		repository.get(gameBoardId);
	 }

	/**
	 * Should fail when delete.
	 */
	@Test(expected=NotFoundException.class)
	public void shouldFailWhenDelete() {
		GameBoardRepository repository = new GameBoardRepositoryImpl();
		repository.remove(gameBoardId);
	 }

}
