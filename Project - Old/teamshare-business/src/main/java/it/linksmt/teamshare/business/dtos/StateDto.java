package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.StateRequestDto;

public class StateDto extends StateRequestDto implements Serializable {

	private static final long serialVersionUID = -8320480227839344614L;
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
