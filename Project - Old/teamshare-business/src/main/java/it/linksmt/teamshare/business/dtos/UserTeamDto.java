package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.UserTeamRequestDto;

public class UserTeamDto extends UserTeamRequestDto implements Serializable {
	
	private static final long serialVersionUID = 8913699417232164687L;
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
