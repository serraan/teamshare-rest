package it.linksmt.teamshare.business.request;

import java.io.Serializable;

public class TeamRequestDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7880401469272431312L;
	private String nomeTeam;

	public String getNomeTeam() {
		return nomeTeam;
	}

	public void setNomeTeam(String nomeTeam) {
		this.nomeTeam = nomeTeam;
	}
}
