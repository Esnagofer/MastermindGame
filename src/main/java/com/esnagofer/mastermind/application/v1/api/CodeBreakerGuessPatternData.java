package com.esnagofer.mastermind.application.v1.api;

import java.util.Arrays;
import java.util.List;

import com.esnagofer.lib.Validate;

/**
 * The Class CodeBreakerGuessPatternData.
 */
public class CodeBreakerGuessPatternData {

	/** The code peg color 1. */
	public String codePegColor1;
	
	/** The code peg color 2. */
	public String codePegColor2;
	
	/** The code peg color 3. */
	public String codePegColor3;
	
	/** The code peg color 4. */
	public String codePegColor4;

	/**
	 * Validate invariants.
	 */
	public void validateInvariants() {
		if (Validate.isEmptyString(codePegColor1) ||
			Validate.isEmptyString(codePegColor2) ||
			Validate.isEmptyString(codePegColor3) ||
			Validate.isEmptyString(codePegColor4)
		) {
			throw new IllegalStateException("CodeBreakerGuessPattern: Invalid number of CodePegs");
		}
	}
	
	/**
	 * As list.
	 *
	 * @return the list
	 */
	public List<String> asList(){
		validateInvariants();
		return Arrays.asList(new String[] {codePegColor1, codePegColor2, codePegColor3 ,codePegColor4});
	}

}
