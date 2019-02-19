package com.esnagofer.mastermind.domain.model.gameboard;

import java.util.ArrayList;

import com.esnagofer.mastermind.domain.model.codebreaker.CodeBreakerGuessPattern;
import com.esnagofer.mastermind.domain.model.codemaker.CodeMakerFeedback;
import com.esnagofer.mastermind.domain.model.codemaker.CodeMakerSecretPattern;
import com.esnagofer.mastermind.domain.model.codepeg.CodePegColor;
import com.esnagofer.mastermind.domain.model.codepeg.CodePegData;

public class GameBoardData {

	/**
	 * Creates the code breaker guess pattern.
	 *
	 * @return the code breaker guess pattern
	 */
	public static CodeBreakerGuessPattern createCodeBreakerGuessPattern(CodePegColor guessColors) {
		CodeBreakerGuessPattern codeBreakerGuessPattern = CodeBreakerGuessPattern
				.newInstance(CodePegData.fourCodePegsWithSameColor(guessColors));
		return codeBreakerGuessPattern;
	}
	
	/**
	 * Creates the code maker secret pattern.
	 *
	 * @return the code maker secret pattern
	 */
	public static CodeMakerSecretPattern createCodeMakerSecretPattern(CodePegColor patternColors) {
		CodeMakerSecretPattern codeMakerSecretPattern = CodeMakerSecretPattern
				.newInstance(CodePegData.fourCodePegsWithSameColor(patternColors));
		return codeMakerSecretPattern;
	}
	
	/**
	 * Creates the game board guess log item.
	 *
	 * @return the game board guess log item
	 */
	public static GameBoardGuessLogItem createGameBoardGuessLogItem(CodePegColor guessColors, CodePegColor patternColors) {
		CodeBreakerGuessPattern codeBreakerGuessPattern = createCodeBreakerGuessPattern(guessColors);
		CodeMakerSecretPattern codeMakerSecretPattern = createCodeMakerSecretPattern(patternColors);
		CodeMakerFeedback codeMakerFeedback = CodeMakerFeedback.newInstance(codeMakerSecretPattern, codeBreakerGuessPattern, 1, new ArrayList<>());
		return GameBoardGuessLogItem.newInstance(codeBreakerGuessPattern, codeMakerFeedback);		
	}
	
}
