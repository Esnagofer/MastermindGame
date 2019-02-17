package com.esnagofer.lib.ddd.domain.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class FiniteImmutableSetTest.
 */
public class FiniteImmutableSetTest {

	/**
	 * Should be two instances with same state equals.
	 */
	@Test
	public void shouldBeTwoInstancesWithSameStateEquals() {
		FiniteImmutableSet<Integer> set1 = FiniteImmutableSet.newInstance(1,2,3,4,5);
		FiniteImmutableSet<Integer> set2 = FiniteImmutableSet.newInstance(1,2,3,4,5);
		Assert.assertEquals(set1, set2);
	}

	/**
	 * Should be two instances without same state diferents.
	 */
	@Test
	public void shouldBeTwoInstancesWithoutSameStateDiferents() {
		FiniteImmutableSet<Integer> set1 = FiniteImmutableSet.newInstance(1,2,3,4,5);
		FiniteImmutableSet<Integer> set2 = FiniteImmutableSet.newInstance(5,4,3,2,1);
		Assert.assertNotEquals(set1, set2);
	}

}
