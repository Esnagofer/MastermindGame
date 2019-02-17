package com.esnagofer.lib.ddd.domain.model.event;

import org.springframework.stereotype.Component;

/**
 * The Class DomainEventManager.
 */
@Component
public class DomainEventManager {

	/**
	 * Instantiates a new domain event manager.
	 */
	public DomainEventManager() {
		super();
	}
	
	/**
	 * Publish.
	 *
	 * @param domainEvent the domain event
	 */
	public void publish(DomainEvent domainEvent) {

	}

}
