package com.esnagofer.mastermind.domain.model.codemaker;

import org.junit.Assert;
import org.junit.Test;

import com.esnagofer.mastermind.domain.model.codepeg.CodePeg;
import com.esnagofer.mastermind.domain.model.codepeg.CodePegColor;
import com.esnagofer.mastermind.domain.model.codepeg.CodePegData;

/**
 * The Class CodeMakerSecretPatternTest.
 */
public class CodeMakerSecretPatternTest {

	/**
	 * Should create code maker secret pattern random colors.
	 */
	@Test
	public void shouldCreateCodeMakerSecretPatternWithRandomColors() {
		CodeMakerSecretPattern secretPattern = CodeMakerSecretPattern.newInstance();
		Assert.assertNotNull(secretPattern);
		Assert.assertEquals(4, secretPattern.elements().size());
	}

	/**
	 * Should create code maker secret pattern with custom colors.
	 */
	@Test
	public void shouldCreateCodeMakerSecretPatternWithCustomColors() {
		CodeMakerSecretPattern secretPattern = CodeMakerSecretPattern.newInstance(
			CodePeg.newInstance(CodePegColor.BLACK),
			CodePeg.newInstance(CodePegColor.RED),
			CodePeg.newInstance(CodePegColor.BLUE),
			CodePeg.newInstance(CodePegColor.BROWN)
		);
		Assert.assertNotNull(secretPattern);
		Assert.assertEquals(4, secretPattern.elements().size());
		Assert.assertEquals(CodePeg.newInstance(CodePegColor.BLACK), secretPattern.elements().get(0));
		Assert.assertEquals(CodePeg.newInstance(CodePegColor.RED), secretPattern.elements().get(1));
		Assert.assertEquals(CodePeg.newInstance(CodePegColor.BLUE), secretPattern.elements().get(2));
		Assert.assertEquals(CodePeg.newInstance(CodePegColor.BROWN), secretPattern.elements().get(3));
	}

	/**
	 * Should fail create with wrong size.
	 */
	@Test(expected=IllegalStateException.class)
	public void shouldFailCreateWithWrongSize() {
		CodeMakerSecretPattern.newInstance(CodePeg.newInstance());
	}

	/**
	 * Should be two instances with same state equals.
	 */
	@Test
	public void shouldBeTwoInstancesWithSameStateEquals() {
		CodeMakerSecretPattern secretPattern1 = CodeMakerSecretPattern.newInstance(CodePegData.fourCodePegsWithSameColor(CodePegColor.BLACK));
		CodeMakerSecretPattern secretPattern2 = CodeMakerSecretPattern.newInstance(CodePegData.fourCodePegsWithSameColor(CodePegColor.BLACK));
		Assert.assertEquals(secretPattern1, secretPattern2);
	}

	/**
	 * Should be two instances with same state equals.
	 */
	@Test
	public void shouldBeTwoInstancesWithoutSameStateDiferents() {
		CodeMakerSecretPattern secretPattern1 = CodeMakerSecretPattern.newInstance(CodePegData.fourCodePegsWithSameColor(CodePegColor.BLACK));
		CodeMakerSecretPattern secretPattern2 = CodeMakerSecretPattern.newInstance(CodePegData.fourCodePegsWithSameColor(CodePegColor.RED));
		Assert.assertNotEquals(secretPattern1, secretPattern2);
	}

}
