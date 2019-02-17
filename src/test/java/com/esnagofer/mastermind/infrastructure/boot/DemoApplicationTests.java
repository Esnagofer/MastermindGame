package com.esnagofer.mastermind.infrastructure.boot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esnagofer.mastermind.domain.model.Jander;

/**
 * The Class DemoApplicationTests.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTests {

	/** The jander. */
	@Autowired
	/*@JanderSelector*/
	private Jander jander;

	/**
	 * Context loads.
	 */
	@Test
	public void contextLoads() {
		Assert.assertNotNull(jander);
	}

}
