package com.esnagofer.lib.ddd.infrastrucutre;

import org.springframework.stereotype.Component;

import com.esnagofer.lib.ddd.application.usecase.api.implementation.UnitOfWork;

/**
 * The Class IdentityUnitOfWorkImpl.
 * 
 * Identity Unit Of Work: sólo para procesos no transacionales
 * 
 */
@Component
public class IdentityUnitOfWorkImpl implements UnitOfWork {

	/** The in transaction. */
	private boolean inTransaction = false;
	
	/**
	 * Instantiates a new identity unit of work impl.
	 */
	protected IdentityUnitOfWorkImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.esangofer.lib.ddd.application.usecase.api.implementation.UnitOfWork#begin()
	 */
	@Override
	public void begin() {
		inTransaction = true;
	}

	/* (non-Javadoc)
	 * @see com.esangofer.lib.ddd.application.usecase.api.implementation.UnitOfWork#commit()
	 */
	@Override
	public void commit() {
		inTransaction = false;
	}

	/* (non-Javadoc)
	 * @see com.esangofer.lib.ddd.application.usecase.api.implementation.UnitOfWork#rollback(java.lang.Exception)
	 */
	@Override
	public void rollback(Exception e) {
		inTransaction = false;
	}

	/* (non-Javadoc)
	 * @see com.esangofer.lib.ddd.application.usecase.api.implementation.UnitOfWork#inTransaction()
	 */
	@Override
	public boolean inTransaction() {
		return inTransaction;
	}

}
