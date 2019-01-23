/*******************************************************************************
 * Copyright (c) 2019 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.architecture.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import it.linksmt.teamshare.business.dtos.UserAuthenticationDto;

/**
 * @author mario
 */
public class MyUserDetails implements Serializable {
	private final UserAuthenticationDto user;

	private final List<SimpleGrantedAuthority> roles = new ArrayList<>();
	
	public MyUserDetails( UserAuthenticationDto user ) {
		super();
		this.user = user;
		
		// TODO Costanti!
		this.roles.add( new SimpleGrantedAuthority( "ROLE_USER" ) );
	}

	public UserAuthenticationDto getUser() {
		return user;
	}

	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}
}
