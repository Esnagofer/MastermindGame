package com.esnagofer.lib.ddd.domain.model.core;

import com.esnagofer.lib.Validate;

/**
 * The Class DomainEntity.
 *
 * @param <T> the generic type
 */
public class DomainEntity<T extends DomainIdentity> {

	/** The Constant EM_DOMAIN_ENTITY_ID_NOT_SET. */
	private static final String EM_DOMAIN_ENTITY_ID_NOT_SET = "DomainEntity: 'id' not set";

	/** The id. */
	protected T id;
	
	/**
	 * Instantiates a new domain entity.
	 *
	 * @param aDomainIdentity the a domain identity
	 */
	protected DomainEntity(T aDomainIdentity){
		transferState(aDomainIdentity);
		validateInvariants();
	}

	/**
	 * Instantiates a new domain entity.
	 */
	protected DomainEntity() {
		super();
	}

	/**
	 * Transfer state.
	 *
	 * @param aDomainIdentity the a domain identity
	 */
	private void transferState(T aDomainIdentity) {
		id = aDomainIdentity;
	}

	/**
	 * Validate invariants.
	 */
	private void validateInvariants() {
		Validate.thatIsNotNull(EM_DOMAIN_ENTITY_ID_NOT_SET, id);
	}

	/**
	 * Id.
	 *
	 * @return the t
	 */
	public T id(){
		return id;
	}
	
}

