package com.esnagofer.mastermind.application.v1.implementation.trytoguesssecretpattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esnagofer.lib.Validate;
import com.esnagofer.lib.ddd.application.usecase.api.implementation.InvokeCommandQueryImpl;
import com.esnagofer.lib.ddd.application.usecase.api.implementation.UnitOfWork;
import com.esnagofer.lib.ddd.domain.model.repository.NotFoundException;
import com.esnagofer.mastermind.application.v1.api.CodeBreakerGuessPatternData;
import com.esnagofer.mastermind.application.v1.api.CodeMakerFeedbackData;
import com.esnagofer.mastermind.application.v1.api.InvalidGameBoardIdException;
import com.esnagofer.mastermind.application.v1.api.trytoguesssecretpattern.TryToGuessSecretPatternCmdQry;
import com.esnagofer.mastermind.application.v1.api.trytoguesssecretpattern.TryToGuessSecretPatternCmdQryInvocationSelector;
import com.esnagofer.mastermind.domain.model.codebreaker.CodeBreakerGuessPattern;
import com.esnagofer.mastermind.domain.model.codepeg.CodePeg;
import com.esnagofer.mastermind.domain.model.codepeg.CodePegColor;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardGuessLogItem;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardId;
import com.esnagofer.mastermind.domain.service.codemaker.CodeMakerService;

/**
 * The Class TryToGuessSecretPatternCommandInvocation.
 */
@Component
@TryToGuessSecretPatternCmdQryInvocationSelector
public class TryToGuessSecretPatternCmdQryInvocation extends InvokeCommandQueryImpl<TryToGuessSecretPatternCmdQry, CodeMakerFeedbackData> {

	/** The code maker service. */
	private CodeMakerService codeMakerService;
	
	/**
	 * Instantiates a new try to guess secret pattern command invocation.
	 *
	 * @param unitOfWork the unit of work
	 * @param codeMakerService the code maker service
	 */
	@Autowired
	public TryToGuessSecretPatternCmdQryInvocation(
		UnitOfWork unitOfWork,
		CodeMakerService codeMakerService
	) {
		super(unitOfWork);
		this.codeMakerService = codeMakerService;
		validateInvariants();
	}

	/**
	 * Validate invariants.
	 */
	private void validateInvariants() {
		Validate.thatIsNotNull("TryToGuessSecretPatternCommandInvocation: 'codeMakerService' not set", codeMakerService);
	}

	/* (non-Javadoc)
	 * @see com.esangofer.lib.ddd.application.usecase.api.implementation.InvokeCommandQueryImpl#localInvokeCommandQuery(com.esnagofer.lib.cqrs.commandquery.CommandQuery)
	 */
	@Override
	protected CodeMakerFeedbackData localInvokeCommandQuery(TryToGuessSecretPatternCmdQry tryToGuessSecretPatternCmdQry) {
		GameBoardId gameBoardId = GameBoardId.newInstance(tryToGuessSecretPatternCmdQry.gameBoardIdData().value);
		CodeBreakerGuessPatternData codeBreakerGuessPatternData = tryToGuessSecretPatternCmdQry.codeBerakerGuessPatternData();
		codeBreakerGuessPatternData.validateInvariants();
		CodeBreakerGuessPattern codeBreakerGuessPattern = CodeBreakerGuessPattern.newInstance(
			CodePeg.newInstance(CodePegColor.valueOf(codeBreakerGuessPatternData.codePegColor1)),
			CodePeg.newInstance(CodePegColor.valueOf(codeBreakerGuessPatternData.codePegColor2)),
			CodePeg.newInstance(CodePegColor.valueOf(codeBreakerGuessPatternData.codePegColor3)),
			CodePeg.newInstance(CodePegColor.valueOf(codeBreakerGuessPatternData.codePegColor4))
		);
		try {
			GameBoardGuessLogItem gameBoardGuessLogItem = codeMakerService.tryToGuessSecretPattern(gameBoardId, codeBreakerGuessPattern);
			return CodeMakerFeedbackConverter.fromDomainToApplication(gameBoardGuessLogItem.codeMakerFeedback());
		} catch (NotFoundException e) {
			throw new InvalidGameBoardIdException(e.getLocalizedMessage());
		}
	}
	
}
