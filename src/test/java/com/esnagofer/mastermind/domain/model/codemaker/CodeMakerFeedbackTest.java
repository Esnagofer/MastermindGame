package com.esnagofer.mastermind.domain.model.codemaker;

import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import com.esnagofer.mastermind.domain.model.codebreaker.CodeBreakerGuessPattern;
import com.esnagofer.mastermind.domain.model.codepeg.CodePeg;
import com.esnagofer.mastermind.domain.model.codepeg.CodePegColor;
import com.esnagofer.mastermind.domain.model.codepeg.CodePegData;
import com.esnagofer.mastermind.domain.model.keypeg.KeyPegColor;

/**
 * The Class CodeMakerFeedbackTest.
 */
public class CodeMakerFeedbackTest {

	/**
	 * Should create code maker feedback.
	 */
	@Test
	public void shouldCreateCodeMakerFeedback() {
		CodeMakerSecretPattern codeMakerSecretPattern = CodeMakerSecretPattern.newInstance();
		CodeBreakerGuessPattern codeBreakerGuessPattern = CodeBreakerGuessPattern.newInstance(CodePegData.fourCodePegs());
		CodeMakerFeedback feedBack = CodeMakerFeedback.newInstance(codeMakerSecretPattern, codeBreakerGuessPattern);
		Assert.assertNotNull(feedBack);
	}

	/**
	 * Should fail guess.
	 */
	@Test
	public void shouldFailGuess() {
		CodeMakerSecretPattern codeMakerSecretPattern = CodeMakerSecretPattern.newInstance(CodePegData.fourCodePegsWithSameColor(CodePegColor.BLACK));
		CodeBreakerGuessPattern codeBreakerGuessPattern = CodeBreakerGuessPattern.newInstance(CodePegData.fourCodePegsWithSameColor(CodePegColor.RED));
		CodeMakerFeedback feedBack = CodeMakerFeedback.newInstance(codeMakerSecretPattern, codeBreakerGuessPattern);
		Assert.assertNotNull(feedBack);
		Assert.assertFalse(feedBack.isWinner());
		Assert.assertEquals(0, feedBack.elements().size());
	}
	
	/**
	 * Should guess.
	 */
	@Test
	public void shouldGuess() {
		CodeMakerSecretPattern codeMakerSecretPattern = CodeMakerSecretPattern.newInstance(CodePegData.fourCodePegsWithSameColor(CodePegColor.BLUE));
		CodeBreakerGuessPattern codeBreakerGuessPattern = CodeBreakerGuessPattern.newInstance(CodePegData.fourCodePegsWithSameColor(CodePegColor.BLUE));
		CodeMakerFeedback feedBack = CodeMakerFeedback.newInstance(codeMakerSecretPattern, codeBreakerGuessPattern);
		Assert.assertNotNull(feedBack);
		Assert.assertTrue(feedBack.isWinner());
		Assert.assertEquals(4, feedBack.elements().size());
		Assert.assertEquals(4, feedBack.elements().stream()
			.filter(keyPeg -> keyPeg.isGuessed() && keyPeg.color().equals(KeyPegColor.BLACK))
			.collect(Collectors.toList()).size());
	}

	/**
	 * Should guess on any secret pattern.
	 */
	@Test
	public void shouldGuessOnAnySecretPattern() {
		CodeMakerSecretPattern codeMakerSecretPattern = CodeMakerSecretPattern.newInstance(CodePegData.fourCodePegs());
		int countWinners = 0;
		for (CodePegColor color1: CodePegColor.values()) {
			for (CodePegColor color2: CodePegColor.values()) {
				for (CodePegColor color3: CodePegColor.values()) {
					for (CodePegColor color4: CodePegColor.values()) {
						CodeBreakerGuessPattern codeBreakerGuessPattern = CodeBreakerGuessPattern.newInstance(
							CodePeg.newInstance(color1),
							CodePeg.newInstance(color2),
							CodePeg.newInstance(color3),
							CodePeg.newInstance(color4)							
						);
						CodeMakerFeedback feedBack = CodeMakerFeedback.newInstance(codeMakerSecretPattern, codeBreakerGuessPattern);
						if (feedBack.isWinner()) {
							countWinners = countWinners + 1;
						}
					}
				}
			}
		}
		Assert.assertEquals(1, countWinners);
	}

}
