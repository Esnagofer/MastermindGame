package com.esnagofer.mastermind.domain.model.codemaker;

import java.util.ArrayList;
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
		CodeMakerFeedback feedBack = CodeMakerFeedback.newInstance(codeMakerSecretPattern, codeBreakerGuessPattern, 1, new ArrayList<>());
		Assert.assertNotNull(feedBack);
	}

	/**
	 * Should fails create code maker feedback when invalid turn.
	 */
	@Test(expected=IllegalStateException.class)
	public void shouldFailsCreateCodeMakerFeedbackWhenInvalidTurn() {
		CodeMakerSecretPattern codeMakerSecretPattern = CodeMakerSecretPattern.newInstance();
		CodeBreakerGuessPattern codeBreakerGuessPattern = CodeBreakerGuessPattern.newInstance(CodePegData.fourCodePegs());
		CodeMakerFeedback.newInstance(codeMakerSecretPattern, codeBreakerGuessPattern, -1, new ArrayList<>());
	}

	/**
	 * Should fails create code maker feedback when invalid secret pattern.
	 */
	@Test(expected=IllegalStateException.class)
	public void shouldFailsCreateCodeMakerFeedbackWhenInvalidSecretPattern() {
		CodeBreakerGuessPattern codeBreakerGuessPattern = CodeBreakerGuessPattern.newInstance(CodePegData.fourCodePegs());
		CodeMakerFeedback.newInstance(null, codeBreakerGuessPattern, 1, new ArrayList<>());
	}

	/**
	 * Should fails create code maker feedback when invalid guess pattern.
	 */
	@Test(expected=IllegalStateException.class)
	public void shouldFailsCreateCodeMakerFeedbackWhenInvalidGuessPattern() {
		CodeMakerSecretPattern codeMakerSecretPattern = CodeMakerSecretPattern.newInstance();
		CodeMakerFeedback.newInstance(codeMakerSecretPattern, null, 1, new ArrayList<>());
	}

	/**
	 * Should fails create code maker feedback when invalid guess and secret patterns.
	 */
	@Test(expected=IllegalStateException.class)
	public void shouldFailsCreateCodeMakerFeedbackWhenInvalidGuessAndSecretPatterns() {
		CodeMakerFeedback.newInstance(null, null, 1, new ArrayList<>());
	}

	/**
	 * Should fail guess.
	 */
	@Test
	public void shouldFailGuess() {
		CodeMakerSecretPattern codeMakerSecretPattern = CodeMakerSecretPattern.newInstance(CodePegData.fourCodePegsWithSameColor(CodePegColor.BLACK));
		CodeBreakerGuessPattern codeBreakerGuessPattern = CodeBreakerGuessPattern.newInstance(CodePegData.fourCodePegsWithSameColor(CodePegColor.RED));
		CodeMakerFeedback feedBack = CodeMakerFeedback.newInstance(codeMakerSecretPattern, codeBreakerGuessPattern, 1, new ArrayList<>());
		Assert.assertNotNull(feedBack);
		Assert.assertNotNull(feedBack.guessLog());
		Assert.assertFalse(feedBack.isWinner());
		Assert.assertEquals(0, feedBack.elements().size());
		Assert.assertEquals(1, feedBack.turnsLeft());
	}
	
	/**
	 * Should guess.
	 */
	@Test
	public void shouldGuess() {
		CodeMakerSecretPattern codeMakerSecretPattern = CodeMakerSecretPattern.newInstance(CodePegData.fourCodePegsWithSameColor(CodePegColor.BLUE));
		CodeBreakerGuessPattern codeBreakerGuessPattern = CodeBreakerGuessPattern.newInstance(CodePegData.fourCodePegsWithSameColor(CodePegColor.BLUE));
		CodeMakerFeedback feedBack = CodeMakerFeedback.newInstance(codeMakerSecretPattern, codeBreakerGuessPattern, 1, new ArrayList<>());
		Assert.assertNotNull(feedBack);
		Assert.assertNotNull(feedBack.guessLog());
		Assert.assertTrue(feedBack.isWinner());
		Assert.assertEquals(4, feedBack.elements().size());
		Assert.assertEquals(4, feedBack.elements().stream()
			.filter(keyPeg -> keyPeg.isGuessed() && keyPeg.color().equals(KeyPegColor.BLACK))
			.collect(Collectors.toList()).size());
		Assert.assertEquals(1, feedBack.turnsLeft());
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
						CodeMakerFeedback feedBack = CodeMakerFeedback.newInstance(codeMakerSecretPattern, codeBreakerGuessPattern, 1, new ArrayList<>());
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
