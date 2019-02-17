package com.esnagofer.mastermind.domain.model.gameboard.event;

import com.esnagofer.lib.ddd.domain.model.event.DomainEvent;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardId;

/**
 * The Class GameBoardCreatedEvent.
 */
public class GameBoardCreatedEvent extends DomainEvent {

	/** The game board id. */
	private GameBoardId gameBoardId;

	/**
	 * Instantiates a new game board created event.
	 *
	 * @param gameBoardId the game board id
	 */
	protected GameBoardCreatedEvent(GameBoardId gameBoardId) {
		super();
		this.gameBoardId = gameBoardId;
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
	 * New instance.
	 *
	 * @param gameBoardId the game board id
	 * @return the game board created event
	 */
	public static GameBoardCreatedEvent newInstance(GameBoardId gameBoardId) {
		return new GameBoardCreatedEvent(gameBoardId);
	}
		
}
