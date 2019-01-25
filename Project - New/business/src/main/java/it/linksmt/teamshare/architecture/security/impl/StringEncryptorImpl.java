/*******************************************************************************
 * Copyright (c) 2017 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.architecture.security.impl;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import it.linksmt.teamshare.architecture.security.StringEncryptor;

/**
 * Implementation of {@link StringEncryptor}.
 * 
 * @author mario
 */
public class StringEncryptorImpl implements StringEncryptor {
	private final SecretKeySpec secretKey;

	public StringEncryptorImpl( String secret, int length, String algorithm )
			throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException {
		byte[] key = new byte[length];
		key = fixSecret( secret, length );
		this.secretKey = new SecretKeySpec( key, algorithm );
	}

	/* (non-Javadoc)
	 * @see it.csebo.eb20mobres18.security.jwt.impl.StringEncryptor#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt( String s ) throws StringEncryptorException {
		try {
			Cipher cipher = Cipher.getInstance( secretKey.getAlgorithm() );
			cipher.init( Cipher.ENCRYPT_MODE, this.secretKey );

			byte[] inputBytes = s.getBytes( StandardCharsets.UTF_8 );
			byte[] output = cipher.doFinal( inputBytes );
			byte[] base64Bytes = Base64.encodeBase64( output );
			return new String( base64Bytes );
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			throw new StringEncryptorException( "Error while encrypting string!", e );
		}
	}

	/* (non-Javadoc)
	 * @see it.csebo.eb20mobres18.security.jwt.impl.StringEncryptor#decrypt(java.lang.String)
	 */
	@Override
	public String decrypt( String base64EncodedString ) throws StringEncryptorException {
		try {
			Cipher cipher = Cipher.getInstance( secretKey.getAlgorithm() );
			cipher.init( Cipher.DECRYPT_MODE, this.secretKey );
			
			byte[] inputBytes = Base64.decodeBase64( base64EncodedString );
			byte[] output = cipher.doFinal( inputBytes );
		
			return new String( output );
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			throw new StringEncryptorException( "Error while decrypting string!", e );
		}
	}

	private byte[] fixSecret( String s, int length ) throws UnsupportedEncodingException {
		if (s.length() < length) {
			int missingLength = length - s.length();
			for (int i = 0; i < missingLength; i++) {
				s += " ";
			}
		}
		return s.substring( 0, length ).getBytes( "UTF-8" );
	}
}