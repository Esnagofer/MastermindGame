package com.esnagofer.mastermind.domain.model.keypeg;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class KeyPegWhiteTest.
 */
public class KeyPegWhiteTest {

	/**
	 * Should create key whitout explicit color peg.
	 */
	@Test
	public void shouldCreateKeyWhitoutExplicitColorPeg() {
		KeyPegWhite keyPeg = KeyPegWhite.newInstance();
		Assert.assertEquals(KeyPegColor.WHITE, keyPeg.color());
		Assert.assertFalse(keyPeg.isGuessed());
	}
	
}
