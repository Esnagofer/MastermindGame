package com.esnagofer.mastermind.domain.model.codepeg;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class FourCodePegsTest.
 */
public class FourCodePegsTest {

	/**
	 * Should create code maker secret pattern with random colors.
	 */
	@Test
	public void shouldCreateFourCodePegsWithRandomColors() {
		FourCodePegs<?> secretPattern = FourCodePegs.newInstance();
		Assert.assertNotNull(secretPattern);
		Assert.assertEquals(4, secretPattern.elements().size());
	}

	/**
	 * Should create code maker secret pattern with custom colors.
	 */
	@Test
	public void shouldCreateFourCodePegsWithCustomColors() {
		FourCodePegs<?> secretPattern = FourCodePegs.newInstance(
			CodePeg.newInstance(CodePegColor.BLACK),
			CodePeg.newInstance(CodePegColor.RED),
			CodePeg.newInstance(CodePegColor.BLUE),
			CodePeg.newInstance(CodePegColor.BROWN)
		);
		Assert.assertNotNull(secretPattern);
		Assert.assertEquals(4, secretPattern.elements().size());
		Assert.assertEquals(CodePeg.newInstance(CodePegColor.BLACK), secretPattern.elements().get(0));
		Assert.assertEquals(CodePeg.newInstance(CodePegColor.RED), secretPattern.elements().get(1));
		Assert.assertEquals(CodePeg.newInstance(CodePegColor.BLUE), secretPattern.elements().get(2));
		Assert.assertEquals(CodePeg.newInstance(CodePegColor.BROWN), secretPattern.elements().get(3));
	}

	/**
	 * Should fail create with wrong size.
	 */
	@Test(expected=IllegalStateException.class)
	public void shouldFailCreateWithWrongSize() {
		FourCodePegs.newInstance(CodePeg.newInstance());
	}

}
