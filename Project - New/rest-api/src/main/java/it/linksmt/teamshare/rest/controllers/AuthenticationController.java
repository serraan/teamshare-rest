package it.linksmt.teamshare.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.linksmt.teamshare.business.dtos.UserAuthenticationDto;
import it.linksmt.teamshare.business.request.LoginByEmailAndPasswordDto;
import it.linksmt.teamshare.business.services.AuthenticationService;

@RestController
@RequestMapping( "/public/authentication" )
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping( "/login" )
	public UserAuthenticationDto login( @RequestBody LoginByEmailAndPasswordDto request ) {
		return authenticationService.login( request );
	}
}
