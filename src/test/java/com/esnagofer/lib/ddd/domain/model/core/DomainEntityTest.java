package com.esnagofer.lib.ddd.domain.model.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class DomainEntityTest.
 */
public class DomainEntityTest {

	/**
	 * Should create domain entity.
	 */
	@Test
	public void shouldCreateDomainEntity() {
		DomainIdentity id = DomainIdentity.newInstance("id1");
		DomainEntity<DomainIdentity> domainEntity = new DomainEntity<>(id);
		Assert.assertNotNull(domainEntity);
		Assert.assertNotNull(domainEntity.id());
		Assert.assertTrue(id.equals(domainEntity.id()));
	}
	
}
