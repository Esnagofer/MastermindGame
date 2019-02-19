package com.esnagofer.mastermind.domain.model.codepeg;

import java.util.Random;

import com.esnagofer.lib.Validate;
import com.esnagofer.lib.ddd.domain.model.core.DomainValueObject;

/**
 * The Class CodePeg.
 */
public class CodePeg extends DomainValueObject {

	/** The color. */
	private CodePegColor color;
	
	/**
	 * Instantiates a new code peg.
	 *
	 * @param color the color
	 */
	protected CodePeg(CodePegColor color) {
		super();
		this.color = color;
		validateInvariants();
	}

	/**
	 * Instantiates a new code peg.
	 */
	protected CodePeg() {
		super();
		this.color = randomColor();
		validateInvariants();
	}
	
    /**
     * Random color.
     *
     * @return the code peg color
     */
    protected CodePegColor randomColor() {
    	return CodePegColor.values()[new Random().nextInt(CodePegColor.values().length)];
    }
    
	/**
	 * Validate invariants.
	 */
	private void validateInvariants() {
		Validate.thatIsNotNull("CodePeg: 'color' not set", color);
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
		CodePeg other = (CodePeg) obj;
		return (color == other.color);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return color.name();
	}
	
	/**
	 * Color.
	 *
	 * @return the code peg color
	 */
	public CodePegColor color() {
		return color;
	}

	/**
	 * New instance.
	 *
	 * @param color the color
	 * @return the code peg
	 */
	public static CodePeg newInstance(CodePegColor color) {
		return new CodePeg(color);
	}

	/**
	 * New instance.
	 *
	 * @return the code peg
	 */
	public static CodePeg newInstance() {
		return new CodePeg();
	}

}
