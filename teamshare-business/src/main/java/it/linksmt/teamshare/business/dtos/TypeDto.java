package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.TypeRequestDto;

public class TypeDto extends TypeRequestDto implements Serializable {

	private static final long serialVersionUID = 2010301660290441500L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
