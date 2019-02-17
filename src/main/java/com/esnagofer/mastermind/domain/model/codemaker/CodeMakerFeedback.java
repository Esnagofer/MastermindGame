package com.esnagofer.mastermind.domain.model.codemaker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	
	/**
	 * Instantiates a new code maker feedback.
	 *
	 * @param elements the elements
	 */
	protected CodeMakerFeedback (List<KeyPeg> elements) {
		super(elements);
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
	 * @return the code maker feedback
	 */
	public static CodeMakerFeedback newInstance(
		CodeMakerSecretPattern codeMakerSecretPattern, 
		CodeBreakerGuessPattern codeBreakerGuessPattern
	) {
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
		return new CodeMakerFeedback(result);
	}
	
}
