package com.esnagofer.mastermind.domain.model;

import java.util.UUID;

import org.springframework.stereotype.Component;

/**
 * The Class Jander.
 */
@Component
@JanderSelector
public class Jander implements IJander {

	/**
	 * The Class JanderData.
	 */
	public class JanderData {
		
		/** The id. */
		public String id;
		
		/** The message. */
		public String message;

		/**
		 * Instantiates a new jander data.
		 *
		 * @param id the id
		 * @param message the message
		 */
		protected JanderData(String id, String message) {
			super();
			this.id = id;
			this.message = message;
		}
		
	}
	
	/**
	 * Instantiates a new jander.
	 */
	public Jander() {
		super();
	}
	

	/* (non-Javadoc)
	 * @see com.esnagofer.mastermind.infrastructure.boot.IJander#getJander()
	 */
	@Override
	public String getJander() {
		return "Klander!";
	}
	
	/**
	 * Data.
	 *
	 * @return the jander data
	 */
	public JanderData data() {
		return new JanderData(UUID.randomUUID().toString(), getJander());
	}
	
}
