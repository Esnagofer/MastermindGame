package com.esnagofer.mastermind.domain.model.gameboard;

import com.esnagofer.lib.ddd.domain.model.core.DomainIdentity;

/**
 * The Class GameBoardId.
 */
public class GameBoardId extends DomainIdentity {

	/**
	 * Instantiates a new game board id.
	 */
	protected GameBoardId() {
		super();
	}

	/**
	 * Instantiates a new game board id.
	 *
	 * @param id the id
	 */
	protected GameBoardId(String id) {
		super(id);
	}

	/**
	 * New instance.
	 *
	 * @param id the id
	 * @return the game board id
	 */
	public static GameBoardId newInstance(String id) {
		return new GameBoardId(id);
	}

	/**
	 * New instance.
	 *
	 * @return the game board id
	 */
	public static GameBoardId newInstance() {
		return new GameBoardId();
	}

}
