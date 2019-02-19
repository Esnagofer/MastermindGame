package com.esnagofer.mastermind.domain.model.gameboard;

import com.esnagofer.lib.Validate;
import com.esnagofer.lib.ddd.domain.model.core.DomainValueObject;
import com.esnagofer.mastermind.domain.model.codebreaker.CodeBreakerGuessPattern;
import com.esnagofer.mastermind.domain.model.codemaker.CodeMakerFeedback;

/**
 * The Class GameBoardGuessLogItem.
 */
public class GameBoardGuessLogItem extends DomainValueObject {

	/** The code breaker guess pattern. */
	private CodeBreakerGuessPattern codeBreakerGuessPattern;
	
	/** The code maker feedback. */
	private CodeMakerFeedback codeMakerFeedback;

	/**
	 * Instantiates a new game board guess log item.
	 *
	 * @param codeBreakerGuessPattern the code breaker guess pattern
	 * @param codeMakerFeedback the code maker feedback
	 */
	protected GameBoardGuessLogItem (
		CodeBreakerGuessPattern codeBreakerGuessPattern, 
		CodeMakerFeedback codeMakerFeedback
	) {
		super();
		this.codeBreakerGuessPattern = codeBreakerGuessPattern;
		this.codeMakerFeedback = codeMakerFeedback;
		validateInvariants();
	}

	/**
	 * Validate invariants.
	 */
	private void validateInvariants() {
		Validate.thatIsNotNull("GameBoardGuessLogItem: 'codeBreakerGuessPattern' not set", codeBreakerGuessPattern);
		Validate.thatIsNotNull("GameBoardGuessLogItem: 'codeMakerFeedback' not set", codeMakerFeedback);		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codeBreakerGuessPattern.hashCode();
		result = prime * result + codeMakerFeedback.hashCode();
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (otherObject == null || !otherObject.getClass().isAssignableFrom(this.getClass())) return false;
		GameBoardGuessLogItem gameBoardGuessLogItemTest = GameBoardGuessLogItem.class.cast(otherObject);
		return 
			this.codeBreakerGuessPattern.equals(gameBoardGuessLogItemTest.codeBreakerGuessPattern) &&
			this.codeMakerFeedback.equals(gameBoardGuessLogItemTest.codeMakerFeedback);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("[%s - %s]", codeBreakerGuessPattern.toString(), codeMakerFeedback.toString());
	}

	/**
	 * Code breaker guess pattern.
	 *
	 * @return the code breaker guess pattern
	 */
	public CodeBreakerGuessPattern codeBreakerGuessPattern() {
		return codeBreakerGuessPattern;
	}
	
	/**
	 * Code maker feedback.
	 *
	 * @return the code maker feedback
	 */
	public CodeMakerFeedback codeMakerFeedback() {
		return codeMakerFeedback;
	}

	/**
	 * New instance.
	 *
	 * @param codeBreakerGuessPattern the code breaker guess pattern
	 * @param codeMakerFeedback the code maker feedback
	 * @return the game board guess log item
	 */
	public static GameBoardGuessLogItem newInstance(
		CodeBreakerGuessPattern codeBreakerGuessPattern, 
		CodeMakerFeedback codeMakerFeedback
	) {
		return new GameBoardGuessLogItem(codeBreakerGuessPattern, codeMakerFeedback);	
	}
	
}
