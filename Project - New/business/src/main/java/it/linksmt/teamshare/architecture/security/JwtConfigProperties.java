/*******************************************************************************
 * Copyright (c) 2018 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.architecture.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author mario
 */
@Configuration
@ConfigurationProperties( prefix = "jwt.config" )
public class JwtConfigProperties {

	private String secretKey = "";
	
	private String issuer = "";

	private Boolean enableTokenEncryption;
	
	private Integer timeToLive = 0;

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey( String secretKey ) {
		this.secretKey = secretKey;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer( String issuer ) {
		this.issuer = issuer;
	}
	
	public Boolean getEnableTokenEncryption() {
		return enableTokenEncryption;
	}

	public void setEnableTokenEncryption( Boolean enableTokenEncryption ) {
		this.enableTokenEncryption = enableTokenEncryption;
	}

	public Integer getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive( Integer timeToLive ) {
		this.timeToLive = timeToLive;
	}
}