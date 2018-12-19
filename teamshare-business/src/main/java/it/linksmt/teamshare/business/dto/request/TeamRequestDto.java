package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;

public class TeamRequestDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1266698308230338297L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
