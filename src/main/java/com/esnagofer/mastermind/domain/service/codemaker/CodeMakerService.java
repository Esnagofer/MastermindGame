package com.esnagofer.mastermind.domain.service.codemaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esnagofer.lib.Validate;
import com.esnagofer.lib.ddd.domain.model.event.DomainEventManager;
import com.esnagofer.mastermind.domain.model.codebreaker.CodeBreakerGuessPattern;
import com.esnagofer.mastermind.domain.model.codebreaker.event.CodeBreakerGuessPatternTriedEvent;
import com.esnagofer.mastermind.domain.model.codemaker.CodeMakerFeedback;
import com.esnagofer.mastermind.domain.model.codemaker.CodeMakerSecretPattern;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoard;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardGuessLogItem;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardId;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardRepository;
import com.esnagofer.mastermind.domain.model.gameboard.event.GameBoardCreatedEvent;

/**
 * The Class CodeMakerService.
 */
@Component
public class CodeMakerService {

	/** The game board repository. */
	private GameBoardRepository gameBoardRepository;
	
	/** The domain event manager. */
	private DomainEventManager domainEventManager;

	/**
	 * Instantiates a new code maker service.
	 *
	 * @param aGameBoardRepository the a game board repository
	 * @param aDomainEventManager the a domain event manager
	 */
	@Autowired
	public CodeMakerService(
		GameBoardRepository aGameBoardRepository,
		DomainEventManager aDomainEventManager 
	) {
		super();
		this.gameBoardRepository = aGameBoardRepository;
		this.domainEventManager = aDomainEventManager;
		validateInvariants();
	}
	
	/**
	 * Validate invariants.
	 */
	private void validateInvariants() {
		Validate.thatIsNotNull("CodeMakerService: 'gameBoardRepository' not set", gameBoardRepository);
		Validate.thatIsNotNull("CodeMakerService: 'domainEventManager' not set", domainEventManager);
	}
	
	/**
	 * Creates the game board.
	 *
	 * @return the game board id
	 */
	public GameBoardId createGameBoard() {
		GameBoard gameBoard = GameBoard.builder()
			.withId(GameBoardId.newInstance())
			.withSecretPattern(CodeMakerSecretPattern.newInstance())
		.build();
		gameBoardRepository.add(gameBoard);
		domainEventManager.publish(GameBoardCreatedEvent.newInstance(gameBoard.id()));
		return gameBoard.id();
	}
	
	/**
	 * Try to guess secret pattern.
	 *
	 * @param gameBoardId the game board id
	 * @param codeBreakerGuessPattern the code breaker guess pattern
	 * @return the game board guess log item
	 */
	public GameBoardGuessLogItem tryToGuessSecretPattern(GameBoardId gameBoardId, CodeBreakerGuessPattern codeBreakerGuessPattern) {
		GameBoard gameBoard = gameBoardRepository.get(gameBoardId);
		gameBoard.checkThatCanLogAnotherGuess();
		CodeMakerFeedback codeMakerFeedback = CodeMakerFeedback.newInstance(
			gameBoard.secretPattern(), 
			codeBreakerGuessPattern,
			GameBoard.ROWS - gameBoard.guessLog().size() - 1
		);
		gameBoard.logGuess(GameBoardGuessLogItem.newInstance(codeBreakerGuessPattern, codeMakerFeedback));
		domainEventManager.publish(CodeBreakerGuessPatternTriedEvent.newInstance(gameBoardId, gameBoard.lastLogGuess()));
		return gameBoard.lastLogGuess();
	}

}
