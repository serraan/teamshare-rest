/*******************************************************************************
 * Copyright (c) 2019 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.architecture.security;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

/**
 * @author mario
 */
@Component
public class UserSessionManagerImpl implements UserSessionManager {
	// Le sessioni utente sono simulate da questa mappa 
	private final Map<String, MyUserDetails> userSessionsByJwt = new ConcurrentHashMap<>();

	/* (non-Javadoc)
	 * @see it.linksmt.teamshare.architecture.security.UserSessionManager#storeSession(it.linksmt.teamshare.architecture.security.MyUserDetails)
	 */
	@Override
	public void storeSession( @NotNull MyUserDetails userDetails ) {
		String key = userDetails.getUser().getJwt();
		userSessionsByJwt.put( key, userDetails );
	}
	
	/* (non-Javadoc)
	 * @see it.linksmt.teamshare.architecture.security.UserSessionManager#getSessionByJwt(java.lang.String)
	 */
	@Override
	public MyUserDetails getSessionByJwt( @NotBlank String jwt ) {
		return userSessionsByJwt.get( jwt );
	}
}
