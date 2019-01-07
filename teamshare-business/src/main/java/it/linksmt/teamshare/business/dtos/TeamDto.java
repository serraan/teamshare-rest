package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.TeamRequestDto;

public class TeamDto extends TeamRequestDto implements Serializable {

	private static final long serialVersionUID = -649832639732338005L;
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
