package com.esnagofer.mastermind.application.v1.api.creategameboard;

import com.esnagofer.lib.cqrs.InvokeCommandQuery;
import com.esnagofer.mastermind.application.v1.api.GameBoardIdData;

/**
 * The Interface CreateGameBoardCmdQryInvocation.
 */
public interface CreateGameBoardCmdQryInvocation extends InvokeCommandQuery<CreateGameBoardCmdQry, GameBoardIdData> {}
