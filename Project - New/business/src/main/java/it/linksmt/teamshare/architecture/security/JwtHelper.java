/*******************************************************************************
 * Copyright (c) 2018 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare.architecture.security;

import java.io.Serializable;

import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @author Mario Scakas
 */
public interface JwtHelper {
	public static class Claim {
		private final String key;
		
		private final Serializable value;

		public static Claim claim( String key, Serializable value ) {
			return new Claim( key, value );
		}
		
		public Claim( String key, Serializable value ) {
			super();
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public Serializable getValue() {
			return value;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals( Object obj ) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Claim other = (Claim) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals( other.key ))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals( other.value ))
				return false;
			return true;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Claim [key=" + key + ", value=" + value + "]";
		}
	}
	
	String create( Claim ... claims );
	
	DecodedJWT decode( String token );
	
	public void verify( String token );
}