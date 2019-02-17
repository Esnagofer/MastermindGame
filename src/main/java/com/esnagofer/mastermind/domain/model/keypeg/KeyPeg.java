package com.esnagofer.mastermind.domain.model.keypeg;

import java.util.Random;

import com.esnagofer.lib.Validate;
import com.esnagofer.lib.ddd.domain.model.core.DomainValueObject;

/**
 * The Class KeyPeg.
 */
public class KeyPeg extends DomainValueObject {

	/** The color. */
	private KeyPegColor color;

	/**
	 * Instantiates a new key peg.
	 *
	 * @param color the color
	 */
	protected KeyPeg(KeyPegColor color) {
		super();
		this.color = color;
		validateInvariants();
	}

	/**
	 * Instantiates a new key peg.
	 */
	protected KeyPeg() {
		super();
		this.color = randomColor();
		validateInvariants();
	}

    /**
     * Random color.
     *
     * @return the key peg color
     */
    protected KeyPegColor randomColor() {
    	return KeyPegColor.values()[new Random().nextInt(KeyPegColor.values().length)];
    }

	/**
	 * Validate invariants.
	 */
	private void validateInvariants() {
		Validate.thatIsNotNull("KeyPeg: 'color' not set", color);
	}
	
	/* (non-Javadoc)
	 * @see com.esnagofer.lib.ddd.domain.model.core.DomainValueObject#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + color.hashCode();
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		KeyPeg other = (KeyPeg) obj;
		return (color == other.color);
	}

	/**
	 * Color.
	 *
	 * @return the key peg color
	 */
	public KeyPegColor color() {
		return color;
	}
	
	/**
	 * Checks if is guessed.
	 *
	 * @return true, if is guessed
	 */
	public boolean isGuessed() {
		throw new UnsupportedOperationException("Not implemented!");
	}

	/**
	 * New instance.
	 *
	 * @param color the color
	 * @return the key peg
	 */
	public static KeyPeg newInstance(KeyPegColor color) {
		return new KeyPeg(color);
	}

	/**
	 * New instance.
	 *
	 * @return the key peg
	 */
	public static KeyPeg newInstance() {
		return new KeyPeg();
	}

}
