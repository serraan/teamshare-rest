/*******************************************************************************
 * Copyright (c) 2018 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.architecture.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * @author mario
 */
public class MyAuthenticationToken extends AbstractAuthenticationToken {
	private static final long serialVersionUID = 6180300130585838693L;

	public MyAuthenticationToken( MyUserDetails userDetails ) {
		super( userDetails.getRoles() );
		setDetails( userDetails );
		setAuthenticated( true );
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#getCredentials()
	 */
	@Override
	public Object getCredentials() {
		return "<unused>"; // XXX Unused
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.AbstractAuthenticationToken#getDetails()
	 */
	@Override
	public MyUserDetails getDetails() {
		return (MyUserDetails) super.getDetails();
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#getPrincipal()
	 */
	@Override
	public MyUserDetails getPrincipal() {
		return (MyUserDetails) getDetails();
	}
}
