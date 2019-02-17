package com.esnagofer.mastermind.domain.model.keypeg;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class KeyPegBlackTest.
 */
public class KeyPegBlackTest {

	/**
	 * Should create key whitout explicit color peg.
	 */
	@Test
	public void shouldCreateKeyWhitoutExplicitColorPeg() {
		KeyPegBlack keyPeg = KeyPegBlack.newInstance();
		Assert.assertEquals(KeyPegColor.BLACK, keyPeg.color());
		Assert.assertTrue(keyPeg.isGuessed());
	}
	
}
