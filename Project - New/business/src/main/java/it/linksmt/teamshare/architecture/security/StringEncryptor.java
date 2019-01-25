/*******************************************************************************
 * Copyright (c) 2018 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.architecture.security;

import it.linksmt.teamshare.architecture.MySecurityException;

/**
 * Helper operations for encrypting / decrypting strings according to symmetric key encryption process.
 * 
 * @author mario
 */
public interface StringEncryptor {
	@SuppressWarnings( "serial" )
	public static class StringEncryptorException extends MySecurityException {

		public StringEncryptorException( String message, Throwable cause ) {
			super( message, cause );
		}

		public StringEncryptorException( String message ) {
			super( message );
		}
	}
	
	String encrypt( String s ) throws StringEncryptorException;
	String decrypt( String base64EncodedString ) throws StringEncryptorException;
}