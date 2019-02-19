package com.esnagofer.mastermind.domain.model.codemaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.esnagofer.lib.Validate;
import com.esnagofer.lib.ddd.domain.model.FiniteImmutableSet;
import com.esnagofer.mastermind.domain.model.codebreaker.CodeBreakerGuessPattern;
import com.esnagofer.mastermind.domain.model.codepeg.CodePeg;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardGuessLogItem;
import com.esnagofer.mastermind.domain.model.keypeg.KeyPeg;
import com.esnagofer.mastermind.domain.model.keypeg.KeyPegBlack;
import com.esnagofer.mastermind.domain.model.keypeg.KeyPegWhite;

/**
 * The Class CodeMakerFeedback.
 */
public class CodeMakerFeedback extends FiniteImmutableSet<KeyPeg> {
	
	/** The turns left. */
	private int turnsLeft;
	
	/** The guess log. */
	private List<GameBoardGuessLogItem> guessLog;
	
	/** The code maker secret pattern. */
	private String codeMakerSecretPattern;
	
	/**
	 * Instantiates a new code maker feedback.
	 *
	 * @param elements the elements
	 * @param turnsLeft the this guess
	 * @param guessLog the guess log
	 * @param codeMakerSecretPattern the code maker secret pattern
	 */
	protected CodeMakerFeedback (
		List<KeyPeg> elements, 
		int turnsLeft,
		List<GameBoardGuessLogItem> guessLog,
		String codeMakerSecretPattern
	) {
		super(elements);
		this.turnsLeft = turnsLeft;
		this.guessLog = guessLog;
		this.codeMakerSecretPattern = codeMakerSecretPattern;
		validateInvariants();
	}
	
	/**
	 * Validate invariants.
	 */
	private void validateInvariants() {
		Validate.thatIsNotNull("CodeMakerFeedback: 'turnsLeft' not set", turnsLeft);
		Validate.thatIsNotNull("CodeMakerFeedback: 'guessLog' not set", guessLog);		
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
			return String.format("Game Over. You lose!. The secret code was %s", codeMakerSecretPattern); 
		}
	}
	
	/**
	 * Guess log.
	 *
	 * @return the list
	 */
	public List<String> guessLog() {
		return guessLog.stream().map(Object::toString).collect(Collectors.toList());
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
	 * @param guessLog the guess log
	 * @return the code maker feedback
	 */
	public static CodeMakerFeedback newInstance(
		CodeMakerSecretPattern codeMakerSecretPattern, 
		CodeBreakerGuessPattern codeBreakerGuessPattern,
		Integer turnsLeft,
		List<GameBoardGuessLogItem> guessLog
	) {
		Validate.thatIsNotNull("CodeMakerFeedBack: 'codeMakerSecretPattern' not set", codeMakerSecretPattern);
		Validate.thatIsNotNull("CodeMakerFeedBack: 'codeMakerSecretPattern' not set", codeBreakerGuessPattern);
		Validate.thatIsNotNull("CodeMakerFeedBack: 'guessLog' not set", guessLog);
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
		Collections.shuffle(result);
		return new CodeMakerFeedback(result, turnsLeft, guessLog, codeMakerSecretPattern.toString());
	}
	
}
