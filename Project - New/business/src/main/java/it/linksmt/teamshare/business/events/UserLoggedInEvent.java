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

import it.linksmt.teamshare.business.dtos.UserAuthenticationDto;

/**
 * @author mario
 */
public class UserLoggedInEvent extends ApplicationEvent {
	private static final long serialVersionUID = 4255948024721184180L;

	public UserLoggedInEvent( UserAuthenticationDto userAuthentication ) {
		super( userAuthentication );
	}

	/* (non-Javadoc)
	 * @see java.util.EventObject#getSource()
	 */
	@Override
	public UserAuthenticationDto getSource() {
		return (UserAuthenticationDto) super.getSource();
	}
}