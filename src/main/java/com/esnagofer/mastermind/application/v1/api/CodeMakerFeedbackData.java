package com.esnagofer.mastermind.application.v1.api;

/**
 * The Class CodeBreakerGuessPatternData.
 */
public class CodeMakerFeedbackData {

	/** The turns left. */
	public int turnsLeft;
	
	/** The message. */
	public String message;
	
	/** The key pegs. */
	public String[] keyPegs;
	
	/**
	 * Instantiates a new code maker feedback data.
	 *
	 * @param turnsLeft the this guess number
	 * @param message the message
	 * @param keyPegs the key peg
	 */
	protected CodeMakerFeedbackData(int turnsLeft, String message, String...keyPegs) {
		super();
		this.keyPegs = keyPegs;
		this.turnsLeft = turnsLeft;
		this.message = message;
	}

	/**
	 * New instance.
	 *
	 * @param turnsLeft the this guess number
	 * @param message the message
	 * @param keyPegs the key pegs
	 * @return the code maker feedback data
	 */
	public static CodeMakerFeedbackData newInstance(int turnsLeft, String message, String...keyPegs) {
		return new CodeMakerFeedbackData(turnsLeft, message, keyPegs);
	}

}
