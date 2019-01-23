package it.linksmt.teamshare.business.services;

import javax.validation.Valid;

import it.linksmt.teamshare.architecture.MySecurityException;
import it.linksmt.teamshare.business.dtos.UserAuthenticationDto;
import it.linksmt.teamshare.business.request.LoginByEmailAndPasswordDto;

public interface AuthenticationService {
	UserAuthenticationDto login( String email, String password ) throws MySecurityException;

	UserAuthenticationDto login( @Valid LoginByEmailAndPasswordDto request );
}