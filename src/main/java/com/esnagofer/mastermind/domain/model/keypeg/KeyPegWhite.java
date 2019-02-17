package com.esnagofer.mastermind.domain.model.keypeg;

/**
 * The Class KeyPegBlack.
 */
public class KeyPegWhite extends KeyPeg {

	/**
	 * Instantiates a new key peg black.
	 */
	protected KeyPegWhite() {
		super(KeyPegColor.WHITE);
	}

	/* (non-Javadoc)
	 * @see com.esnagofer.mastermind.domain.model.keypeg.KeyPeg#isGuessed()
	 */
	@Override
	public boolean isGuessed() {
		return false;
	}

	/**
	 * New instance.
	 *
	 * @return the key peg black
	 */
	public static KeyPegWhite newInstance() {
		return new KeyPegWhite();
	}

}