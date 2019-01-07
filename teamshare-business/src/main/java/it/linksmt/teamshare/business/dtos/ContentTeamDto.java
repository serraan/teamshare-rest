package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.ContentTeamRequestDto;

public class ContentTeamDto extends ContentTeamRequestDto implements Serializable {

	private static final long serialVersionUID = 1315280214823639721L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
