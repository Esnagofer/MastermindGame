package com.esnagofer.lib.ddd.domain.model.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class DomainIdentityTest.
 */
public class DomainIdentityTest {

	/**
	 * Should create domain identity whitout value.
	 */
	@Test
	public void shouldCreateDomainIdentityWhitoutValue() {
		DomainIdentity id = DomainIdentity.newInstance();
		Assert.assertNotNull(id);
		Assert.assertNotNull(id.value());
		Assert.assertNotEquals("", id.value());
	}
	
	/**
	 * Should create domain identity with value.
	 */
	@Test
	public void shouldCreateDomainIdentityWithValue() {
		DomainIdentity id1 = DomainIdentity.newInstance("id1");
		Assert.assertNotNull(id1);
		Assert.assertNotNull(id1.value());
		Assert.assertEquals("id1", id1.value());
	}
	
	/**
	 * Should be equals two instances with same value.
	 */
	@Test
	public void shouldBeEqualsTwoInstancesWithSameValue() {
		DomainIdentity id1 = DomainIdentity.newInstance("id1");
		DomainIdentity id2 = DomainIdentity.newInstance("id1");
		Assert.assertEquals(id1, id2);
	}
	
}
