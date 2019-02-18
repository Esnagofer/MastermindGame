/**
 * 
 */
package com.esnagofer.mastermind.application.v1.api.trytoguesssecretpattern;

import com.esnagofer.lib.Validate;
import com.esnagofer.lib.cqrs.commandquery.CommandQuery;
import com.esnagofer.mastermind.application.v1.api.CodeBreakerGuessPatternData;
import com.esnagofer.mastermind.application.v1.api.CodeMakerFeedbackData;
import com.esnagofer.mastermind.application.v1.api.GameBoardIdData;

/**
 * The Class TryToGuessSecretPatternCommand.
 */
public class TryToGuessSecretPatternCmdQry extends CommandQuery<CodeMakerFeedbackData> {

	/** The game board id data. */
	private GameBoardIdData gameBoardIdData;
	
	/** The code beraker guess pattern data. */
	private CodeBreakerGuessPatternData codeBerakerGuessPatternData;
	
	/**
	 * Instantiates a new try to guess secret pattern command.
	 *
	 * @param gameBoardIdData the game board id data
	 * @param codeBreakerGuessPatternData the code breaker guess pattern data
	 */
	protected TryToGuessSecretPatternCmdQry(
		GameBoardIdData gameBoardIdData, 
		CodeBreakerGuessPatternData codeBreakerGuessPatternData
	) {
		super(CodeMakerFeedbackData.class);
		this.gameBoardIdData = gameBoardIdData;
		this.codeBerakerGuessPatternData = codeBreakerGuessPatternData;
		validateInvariants();
	}

	private void validateInvariants() {
		Validate.thatIsNotNull("TryToGuessSecretPatternCmdQry: 'gameBoardIdData' not set", gameBoardIdData);
		Validate.thatIsNotNull("TryToGuessSecretPatternCmdQry: 'codeBerakerGuessPatternData' not set", gameBoardIdData);
	}

	/**
	 * Code beraker guess pattern data.
	 *
	 * @return the code breaker guess pattern data
	 */
	public CodeBreakerGuessPatternData codeBerakerGuessPatternData() {
		return codeBerakerGuessPatternData;
	}

	/**
	 * Game board id data.
	 *
	 * @return the game board id data
	 */
	public GameBoardIdData gameBoardIdData() {
		return gameBoardIdData;
	}

	/**
	 * New instance.
	 *
	 * @param gameBoardIdData the game board id data
	 * @param codeBreakerGuessPatternData the code breaker guess pattern data
	 * @return the try to guess secret pattern cmd qry
	 */
	public static TryToGuessSecretPatternCmdQry newInstance(
		GameBoardIdData gameBoardIdData, 
		CodeBreakerGuessPatternData codeBreakerGuessPatternData
	) {
		return new TryToGuessSecretPatternCmdQry(gameBoardIdData, codeBreakerGuessPatternData);
	}

}
