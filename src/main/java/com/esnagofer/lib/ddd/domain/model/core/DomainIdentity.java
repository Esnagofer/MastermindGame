/**
 * 
 */
package com.esnagofer.lib.ddd.domain.model.core;

import java.util.UUID;

import com.esnagofer.lib.Validate;

/**
 * The Class DomainIdentity.
 */
public class DomainIdentity extends DomainValueObject {
	
	/** The Constant EM_DOMAIN_IDENTITY_ID_IS_EMPTY. */
	private static final String EM_DOMAIN_IDENTITY_ID_IS_EMPTY = "DomainIdentity: 'id' is empty";

	/** The id. */
	private String id;

	/**
	 * Instantiates a new domain identity.
	 *
	 * @param aDomainIdentityString the a domain identity string
	 */
	protected DomainIdentity(String aDomainIdentityString){
		super();
		transferState(aDomainIdentityString);
		validateInvariants();
	}

	/**
	 * Instantiates a new domain identity.
	 */
	protected DomainIdentity(){
		super();
		transferState(UUID.randomUUID().toString());
		validateInvariants();
	}

	/**
	 * Transfer state.
	 *
	 * @param aDomainIdentityString the a domain identity string
	 */
	private void transferState(String aDomainIdentityString) {
		this.id = aDomainIdentityString;
	}

	/**
	 * Validate invariants.
	 */
	private void validateInvariants() {
		Validate.thatIsNotEmpty(id, EM_DOMAIN_IDENTITY_ID_IS_EMPTY);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DomainIdentity [id=" + id + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		if (otherObject == null || !otherObject.getClass().isAssignableFrom(this.getClass())) return false;
		DomainIdentity domainIdentity = DomainIdentity.class.cast(otherObject);
		return id.equals(domainIdentity.value());
	}

	/**
	 * Value.
	 *
	 * @return the string
	 */
	public String value() {
		return id;
	}

	/**
	 * New instance.
	 *
	 * @param aDomainIdentityString the a domain identity string
	 * @return the domain identity
	 */
	public static DomainIdentity newInstance(String aDomainIdentityString){
		return new DomainIdentity(aDomainIdentityString);
	}

	/**
	 * New instance.
	 *
	 * @return the domain identity
	 */
	public static DomainIdentity newInstance(){
		return new DomainIdentity();
	}

}
