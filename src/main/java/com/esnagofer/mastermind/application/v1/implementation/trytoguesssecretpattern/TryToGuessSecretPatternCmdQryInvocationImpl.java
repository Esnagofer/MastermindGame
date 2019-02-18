package com.esnagofer.mastermind.application.v1.implementation.trytoguesssecretpattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esnagofer.lib.Validate;
import com.esnagofer.lib.ddd.application.usecase.api.implementation.InvokeCommandQueryImpl;
import com.esnagofer.lib.ddd.application.usecase.api.implementation.UnitOfWork;
import com.esnagofer.lib.ddd.domain.model.repository.NotFoundException;
import com.esnagofer.mastermind.application.v1.api.BadRequestException;
import com.esnagofer.mastermind.application.v1.api.CodeBreakerGuessPatternData;
import com.esnagofer.mastermind.application.v1.api.CodeMakerFeedbackData;
import com.esnagofer.mastermind.application.v1.api.trytoguesssecretpattern.TryToGuessSecretPatternCmdQry;
import com.esnagofer.mastermind.application.v1.api.trytoguesssecretpattern.TryToGuessSecretPatternCmdQryInvocation;
import com.esnagofer.mastermind.application.v1.api.trytoguesssecretpattern.TryToGuessSecretPatternCmdQryInvocationSelector;
import com.esnagofer.mastermind.domain.model.codebreaker.CodeBreakerGuessPattern;
import com.esnagofer.mastermind.domain.model.codepeg.CodePeg;
import com.esnagofer.mastermind.domain.model.codepeg.CodePegColor;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardGuessLogItem;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardId;
import com.esnagofer.mastermind.domain.model.gameboard.exception.GameBoardAlreadyHaveAWinnerException;
import com.esnagofer.mastermind.domain.model.gameboard.exception.GameBoardIsFullException;
import com.esnagofer.mastermind.domain.service.codemaker.CodeMakerService;

/**
 * The Class TryToGuessSecretPatternCommandInvocation.
 */
@Component
@TryToGuessSecretPatternCmdQryInvocationSelector
public class TryToGuessSecretPatternCmdQryInvocationImpl extends InvokeCommandQueryImpl<TryToGuessSecretPatternCmdQry, CodeMakerFeedbackData> implements TryToGuessSecretPatternCmdQryInvocation {

	/** The code maker service. */
	private CodeMakerService codeMakerService;
	
	/**
	 * Instantiates a new try to guess secret pattern command invocation.
	 *
	 * @param unitOfWork the unit of work
	 * @param codeMakerService the code maker service
	 */
	@Autowired
	public TryToGuessSecretPatternCmdQryInvocationImpl(
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
		if (tryToGuessSecretPatternCmdQry == null) {
			throw new RuntimeException("TryToGuessSecretPatternCmdQryInvocationImpl: 'tryToGuessSecretPatternCmdQry' not set");
		}
		GameBoardId gameBoardId = GameBoardId.newInstance(tryToGuessSecretPatternCmdQry.gameBoardIdData().value);
		CodeBreakerGuessPatternData codeBreakerGuessPatternData = tryToGuessSecretPatternCmdQry.codeBerakerGuessPatternData();
		try {
			codeBreakerGuessPatternData.validateInvariants();
		} catch (IllegalStateException e) {
			throw new BadRequestException(e.getMessage());
		}
		CodeBreakerGuessPattern codeBreakerGuessPattern;
		try {
			codeBreakerGuessPattern = CodeBreakerGuessPattern.newInstance(
				CodePeg.newInstance(CodePegColor.valueOf(codeBreakerGuessPatternData.codePegColor1)),
				CodePeg.newInstance(CodePegColor.valueOf(codeBreakerGuessPatternData.codePegColor2)),
				CodePeg.newInstance(CodePegColor.valueOf(codeBreakerGuessPatternData.codePegColor3)),
				CodePeg.newInstance(CodePegColor.valueOf(codeBreakerGuessPatternData.codePegColor4))
			);
		} catch (IllegalArgumentException e) {
			throw new BadRequestException("Invalid CodePeg color in request");
		}
		try {
			GameBoardGuessLogItem gameBoardGuessLogItem = codeMakerService.tryToGuessSecretPattern(gameBoardId, codeBreakerGuessPattern);
			return CodeMakerFeedbackConverter.fromDomainToApplication(gameBoardGuessLogItem.codeMakerFeedback());		
		} catch (GameBoardAlreadyHaveAWinnerException | GameBoardIsFullException e) {
			throw new BadRequestException("This game is already over");
		} catch (NotFoundException e) {
			throw new BadRequestException(String.format("Invalid GameBoardId: %s", gameBoardId.value()));
		}
	}
	
}
