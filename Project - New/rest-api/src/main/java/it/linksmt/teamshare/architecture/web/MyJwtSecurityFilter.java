/*******************************************************************************
 * Copyright (c) 2018 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.architecture.web;

import static org.springframework.util.StringUtils.hasText;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import it.linksmt.teamshare.architecture.security.MyJwtAuthentication;
import it.linksmt.teamshare.architecture.security.MyJwtAuthenticationProvider;

/**
 * HTTP Filter per estrarre il JWT dalla richiesta corrente e coadiuvare il
 * {@link MyJwtAuthenticationProvider} nella creazione del contesto di sicurezza
 * previsto da Spring Security.
 * 
 * @author Mario Scalas
 */
@Component
public class MyJwtSecurityFilter extends OncePerRequestFilter {
	private static final String BEARER_TOKEN = "Bearer ";

	@SuppressWarnings( "unused" )
	private static final Logger LOG = LoggerFactory.getLogger( MyJwtSecurityFilter.class );

	/* (non-Javadoc)
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal( HttpServletRequest httpRequest, HttpServletResponse httpResponse, FilterChain filterChain )
			throws ServletException, IOException {
		try {
			MyJwtAuthentication jwt = extractJwt( httpRequest );
			if (jwt != null) {
				SecurityContextHolder.getContext().setAuthentication( jwt );
				// Nota: il Contesto Utente corrente verrà popolato all'interno
				// del MyJwtAuthenticationProvider
			}

			// Go on
			filterChain.doFilter( httpRequest, httpResponse );
		} finally {
			SecurityContextHolder.clearContext();
		}
	}

	private MyJwtAuthentication extractJwt( HttpServletRequest httpRequest ) {
		String authorizationHeader = httpRequest.getHeader( "Authorization" );

		MyJwtAuthentication jwt = null;
		if (hasText( authorizationHeader ) && authorizationHeader.startsWith( BEARER_TOKEN )) {
			String s = authorizationHeader.replace( BEARER_TOKEN, "" );
			jwt = new MyJwtAuthentication( s );
		}
		return jwt;
	}
}
