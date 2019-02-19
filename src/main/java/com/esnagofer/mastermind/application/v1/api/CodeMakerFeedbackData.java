package com.esnagofer.mastermind.application.v1.api;

/**
 * The Class CodeBreakerGuessPatternData.
 */
public class CodeMakerFeedbackData {

	/** The turns left. */
	public int turnsLeft;
	
	/** The guess log. */
	public String[] guessLog;
	
	/** The message. */
	public String message;
	
	/** The key pegs. */
	public String[] keyPegs;
	
	/**
	 * Instantiates a new code maker feedback data.
	 *
	 * @param guessLog the guess log
	 * @param turnsLeft the this guess number
	 * @param message the message
	 * @param keyPegs the key peg
	 */
	protected CodeMakerFeedbackData(
		String[] guessLog,
		int turnsLeft, 
		String message, 
		String...keyPegs
	) {
		super();
		this.keyPegs = keyPegs;
		this.turnsLeft = turnsLeft;
		this.message = message;
		this.guessLog = guessLog;
	}

	/**
	 * New instance.
	 *
	 * @param guessLog the guess log
	 * @param turnsLeft the this guess number
	 * @param message the message
	 * @param keyPegs the key pegs
	 * @return the code maker feedback data
	 */
	public static CodeMakerFeedbackData newInstance(
		String[] guessLog,
		int turnsLeft, 
		String message, 
		String...keyPegs
	) {
		return new CodeMakerFeedbackData(guessLog, turnsLeft, message, keyPegs);
	}

}
