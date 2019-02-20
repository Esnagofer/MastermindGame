package com.esnagofer.mastermind.application.v1.api;

import org.junit.Assert;
import org.junit.Test;

import com.esnagofer.mastermind.application.v1.api.CodeBreakerGuessPatternData;

public class CodeBreakerGuessPatternDataTest {

	/**
	 * Should create code brealer guess pattern data.
	 */
	@Test
	public void shouldCreateCodeBrealerGuessPatternData() {
		CodeBreakerGuessPatternData patternData = CodeBreakerGuessPatternData.newInstance(
			"WHITE", 
			"RED", 
			"BLUE", 
			"BROWN"
		);		
		Assert.assertNotNull(patternData);
		Assert.assertEquals("WHITE", patternData.codePegColor1);
		Assert.assertEquals("RED", patternData.codePegColor2);
		Assert.assertEquals("BLUE", patternData.codePegColor3);
		Assert.assertEquals("BROWN", patternData.codePegColor4);
	}
	
}
