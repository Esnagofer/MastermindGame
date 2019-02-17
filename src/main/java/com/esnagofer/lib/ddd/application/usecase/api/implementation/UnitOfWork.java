package com.esnagofer.lib.ddd.application.usecase.api.implementation;

/**
 * The Interface UnitOfWork.
 */
public interface UnitOfWork {

	/**
	 * Begin.
	 */
	public void begin();
	
	/**
	 * Commit.
	 */
	public void commit();
	
	/**
	 * Rollback.
	 *
	 * @param e the e
	 */
	public void rollback(Exception e);
	
	/**
	 * In transaction.
	 *
	 * @return true, if successful
	 */
	public boolean inTransaction();
	
}
