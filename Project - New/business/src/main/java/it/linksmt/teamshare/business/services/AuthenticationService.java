/*******************************************************************************
 * Copyright (c) 2019 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.business.services;

import javax.validation.Valid;

import it.linksmt.teamshare.architecture.MySecurityException;
import it.linksmt.teamshare.business.dtos.UserAuthenticationDto;
import it.linksmt.teamshare.business.request.LoginByEmailAndPasswordDto;

/**
 * @author mario
 */
public interface AuthenticationService {
	UserAuthenticationDto login( String email, String password ) throws MySecurityException;

	UserAuthenticationDto login( @Valid LoginByEmailAndPasswordDto request );
}