package com.esnagofer.mastermind.domain.model.codebreaker;

import org.junit.Assert;
import org.junit.Test;

import com.esnagofer.mastermind.domain.model.codepeg.CodePeg;
import com.esnagofer.mastermind.domain.model.codepeg.CodePegColor;

/**
 * The Class CodeBreakerGuessPatternTest.
 */
public class CodeBreakerGuessPatternTest {

	/**
	 * Creates the fixed code breaker guess pattern.
	 *
	 * @return the code breaker guess pattern
	 */
	private CodeBreakerGuessPattern createFixedCodeBreakerGuessPattern() {
		CodeBreakerGuessPattern guessPattern = CodeBreakerGuessPattern.newInstance(
			CodePeg.newInstance(CodePegColor.BLACK),
			CodePeg.newInstance(CodePegColor.RED),
			CodePeg.newInstance(CodePegColor.BLUE),
			CodePeg.newInstance(CodePegColor.BROWN)
		);
		return guessPattern;
	}

	/**
	 * Creates the same color code breaker guess pattern.
	 *
	 * @param color the color
	 * @return the code breaker guess pattern
	 */
	private CodeBreakerGuessPattern createSameColorCodeBreakerGuessPattern(CodePegColor color) {
		CodeBreakerGuessPattern guessPattern = CodeBreakerGuessPattern.newInstance(
			CodePeg.newInstance(color),
			CodePeg.newInstance(color),
			CodePeg.newInstance(color),
			CodePeg.newInstance(color)
		);
		return guessPattern;
	}

	/**
	 * Should create code breaker guess pattern colors.
	 */
	@Test
	public void shouldCreateCodeBreakerGuessPatternColors() {
		CodeBreakerGuessPattern guessPattern = createFixedCodeBreakerGuessPattern();
		Assert.assertNotNull(guessPattern);
		Assert.assertEquals(4, guessPattern.elements().size());
		Assert.assertEquals(CodePeg.newInstance(CodePegColor.BLACK), guessPattern.elements().get(0));
		Assert.assertEquals(CodePeg.newInstance(CodePegColor.RED), guessPattern.elements().get(1));
		Assert.assertEquals(CodePeg.newInstance(CodePegColor.BLUE), guessPattern.elements().get(2));
		Assert.assertEquals(CodePeg.newInstance(CodePegColor.BROWN), guessPattern.elements().get(3));
	}


	/**
	 * Should fail create with wrong size.
	 */
	@Test(expected=IllegalStateException.class)
	public void shouldFailCreateWithWrongSize() {
		CodeBreakerGuessPattern.newInstance(CodePeg.newInstance());
	}

	/**
	 * Should be two instances with same state equals.
	 */
	@Test
	public void shouldBeTwoInstancesWithSameStateEquals() {
		CodeBreakerGuessPattern guessPattern1 = createSameColorCodeBreakerGuessPattern(CodePegColor.RED);
		CodeBreakerGuessPattern guessPattern2 = createSameColorCodeBreakerGuessPattern(CodePegColor.RED);
		Assert.assertEquals(guessPattern1, guessPattern2);
	}

	/**
	 * Should be two instances with same state equals.
	 */
	@Test
	public void shouldBeTwoInstancesWithoutSameStateDiferents() {
		CodeBreakerGuessPattern guessPattern1 = createSameColorCodeBreakerGuessPattern(CodePegColor.RED);
		CodeBreakerGuessPattern guessPattern2 = createSameColorCodeBreakerGuessPattern(CodePegColor.BLACK);
		Assert.assertNotEquals(guessPattern1, guessPattern2);
	}

}
