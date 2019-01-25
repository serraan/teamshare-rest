/*******************************************************************************
 * Copyright (c) 2018 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.architecture.security;

import org.springframework.security.core.AuthenticationException;

/**
 * Eccezione prodotta durante il processo di autenticazione di Spring Security e che identifica problemi di 
 * validazione del token JWT incluso nelle request HTTP sulle API private.
 * 
 * @author Mario Scalas
 */
public class InvalidJwtException extends AuthenticationException {
	private static final long serialVersionUID = -1797903198600870735L;

	public InvalidJwtException( String message, Throwable cause ) {
		super( message, cause );
	}
}