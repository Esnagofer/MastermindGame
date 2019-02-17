package com.esnagofer.mastermind.domain.model.gameboard;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class GameBoardIdTest.
 */
public class GameBoardIdTest {

	/**
	 * Should create game board id whitout value.
	 */
	@Test
	public void shouldCreateGameBoardIdWhitoutValue() {
		GameBoardId id = GameBoardId.newInstance();
		Assert.assertNotNull(id);
		Assert.assertNotNull(id.value());
		Assert.assertNotEquals("", id.value());
	}
	
	/**
	 * Should create game board id value.
	 */
	@Test
	public void shouldCreateGameBoardIdValue() {
		GameBoardId id1 = GameBoardId.newInstance("id1");
		Assert.assertNotNull(id1);
		Assert.assertNotNull(id1.value());
		Assert.assertEquals("id1", id1.value());
	}
	
	/**
	 * Should be equals.
	 */
	@Test
	public void shouldBeEqualsTwoInstancesWithSameValue() {
		GameBoardId id1 = GameBoardId.newInstance("id1");
		GameBoardId id2 = GameBoardId.newInstance("id1");
		Assert.assertEquals(id1, id2);
	}
	
}
