package com.esnagofer.lib.ddd.infrastrucutre.adapter.db.repository.memory;

import java.util.Map;

import com.esnagofer.lib.ddd.domain.model.core.DomainEntity;
import com.esnagofer.lib.ddd.domain.model.core.DomainIdentity;
import com.esnagofer.lib.ddd.domain.model.repository.NotFoundException;
import com.esnagofer.lib.ddd.domain.model.repository.Repository;

/**
 * The Class MemoryRepositoryImpl.
 *
 * @param <T> the generic type
 * @param <S> the generic type
 */
public abstract class MemoryRepositoryImpl<T extends DomainEntity<S>,S extends DomainIdentity> implements Repository<T, S> {

	/**
	 * Instantiates a new memory repository impl.
	 */
	protected MemoryRepositoryImpl() {
		super();
	}
	
	/**
	 * Content.
	 *
	 * @return the map
	 */
	protected abstract Map<S,T> content();
	
	/* (non-Javadoc)
	 * @see com.esnagofer.domain.model.repository.Repository#add(com.esnagofer.domain.model.AbstractDomainEntity)
	 */
	@Override
	public void add(T domainEntity) {
		content().put(domainEntity.id(), domainEntity);
	}

	/* (non-Javadoc)
	 * @see com.esnagofer.domain.model.repository.Repository#remove(com.esnagofer.domain.model.DomainIdentity)
	 */
	@Override
	public void remove(S domainIdentity) {
		if (!contains(domainIdentity)) {
			throw new NotFoundException();
		}
		content().remove(domainIdentity);
	}

	/* (non-Javadoc)
	 * @see com.esnagofer.domain.model.repository.Repository#get(com.esnagofer.domain.model.DomainIdentity)
	 */
	@Override
	public T get(S domainIdentity) {
		if (!contains(domainIdentity)) {
			throw new NotFoundException();
		}
		return content().get(domainIdentity);
	}

	/* (non-Javadoc)
	 * @see com.esnagofer.domain.model.repository.Repository#contains(com.esnagofer.domain.model.DomainIdentity)
	 */
	@Override
	public boolean contains(S domainIdentity) {
		return content().containsKey(domainIdentity);
	}

}
