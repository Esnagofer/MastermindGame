package com.esnagofer.mastermind.application.v1.implementation.trytoguesssecretpattern;

import java.util.List;
import java.util.stream.Collectors;

import com.esnagofer.mastermind.application.v1.api.CodeMakerFeedbackData;
import com.esnagofer.mastermind.domain.model.codemaker.CodeMakerFeedback;

/**
 * The Class CodeMakerFeedbackConverter.
 */
public class CodeMakerFeedbackConverter {

	/**
	 * From domain to application.
	 *
	 * @param codeMakerFeedback the code maker feedback
	 * @return the code maker feedback data
	 */
	public static CodeMakerFeedbackData fromDomainToApplication(CodeMakerFeedback codeMakerFeedback) {
		List<String> keyPegs = codeMakerFeedback.elements().stream().map(keyPeg -> keyPeg.color().name()).collect(Collectors.toList());
		List<String> guessLog = codeMakerFeedback.guessLog();
		return CodeMakerFeedbackData.newInstance(
			guessLog.toArray(new String[guessLog.size()]),
			codeMakerFeedback.turnsLeft(),
			codeMakerFeedback.message(),
			keyPegs.toArray(new String[keyPegs.size()])
		);
	}
	
}
