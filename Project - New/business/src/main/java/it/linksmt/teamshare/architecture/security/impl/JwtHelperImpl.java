/*******************************************************************************
 * Copyright (c) 2018 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.architecture.security.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import it.linksmt.teamshare.architecture.security.InvalidJwtException;
import it.linksmt.teamshare.architecture.security.JwtConfigProperties;
import it.linksmt.teamshare.architecture.security.JwtHelper;
import it.linksmt.teamshare.architecture.security.StringEncryptor;

/**
 * Implementation of {@link JwtHelper}.
 * 
 * @author Mario Scalas
 */
@Component
public class JwtHelperImpl implements JwtHelper {

	private JwtConfigProperties jwtProperties;

	private StringEncryptor stringEncryptor;
	
	@Autowired
	public void setJwtProperties( JwtConfigProperties jwtProperties ) {
		this.jwtProperties = jwtProperties;
	}

	@Autowired
	public void setStringEncryptor( StringEncryptor stringEncryptor ) {
		this.stringEncryptor = stringEncryptor;
	}
	
	@Override
	public String create( Claim ... extraClaims ) {
		try {
			Algorithm algorithm = Algorithm.HMAC256( jwtProperties.getSecretKey() );
		    Builder builder = JWT.create()
		    		.withExpiresAt( computeExpireDate() )
		    		.withIssuedAt( new Date() )
					.withIssuer( jwtProperties.getIssuer() );
		    
		    // Add claims
		    if (extraClaims != null) {
			    for (Claim c : extraClaims) {
			    	builder.withClaim( c.getKey(), c.getValue().toString() );
				}
		    }
		    
			String token = builder.sign( algorithm );
			token = encryptTokenIfNeeded( token );
			
			return token;
		} catch (Exception e) {
			throw new InvalidJwtException( "JWT creation and/or encryption failed: " + e.getMessage(), e );
		}
	}

	@Override
	public DecodedJWT decode( String token ) {
		//String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJpc3MiOiJhdXRoMCJ9.AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEp-zWfOkEE";
		token = decryptTokenIfNeeded( token ); 
		try {
			DecodedJWT jwt = JWT.decode( token );
			return jwt;
		} catch (JWTDecodeException e){
		    throw new InvalidJwtException( "JWT decoding failed: " + e.getMessage(), e );
		}
	}
	
	@Override
	public void verify( String token ) {
		token = decryptTokenIfNeeded( token );
		
		try {
			Algorithm algorithm = Algorithm.HMAC256( jwtProperties.getSecretKey() );
			JWTVerifier verifier = JWT.require( algorithm )
					.withIssuer( jwtProperties.getIssuer() )		        
					.build(); //Reusable verifier instance
			/*DecodedJWT jwt = */verifier.verify( token );
		} catch (JWTVerificationException e){
		    throw new InvalidJwtException( "JWT verification failed!",  e );
		}
	}
	
	private String encryptTokenIfNeeded( String token ) throws Exception {
		String encryptedToken = token;
		if (jwtProperties.getEnableTokenEncryption()) {
			encryptedToken =  stringEncryptor.encrypt( token );
		}
		return encryptedToken;
	}

	private String decryptTokenIfNeeded( String encryptedToken ) {
		String decryptedToken = encryptedToken;
		if (jwtProperties.getEnableTokenEncryption()) {
			decryptedToken = stringEncryptor.decrypt( encryptedToken );
		}
		return decryptedToken;
	}

	private Date computeExpireDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add( Calendar.MINUTE, jwtProperties.getTimeToLive() );
		
		return calendar.getTime();
	}
}