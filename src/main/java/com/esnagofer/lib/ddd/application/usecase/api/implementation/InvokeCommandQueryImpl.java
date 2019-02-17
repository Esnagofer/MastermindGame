package com.esnagofer.lib.ddd.application.usecase.api.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esnagofer.lib.cqrs.CommandQueryReturnTypeListener;
import com.esnagofer.lib.cqrs.InvokeCommandQuery;
import com.esnagofer.lib.cqrs.commandquery.CommandQuery;

/**
 * The Class InvokeCommandQueryImpl.
 *
 * @param <T> the generic type
 * @param <R> the generic type
 */
@Component
public abstract class InvokeCommandQueryImpl<T extends CommandQuery<R>,R> implements InvokeCommandQuery<T,R> {

	/** The unit of work. */
	private UnitOfWork unitOfWork;
	
	/**
	 * Instantiates a new invoke command query impl.
	 *
	 * @param unitOfWork the unit of work
	 */
	@Autowired
	public InvokeCommandQueryImpl(UnitOfWork unitOfWork) {
		super();
		this.unitOfWork = unitOfWork;
	}
	
	/**
	 * Local invoke command query.
	 *
	 * @param commandQuery the command query
	 * @return the r
	 */
	protected R localInvokeCommandQuery(T commandQuery) {
		throw new UnsupportedOperationException("Not implemented");
	}
	
	/**
	 * Invoke command query.
	 *
	 * @param commandQuery the command query
	 * @param resultListener the listener
	 */
	/* (non-Javadoc)
	 * @see com.esnagofer.lib.cqrs.InvokeCommandQuery#invokeCommandQuery(com.esnagofer.lib.cqrs.commandquery.CommandQuery)
	 */
	@Override
	public void invokeCommandQuery(T commandQuery, CommandQueryReturnTypeListener<R> resultListener) {
		try {
			unitOfWork.begin();
			R result = localInvokeCommandQuery(commandQuery);
			unitOfWork.commit();
			resultListener.notifyResult(result);
		} catch (Exception e) {
			unitOfWork.rollback(e);
			throw e;
		}
	}

}
