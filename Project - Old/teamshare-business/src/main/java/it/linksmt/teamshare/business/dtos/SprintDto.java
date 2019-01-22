package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.SprintRequestDto;

public class SprintDto extends SprintRequestDto implements Serializable {

	private static final long serialVersionUID = 5223445074699867301L;

	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
