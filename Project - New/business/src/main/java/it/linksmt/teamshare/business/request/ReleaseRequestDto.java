package it.linksmt.teamshare.business.request;

import java.io.Serializable;

public class ReleaseRequestDto implements Serializable{

	private static final long serialVersionUID = -153360843791729386L;
	
	private String nomeRelease;

	public String getNomeRelease() {
		return nomeRelease;
	}

	public void setNomeRelease(String nomeRelease) {
		this.nomeRelease = nomeRelease;
	}
	
	
}
