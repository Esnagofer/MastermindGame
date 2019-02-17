package com.esnagofer.mastermind.application.v1.api;

/**
 * The Class InvalidGameBoardIdException.
 */
public class InvalidGameBoardIdException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1068595748703515598L;

	/**
	 * Instantiates a new invalid game board id exception.
	 *
	 * @param string the string
	 */
	public InvalidGameBoardIdException(String string) {
		super(string);
	}
	
}
