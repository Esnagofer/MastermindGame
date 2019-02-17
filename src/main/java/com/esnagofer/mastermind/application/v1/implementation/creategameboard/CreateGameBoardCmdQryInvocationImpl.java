package com.esnagofer.mastermind.application.v1.implementation.creategameboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esnagofer.lib.Validate;
import com.esnagofer.lib.ddd.application.usecase.api.implementation.InvokeCommandQueryImpl;
import com.esnagofer.lib.ddd.application.usecase.api.implementation.UnitOfWork;
import com.esnagofer.mastermind.application.v1.api.GameBoardIdData;
import com.esnagofer.mastermind.application.v1.api.creategameboard.CreateGameBoardCmdQry;
import com.esnagofer.mastermind.application.v1.api.creategameboard.CreateGameBoardCmdQryInvocation;
import com.esnagofer.mastermind.application.v1.api.creategameboard.CreateGameBoardCmdQryInvocationSelector;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardId;
import com.esnagofer.mastermind.domain.service.codemaker.CodeMakerService;

/**
 * The Class CreateGameBoardCmdQryInvocation.
 */
@Component
@CreateGameBoardCmdQryInvocationSelector
public class CreateGameBoardCmdQryInvocationImpl extends InvokeCommandQueryImpl<CreateGameBoardCmdQry, GameBoardIdData> implements CreateGameBoardCmdQryInvocation {

	/** The code maker service. */
	private CodeMakerService codeMakerService;
	
	/**
	 * Instantiates a new try to guess secret pattern command invocation.
	 *
	 * @param unitOfWork the unit of work
	 * @param codeMakerService the code maker service
	 */
	@Autowired
	public CreateGameBoardCmdQryInvocationImpl(
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
		Validate.thatIsNotNull("CreateGameBoardCmdQryInvocation: 'codeMakerService' not set", codeMakerService);
	}

	/* (non-Javadoc)
	 * @see com.esangofer.lib.ddd.application.usecase.api.implementation.InvokeCommandQueryImpl#localInvokeCommandQuery(com.esnagofer.lib.cqrs.commandquery.CommandQuery)
	 */
	@Override
	protected GameBoardIdData localInvokeCommandQuery(CreateGameBoardCmdQry createGameBoardCmdQry) {
		GameBoardId gameBoardId = codeMakerService.createGameBoard();
		return GameBoardIdConverter.fromDomainToApplication(gameBoardId);
	}
	
}
