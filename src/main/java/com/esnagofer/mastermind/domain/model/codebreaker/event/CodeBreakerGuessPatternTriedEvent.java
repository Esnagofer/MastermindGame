package com.esnagofer.mastermind.domain.model.codebreaker.event;

import com.esnagofer.lib.Validate;
import com.esnagofer.lib.ddd.domain.model.event.DomainEvent;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardGuessLogItem;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardId;

/**
 * The Class CodeBreakerGuessPatternTriedEvent.
 */
public class CodeBreakerGuessPatternTriedEvent extends DomainEvent {

	/** The game board id. */
	private GameBoardId gameBoardId;
	
	/** The game board guess log item. */
	private GameBoardGuessLogItem gameBoardGuessLogItem;

	/**
	 * Instantiates a new code breaker guess pattern tried event.
	 *
	 * @param gameBoardId the game board id
	 * @param gameBoardGuessLogItem the game board guess log item
	 */
	protected CodeBreakerGuessPatternTriedEvent(
		GameBoardId gameBoardId,
		GameBoardGuessLogItem gameBoardGuessLogItem
	) {
		super();
		this.gameBoardId = gameBoardId;
		this.gameBoardGuessLogItem = gameBoardGuessLogItem;
		validateInvariants();
	}
	
	/**
	 * Validate invariants.
	 */
	private void validateInvariants() {
		Validate.thatIsNotNull("GameBoardSecretPatternTriedEvent: 'gameBoardId' not set", gameBoardId);
		Validate.thatIsNotNull("GameBoardSecretPatternTriedEvent: 'gameBoardGuessLogItem' not set", gameBoardGuessLogItem);
	}

	/**
	 * Game board id.
	 *
	 * @return the game board id
	 */
	public GameBoardId gameBoardId() {
		return gameBoardId;
	}
	
	/**
	 * Game board guess log item.
	 *
	 * @return the game board guess log item
	 */
	public GameBoardGuessLogItem gameBoardGuessLogItem() {
		return gameBoardGuessLogItem;
	}
	
	/**
	 * New instance.
	 *
	 * @param gameBoardId the game board id
	 * @param gameBoardGuessLogItem the game board guess log item
	 * @return the game board secret pattern tried event
	 */
	public static CodeBreakerGuessPatternTriedEvent newInstance(
		GameBoardId gameBoardId,
		GameBoardGuessLogItem gameBoardGuessLogItem
	) {
		return new CodeBreakerGuessPatternTriedEvent(gameBoardId, gameBoardGuessLogItem);
	}
		
}
