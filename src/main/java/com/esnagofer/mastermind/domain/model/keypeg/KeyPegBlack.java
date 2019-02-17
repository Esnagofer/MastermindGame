package com.esnagofer.mastermind.domain.model.keypeg;

/**
 * The Class KeyPegBlack.
 */
public class KeyPegBlack extends KeyPeg {

	/**
	 * Instantiates a new key peg black.
	 */
	protected KeyPegBlack() {
		super(KeyPegColor.BLACK);
	}

	/* (non-Javadoc)
	 * @see com.esnagofer.mastermind.domain.model.keypeg.KeyPeg#isGuessed()
	 */
	@Override
	public boolean isGuessed() {
		return true;
	}

	/**
	 * New instance.
	 *
	 * @return the key peg black
	 */
	public static KeyPegBlack newInstance() {
		return new KeyPegBlack();
	}

}