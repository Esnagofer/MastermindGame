package com.esnagofer.mastermind.domain.model.codemaker;

import java.util.Arrays;
import java.util.List;

import com.esnagofer.lib.ddd.domain.model.FiniteImmutableSet;
import com.esnagofer.mastermind.domain.model.codepeg.CodePeg;

/**
 * The Class CodeMakerSecretPattern.
 */
public class CodeMakerSecretPattern extends FiniteImmutableSet<CodePeg> {

	/**
	 * Instantiates a new code maker secret pattern.
	 *
	 * @param elements the elements
	 */
	protected CodeMakerSecretPattern(List<CodePeg> elements) {
		super(elements);
	}

	/* (non-Javadoc)
	 * @see com.esnagofer.lib.ddd.domain.model.FiniteImmutableSet#validateSize()
	 */
	@Override
	protected void validateSize() {
		if (elements.size() != 4) {
			throw new IllegalStateException("Must have 4 elements");
		}
	}

	/**
	 * New instance.
	 *
	 * @return the code maker secret pattern
	 */
	public static CodeMakerSecretPattern newInstance() {
		return new CodeMakerSecretPattern(
			Arrays.asList(
				CodePeg.newInstance(),
				CodePeg.newInstance(),
				CodePeg.newInstance(),
				CodePeg.newInstance()
			)
		);
	}

	/**
	 * New instance.
	 *
	 * @param codePegs the code pegs
	 * @return the code maker secret pattern
	 */
	public static CodeMakerSecretPattern newInstance(CodePeg...codePegs) {
		return new CodeMakerSecretPattern(Arrays.asList(codePegs));
	}
	
}
