package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

public class AuthenticationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1167410027010653891L;
	
	private String JWT;

	public String getJWT() {
		return JWT;
	}

	public void setJWT(String jwt) {
		JWT = jwt;
	}
	

}
