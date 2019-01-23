/*******************************************************************************
 * Copyright (c) 2019 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.architecture.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Metodi di utiilità per accedere agli utenti.
 * @author mario
 */
public class SecurityHelpers {
	/**
	 * Recupera i dettagli dell'utente corrente.
	 * @return i dati dell'utente corrente
	 * @throws InvalidAuthenticationException se l'autenticazione non esiste o è invalida.
	 */
	public static MyUserDetails getUserDetails() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (!(authentication instanceof MyAuthenticationToken)) {
			throw new InvalidAuthenticationException( "No authentication" );
		}
		
		MyAuthenticationToken authToken = (MyAuthenticationToken) authentication ;
		MyUserDetails userDetails =  authToken.getDetails();

		if (userDetails == null) {
			throw new InvalidAuthenticationException( "No user details found: bad token?" );
		}
		
		return userDetails;
	}
}
