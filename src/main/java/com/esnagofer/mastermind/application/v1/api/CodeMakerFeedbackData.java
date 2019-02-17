package com.esnagofer.mastermind.application.v1.api;

/**
 * The Class CodeBreakerGuessPatternData.
 */
public class CodeMakerFeedbackData {

	/** The key pegs. */
	public String[] keyPegs;
	
	/**
	 * Instantiates a new code maker feedback data.
	 *
	 * @param keyPegs the key peg
	 */
	protected CodeMakerFeedbackData(String...keyPegs) {
		super();
		this.keyPegs = keyPegs;
	}

	/**
	 * New instance.
	 *
	 * @param keyPegs the key pegs
	 * @return the code maker feedback data
	 */
	public static CodeMakerFeedbackData newInstance(String...keyPegs) {
		return new CodeMakerFeedbackData(keyPegs);
	}

}
