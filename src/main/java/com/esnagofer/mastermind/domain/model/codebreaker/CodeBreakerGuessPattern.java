package com.esnagofer.mastermind.domain.model.codebreaker;

import java.util.Arrays;
import java.util.List;

import com.esnagofer.lib.ddd.domain.model.FiniteImmutableSet;
import com.esnagofer.mastermind.domain.model.codepeg.CodePeg;

/**
 * The Class CodeBreakerGuessPattern.
 */
public class CodeBreakerGuessPattern extends FiniteImmutableSet<CodePeg> {
	
	/**
	 * Instantiates a new code breaker guess pattern.
	 *
	 * @param elements the elements
	 */
	protected CodeBreakerGuessPattern(List<CodePeg> elements) {
		super(elements);
	}

	/* (non-Javadoc)
	 * @see com.esnagofer.lib.ddd.domain.model.FiniteImmutableSet#validateSize()
	 */
	@Override
	protected void validateSize() {
		if (elements.size() != 4) {
			throw new IllegalStateException("CodeBrearkerGuessPattern: must specify exactly 4 CodePegs");
		}
	}
	
	/**
	 * New instance.
	 *
	 * @param codePegs the code pegs
	 * @return the code breaker guess pattern
	 */
	public static CodeBreakerGuessPattern newInstance(CodePeg...codePegs) {
		return new CodeBreakerGuessPattern(Arrays.asList(codePegs));
	}
	
}
