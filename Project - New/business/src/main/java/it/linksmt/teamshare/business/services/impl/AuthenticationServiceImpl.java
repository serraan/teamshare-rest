package it.linksmt.teamshare.business.services.impl;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.architecture.MySecurityException;
import it.linksmt.teamshare.architecture.security.MyUserDetails;
import it.linksmt.teamshare.architecture.security.UserSessionManager;
import it.linksmt.teamshare.business.dtos.UserAuthenticationDto;
import it.linksmt.teamshare.business.request.LoginByEmailAndPasswordDto;
import it.linksmt.teamshare.business.services.AuthenticationService;
import it.linksmt.teamshare.entities.User;
import it.linksmt.teamshare.repository.UserRepository;
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserSessionManager sessionManager;
	
	/* (non-Javadoc)
	 * @see it.linksmt.teamshare.business.services.impl.AuthenticationService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public UserAuthenticationDto login( @NotBlank String email, @NotBlank String password ) throws MySecurityException {
		User user = userRepository.findByEmail( email );
		if (user == null) {
			throw new MySecurityException( "Utente non esistente: " + email );
		}
		
		if (!password.equals( user.getPassword() )) {
			throw new MySecurityException( "Username e/o password non corretta/i!" );
		}
		
		UserAuthenticationDto userAuthentication = createUserAuthentication( user );

		MyUserDetails userDetails = new MyUserDetails( userAuthentication );
		sessionManager.storeSession( userDetails );
		
		return userAuthentication; 
	}

	/* (non-Javadoc)
	 * @see it.linksmt.teamshare.business.services.impl.AuthenticationService#login(it.linksmt.teamshare.business.request.LoginByUserNameAndPasswordDto)
	 */
	@Override
	public UserAuthenticationDto login( @Valid LoginByEmailAndPasswordDto request ) {
		return login( request.getEmail(), request.getPassword() );
	}

	private UserAuthenticationDto createUserAuthentication( User user ) {
		UserAuthenticationDto ua = new UserAuthenticationDto();
		
		ua.setJwt( createJwt( user ) );
		ua.setCognome( user.getCognome() );
		ua.setNome( user.getNome() );
		ua.setEmail( user.getEmail() );
		ua.setDataNascita( user.getDataNascita() );
		ua.setId( user.getId() );
		
		return ua;
	}

	private String createJwt( User user ) {
		return "TODO Create me!!!";
	}


}
