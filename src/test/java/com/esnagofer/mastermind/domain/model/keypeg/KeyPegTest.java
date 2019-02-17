package com.esnagofer.mastermind.domain.model.keypeg;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class KeyPegTest.
 */
public class KeyPegTest {

	/**
	 * Should create key peg.
	 */
	@Test
	public void shouldCreateKeyWhitoutExplicitColorPeg() {
		KeyPeg keyPeg = KeyPeg.newInstance();
		Assert.assertNotNull(keyPeg.color());
	}

	/**
	 * Should create key whit explicit color peg.
	 */
	@Test
	public void shouldCreateKeyWhitExplicitColorPeg() {
		KeyPeg keyPeg = KeyPeg.newInstance(KeyPegColor.BLACK);
		Assert.assertNotNull(keyPeg.color());
		Assert.assertEquals(KeyPegColor.BLACK, keyPeg.color());
	}

	/**
	 * Should create key whit explicit null color peg.
	 */
	@Test(expected=IllegalStateException.class)
	public void shouldCreateKeyWhitExplicitNullColorPeg() {
		KeyPeg.newInstance(null);
	}

	/**
	 * Should pass hash code with two instances of same color.
	 */
	@Test
	public void shouldPassHashCodeWithTwoInstancesOfSameColor() {
		KeyPeg keyPegBlack1 = KeyPeg.newInstance(KeyPegColor.BLACK);
		KeyPeg keyPegBlack2 = KeyPeg.newInstance(KeyPegColor.BLACK);
		Assert.assertTrue(keyPegBlack1.equals(keyPegBlack2));
	}

	/**
	 * Should fail hash code with two instances of direfent color.
	 */
	@Test
	public void shouldFailHashCodeWithTwoInstancesOfDirefentColor() {
		KeyPeg keyPegBlack1 = KeyPeg.newInstance(KeyPegColor.BLACK);
		KeyPeg keyPegBlack2 = KeyPeg.newInstance(KeyPegColor.WHITE);
		Assert.assertFalse(keyPegBlack1.equals(keyPegBlack2));
	}

	/**
	 * Should fail equals with two instances of diferent color.
	 */
	@Test
	public void shouldFailEqualsWithTwoInstancesOfDiferentColor() {
		KeyPeg keyPegBlack1 = KeyPeg.newInstance(KeyPegColor.BLACK);
		KeyPeg keyPegBlack2 = KeyPeg.newInstance(KeyPegColor.WHITE);
		Assert.assertFalse(keyPegBlack1.equals(keyPegBlack2));
	}

	/**
	 * Should be equals with two instances of same color.
	 */
	@Test
	public void shouldBeEqualsWithTwoInstancesOfSameColor() {
		KeyPeg keyPegBlack1 = KeyPeg.newInstance(KeyPegColor.BLACK);
		KeyPeg keyPegBlack2 = KeyPeg.newInstance(KeyPegColor.BLACK);
		Assert.assertTrue(keyPegBlack1.equals(keyPegBlack2));
	}

}