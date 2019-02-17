/**
 * 
 */
package com.esnagofer.lib.ddd.domain.model.repository;

import com.esnagofer.lib.ddd.domain.model.core.DomainEntity;
import com.esnagofer.lib.ddd.domain.model.core.DomainIdentity;

/**
 * The Interface Repository.
 *
 * @param <T> the generic type
 * @param <S> the generic type
 */
public interface Repository<T extends DomainEntity<S>,S extends DomainIdentity> {
	
	/**
	 * Adds the.
	 *
	 * @param domainEntity the domain entity
	 */
	public void add(T domainEntity);

	/**
	 * Removes the.
	 *
	 * @param domainIdentity the domain identity
	 */
	public void remove(S domainIdentity);

	/**
	 * Gets the.
	 *
	 * @param domainIdentity the domain identity
	 * @return the t
	 */
	public T get(S domainIdentity);

	/**
	 * Contains.
	 *
	 * @param domainIdentity the domain identity
	 * @return true, if successful
	 */
	public boolean contains(S domainIdentity);

}
