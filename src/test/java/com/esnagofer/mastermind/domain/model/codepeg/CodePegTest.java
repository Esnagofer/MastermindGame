package com.esnagofer.mastermind.domain.model.codepeg;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class CodePegTest.
 */
public class CodePegTest {

	/**
	 * Should create key peg whitout explicit color peg.
	 */
	@Test
	public void shouldCreateKeyPegWhitoutExplicitColorPeg() {
		CodePeg codePeg = CodePeg.newInstance();
		Assert.assertNotNull(codePeg.color());
	}

	/**
	 * Should create key peg whit explicit color peg.
	 */
	@Test
	public void shouldCreateKeyPegWhitExplicitColorPeg() {
		CodePeg codePeg = CodePeg.newInstance(CodePegColor.BLACK);
		Assert.assertNotNull(codePeg.color());
		Assert.assertEquals(CodePegColor.BLACK, codePeg.color());
	}

	/**
	 * Should create key peg whit explicit null color peg.
	 */
	@Test(expected=IllegalStateException.class)
	public void shouldCreateKeyPegWhitExplicitNullColorPeg() {
		CodePeg.newInstance(null);
	}

	/**
	 * Should pass hash code with two instances of same color.
	 */
	@Test
	public void shouldPassHashCodeWithTwoInstancesOfSameColor() {
		CodePeg codePegBlack1 = CodePeg.newInstance(CodePegColor.BLACK);
		CodePeg codePegBlack2 = CodePeg.newInstance(CodePegColor.BLACK);
		Assert.assertTrue(codePegBlack1.equals(codePegBlack2));
	}

	/**
	 * Should fail hash code with two instances of direfent color.
	 */
	@Test
	public void shouldFailHashCodeWithTwoInstancesOfDirefentColor() {
		CodePeg codePegBlack1 = CodePeg.newInstance(CodePegColor.BLACK);
		CodePeg codePegBlack2 = CodePeg.newInstance(CodePegColor.BLUE);
		Assert.assertFalse(codePegBlack1.equals(codePegBlack2));
	}

	/**
	 * Should fail equals with two instances of diferent color.
	 */
	@Test
	public void shouldFailEqualsWithTwoInstancesOfDiferentColor() {
		CodePeg codePegBlack1 = CodePeg.newInstance(CodePegColor.BLACK);
		CodePeg codePegBlack2 = CodePeg.newInstance(CodePegColor.CYAN);
		Assert.assertFalse(codePegBlack1.equals(codePegBlack2));
	}

	/**
	 * Should be equals with two instances of same color.
	 */
	@Test
	public void shouldBeEqualsWithTwoInstancesOfSameColor() {
		CodePeg codePegBlack1 = CodePeg.newInstance(CodePegColor.RED);
		CodePeg codePegBlack2 = CodePeg.newInstance(CodePegColor.RED);
		Assert.assertTrue(codePegBlack1.equals(codePegBlack2));
	}

}
