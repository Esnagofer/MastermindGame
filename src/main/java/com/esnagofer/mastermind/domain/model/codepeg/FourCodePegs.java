package com.esnagofer.mastermind.domain.model.codepeg;

import java.util.Arrays;
import java.util.List;

import com.esnagofer.lib.ddd.domain.model.FiniteImmutableSet;

/**
 * The Class FourCodePegs.
 */
public class FourCodePegs<T extends FourCodePegs<?>> extends FiniteImmutableSet<CodePeg> {

	/**
	 * Instantiates a new four code pegs.
	 *
	 * @param elements the elements
	 */
	protected FourCodePegs(List<CodePeg> elements) {
		super(elements);
	}

	/* (non-Javadoc)
	 * @see com.esnagofer.lib.ddd.domain.model.FiniteImmutableSet#validateSize()
	 */
	@Override
	protected void validateSize() {
		if (elements.size() != 4) {
			throw new IllegalStateException("Must have 4 codePegs");
		}
	}

	/**
	 * New instance.
	 *
	 * @return the four code pegs
	 */
	@SuppressWarnings("unchecked")
	public static <T extends FourCodePegs<?>> T newInstance() {
		return (T) new FourCodePegs<>(
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
	 * @return the four code pegs
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends FourCodePegs<?>> T newInstance(CodePeg...codePegs) {
		return (T) new FourCodePegs(Arrays.asList(codePegs));
	}
	
}
