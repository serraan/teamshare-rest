/*******************************************************************************
 * Copyright (c) 2019 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.linksmt.teamshare.business.dtos.UserAuthenticationDto;
import it.linksmt.teamshare.business.request.LoginByEmailAndPasswordDto;
import it.linksmt.teamshare.business.services.AuthenticationService;

/**
 * @author mario
 */
@RestController
@RequestMapping( "/public/authentication" )
public class AuthenticationController {
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping( "/login" )
	public UserAuthenticationDto login( @RequestBody @Valid LoginByEmailAndPasswordDto request ) {
		return authenticationService.login( request );
	}
}