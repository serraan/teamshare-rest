package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

public class LoginInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5272042600229781177L;

	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
