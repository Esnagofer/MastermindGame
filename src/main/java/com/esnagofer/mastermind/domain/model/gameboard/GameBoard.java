package com.esnagofer.mastermind.domain.model.gameboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import com.esnagofer.lib.Validate;
import com.esnagofer.lib.ddd.domain.model.core.DomainEntity;
import com.esnagofer.mastermind.domain.model.codemaker.CodeMakerSecretPattern;
import com.esnagofer.mastermind.domain.model.gameboard.exception.GameBoardAlreadyHaveAWinnerException;
import com.esnagofer.mastermind.domain.model.gameboard.exception.GameBoardIsEmptyException;
import com.esnagofer.mastermind.domain.model.gameboard.exception.GameBoardIsFullException;

/**
 * The Class GameBoard.
 */
public class GameBoard extends DomainEntity<GameBoardId> {

	/** The Constant ROWS. */
	public static final int ROWS = 12;
	
	/** The secret pattern. */
	private CodeMakerSecretPattern secretPattern;

	/** The guess log. */
	private List<GameBoardGuessLogItem> guessLog;

	/**
	 * Instantiates a new game board.
	 *
	 * @param builder the builder
	 */
	@Generated("SparkTools")
	private GameBoard(Builder builder) {
		super(builder.id);
		transferState(builder);
		validateInvariants();
	}

	/**
	 * Validate state.
	 */
	private void validateInvariants() {
		Validate.thatIsNotNull("GameSecretPattern: 'id' not set", id);
		Validate.thatIsNotNull("GameSecretPattern: 'GameSecretPattern' not set", secretPattern);
	}

	/**
	 * Transfer state.
	 *
	 * @param builder the builder
	 */
	private void transferState(Builder builder) {
		this.id = builder.id;
		this.secretPattern = builder.secretPattern;
		guessLog = new ArrayList<>();
	}
	
	/**
	 * Check that can log guess item.
	 */
	private void checkThatLogGuessIsNotFull() {
		if (isLogGuessFull()) {
			throw new GameBoardIsFullException();
		}
	}

	/**
	 * Check that thereisnt winner.
	 */
	private void checkThatThereisntWinner() {
		if (isThereWinner()) {
			throw new GameBoardAlreadyHaveAWinnerException();
		}
	}

	/**
	 * Check that can get last log guess item.
	 */
	private void checkLogGuessIsNotEmptyItem() {
		if (isLogGuessEmpty()) {
			throw new GameBoardIsEmptyException();
		}
	}

	/**
	 * Check that can log another guess.
	 */
	public void checkThatCanLogAnotherGuess() {
		checkThatLogGuessIsNotFull();
		checkThatThereisntWinner();
	}

	/**
	 * Turns left.
	 *
	 * @return the int
	 */
	public int turnsLeft() {
		return ROWS - guessLog().size() - 1;
	}
	
	/**
	 * Secret pattern.
	 *
	 * @return the game secret pattern
	 */
	public CodeMakerSecretPattern secretPattern() {
		return secretPattern;
	}
	
	/**
	 * Checks if is log guess full.
	 *
	 * @return true, if is log guess full
	 */
	public boolean isLogGuessFull() {
		return guessLog.size() == ROWS;
	}

	/**
	 * Checks if is log guess empty.
	 *
	 * @return true, if is log guess empty
	 */
	public boolean isLogGuessEmpty() {
		return guessLog.size() == 0;
	}

	/**
	 * Checks if is there winner.
	 *
	 * @return true, if is there winner
	 */
	public boolean isThereWinner() {
		if (!isLogGuessEmpty()) {
			GameBoardGuessLogItem lastLogGuess = lastLogGuess();
			return lastLogGuess.codeMakerFeedback().isWinner();
		}
		return false;
	}
	
	/**
	 * Log guess.
	 *
	 * @param gameBoardGuessLogItem the game board guess log item
	 */
	public void logGuess(GameBoardGuessLogItem gameBoardGuessLogItem) {
		checkThatCanLogAnotherGuess();
		guessLog.add(gameBoardGuessLogItem);
	}

	/**
	 * Last log guess.
	 *
	 * @return the game board guess log item
	 */
	public GameBoardGuessLogItem lastLogGuess() {
		checkLogGuessIsNotEmptyItem();
		return guessLog.get(guessLog.size() - 1);
	}

	/**
	 * Guess log.
	 *
	 * @return the list
	 */
	public List<GameBoardGuessLogItem> guessLog(){
		return Collections.unmodifiableList(guessLog);
	}
	
	/**
	 * Creates builder to build {@link GameBoard}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link GameBoard}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		
		/** The id. */
		private GameBoardId id;
		
		/** The secret pattern. */
		private CodeMakerSecretPattern secretPattern;

		/**
		 * Instantiates a new builder.
		 */
		private Builder() {
		}

		/**
		 * With id.
		 *
		 * @param id the id
		 * @return the builder
		 */
		public Builder withId(GameBoardId id) {
			this.id = id;
			return this;
		}

		/**
		 * With secret pattern.
		 *
		 * @param secretPattern the secret pattern
		 * @return the builder
		 */
		public Builder withSecretPattern(CodeMakerSecretPattern secretPattern) {
			this.secretPattern = secretPattern;
			return this;
		}

		/**
		 * Builds the.
		 *
		 * @return the game board
		 */
		public GameBoard build() {
			return new GameBoard(this);
		}
	}
	
}
