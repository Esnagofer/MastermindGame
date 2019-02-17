package com.esnagofer.mastermind.application.v1.api;

/**
 * The Class GameBoardIdData.
 */
public class GameBoardIdData {

	/** The value. */
	public String value;

	/**
	 * Instantiates a new game board id data.
	 */
	protected GameBoardIdData() {
		super();
	}
	
	/**
	 * Instantiates a new game board id data.
	 *
	 * @param value the value
	 */
	protected GameBoardIdData(String value) {
		super();
		this.value = value;
	}
	
	/**
	 * New instance.
	 *
	 * @param value the value
	 * @return the game board id data
	 */
	public static GameBoardIdData newInstance(String value) {
		return new GameBoardIdData(value);
	}
	
}
