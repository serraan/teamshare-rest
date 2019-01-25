/*******************************************************************************
 * Copyright (c) 2019 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.business.events;

import org.springframework.context.ApplicationEvent;

/**
 * @author mario
 */
public class EntityCreatedEvent extends ApplicationEvent {
	private static final long serialVersionUID = 4255948024721184180L;

	public EntityCreatedEvent( Object entity ) {
		super( entity );
	}
}