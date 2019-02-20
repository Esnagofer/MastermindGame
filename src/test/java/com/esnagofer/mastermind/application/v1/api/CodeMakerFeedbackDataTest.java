package com.esnagofer.mastermind.application.v1.api;

import org.junit.Assert;
import org.junit.Test;

import com.esnagofer.mastermind.application.v1.api.CodeMakerFeedbackData;

/**
 * The Class CodeMakerFeedbackDataTest.
 */
public class CodeMakerFeedbackDataTest {

	/**
	 * Should create code maker feedback data.
	 */
	@Test
	public void shouldCreateCodeMakerFeedbackData() {
		String[] guessLog = new String[] {"guessLog1", "guessLog2"};
		Integer turnsLeft = 10;
		String message = "the message";
		String[] keyPegs = new String[] {"RED", "BLUE"};
		CodeMakerFeedbackData feedBackData = CodeMakerFeedbackData.newInstance(
			guessLog, 
			turnsLeft, 
			message, 
			keyPegs
		);
		Assert.assertNotNull(feedBackData);
		Assert.assertNotNull(feedBackData.guessLog);
		Assert.assertEquals(2, feedBackData.guessLog.length);
		Assert.assertEquals("guessLog1", feedBackData.guessLog[0]);
		Assert.assertEquals("guessLog2", feedBackData.guessLog[1]);
		Assert.assertEquals(10, feedBackData.turnsLeft);
		Assert.assertEquals("the message", feedBackData.message);
		Assert.assertEquals(2, feedBackData.keyPegs.length);
		Assert.assertEquals("RED", feedBackData.keyPegs[0]);
		Assert.assertEquals("BLUE", feedBackData.keyPegs[1]);
	}
	
}
