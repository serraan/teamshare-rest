/*******************************************************************************
 * Copyright (c) 2019 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.architecture.security;

/**
 * @author mario
 */
public final class MyJwtClaims {
	public static final String NAMESPACE_PREFIX = "ts::"; 
	
	public static final String UTENTE_NOME = NAMESPACE_PREFIX + "nome";
	public static final String UTENTE_COGNOME = NAMESPACE_PREFIX + "cognome";
	
	private MyJwtClaims() {
		// Do not instantiate
	}
}