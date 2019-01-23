/*******************************************************************************
 * Copyright (c) 2019 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.architecture.security;

import it.linksmt.teamshare.architecture.MySecurityException;

/**
 * @author mario
 *
 */
public class InvalidAuthenticationException extends MySecurityException {

	public InvalidAuthenticationException( String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace ) {
		super( message, cause, enableSuppression, writableStackTrace );
	}

	public InvalidAuthenticationException( String message, Throwable cause ) {
		super( message, cause );
	}

	public InvalidAuthenticationException( String message ) {
		super( message );
	}

	public InvalidAuthenticationException( Throwable cause ) {
		super( cause );
	}
}
