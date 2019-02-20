package com.esnagofer.mastermind.application.v1.implementation.trytoguesssecretpattern;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.esnagofer.mastermind.application.v1.api.CodeMakerFeedbackData;
import com.esnagofer.mastermind.domain.model.codebreaker.CodeBreakerGuessPattern;
import com.esnagofer.mastermind.domain.model.codemaker.CodeMakerFeedback;
import com.esnagofer.mastermind.domain.model.codemaker.CodeMakerSecretPattern;
import com.esnagofer.mastermind.domain.model.codepeg.CodePeg;
import com.esnagofer.mastermind.domain.model.codepeg.CodePegColor;

/**
 * The Class CodeMakerFeedbackConverterTest.
 */
public class CodeMakerFeedbackConverterTest {

	/**
	 * Should convert code maker feedback.
	 */
	@Test
	public void shouldConvertCodeMakerFeedback() {
		CodeMakerSecretPattern codeMakerSecretPattern = CodeMakerSecretPattern.newInstance();
		CodeBreakerGuessPattern codeBreakerGuessPattern = CodeBreakerGuessPattern.newInstance(
			CodePeg.newInstance(CodePegColor.BLACK),
			CodePeg.newInstance(CodePegColor.RED),
			CodePeg.newInstance(CodePegColor.BROWN),
			CodePeg.newInstance(CodePegColor.CYAN)	
		);
		CodeMakerFeedback codeMakerFeedback = CodeMakerFeedback.newInstance(
			codeMakerSecretPattern, 
			codeBreakerGuessPattern, 
			10, 
			new ArrayList<>()
		);
		CodeMakerFeedbackData codeMakerFeedbackData = CodeMakerFeedbackConverter.fromDomainToApplication(codeMakerFeedback);
		Assert.assertNotNull(codeMakerFeedbackData);
		Assert.assertEquals(10, codeMakerFeedbackData.turnsLeft);
		Assert.assertNotNull(codeMakerFeedbackData. guessLog);
		Assert.assertEquals(0, codeMakerFeedbackData.guessLog.length);
	}
	
}
