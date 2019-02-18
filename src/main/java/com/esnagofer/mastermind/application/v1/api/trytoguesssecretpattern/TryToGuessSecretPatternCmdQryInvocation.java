package com.esnagofer.mastermind.application.v1.api.trytoguesssecretpattern;

import com.esnagofer.lib.cqrs.InvokeCommandQuery;
import com.esnagofer.mastermind.application.v1.api.CodeMakerFeedbackData;

/**
 * The Interface TryToGuessSecretPatternCmdQryInvocation.
 */
public interface TryToGuessSecretPatternCmdQryInvocation extends InvokeCommandQuery<TryToGuessSecretPatternCmdQry, CodeMakerFeedbackData> {}
