package com.esnagofer.mastermind.domain.model.codemaker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.esnagofer.lib.Validate;
import com.esnagofer.lib.ddd.domain.model.FiniteImmutableSet;
import com.esnagofer.mastermind.domain.model.codebreaker.CodeBreakerGuessPattern;
import com.esnagofer.mastermind.domain.model.codepeg.CodePeg;
import com.esnagofer.mastermind.domain.model.keypeg.KeyPeg;
import com.esnagofer.mastermind.domain.model.keypeg.KeyPegBlack;
import com.esnagofer.mastermind.domain.model.keypeg.KeyPegWhite;

/**
 * The Class CodeMakerFeedback.
 */
public class CodeMakerFeedback extends FiniteImmutableSet<KeyPeg> {
	
	/** The turns left. */
	private int turnsLeft;
	
	/**
	 * Instantiates a new code maker feedback.
	 *
	 * @param elements the elements
	 * @param turnsLeft the this guess
	 */
	protected CodeMakerFeedback (List<KeyPeg> elements, int turnsLeft) {
		super(elements);
		this.turnsLeft = turnsLeft;
	}
	
	/* (non-Javadoc)
	 * @see com.esnagofer.lib.ddd.domain.model.FiniteImmutableSet#validateSize()
	 */
	@Override
	protected void validateSize() {
		if (elements.size() > 4) {
			throw new IllegalStateException("Max. 4 elements");
		}
	}

	/**
	 * Turns left.
	 *
	 * @return the int
	 */
	public int turnsLeft() {
		return turnsLeft;
	}

	/**
	 * Message.
	 *
	 * @return the string
	 */
	public String message() {
		if (isWinner()) {
			return "Game Over. Congratulations, you win!";
		} else {
			if (turnsLeft > 0) {
				return "Try again!"; 				
			}
			return "Game Over. You lose!"; 
		}
	}
	
	/**
	 * Checks if is winner.
	 *
	 * @return true, if is winner
	 */
	public boolean isWinner() {
		if (elements.size() != 4) return false;
		return (elements.stream()
			.filter(keyPeg -> keyPeg.isGuessed())
			.collect(Collectors.toList())
			.size()
		) == 4;
	}
	
	/**
	 * New instance.
	 *
	 * @param codeMakerSecretPattern the code maker secret pattern
	 * @param codeBreakerGuessPattern the code breaker guess pattern
	 * @param turnsLeft the this guess number
	 * @return the code maker feedback
	 */
	public static CodeMakerFeedback newInstance(
		CodeMakerSecretPattern codeMakerSecretPattern, 
		CodeBreakerGuessPattern codeBreakerGuessPattern,
		Integer turnsLeft
	) {
		Validate.thatIsNotNull("CodeMakerFeedBack: 'codeMakerSecretPattern' not set", codeMakerSecretPattern);
		Validate.thatIsNotNull("CodeMakerFeedBack: 'codeMakerSecretPattern' not set", codeBreakerGuessPattern);
		Validate.thatIsNotNull("CodeMakerFeedBack: 'turnsLeft' not set", turnsLeft);
		Validate.custom("", turnsLeft, value -> {
			return turnsLeft >= 0;
		});
		List<KeyPeg> result = new ArrayList<>();
		int index = 0;
		for (CodePeg thisCodePeg: codeMakerSecretPattern.elements()){
			if (codeBreakerGuessPattern.elements().get(index).equals(thisCodePeg)) {
				result.add(KeyPegBlack.newInstance());
			} else {
				if (codeBreakerGuessPattern.elements().contains(thisCodePeg)) {
					result.add(KeyPegWhite.newInstance());					
				}
			}
			index++;
		}		
		return new CodeMakerFeedback(result, turnsLeft);
	}
	
}
