package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.StateRequestDto;

public class StateDto extends StateRequestDto implements Serializable{

	private static final long serialVersionUID = 3399318998762675600L;
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 

}
