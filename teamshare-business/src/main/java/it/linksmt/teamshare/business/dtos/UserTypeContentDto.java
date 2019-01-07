package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.UserTypeContentRequestDto;

public class UserTypeContentDto extends UserTypeContentRequestDto implements Serializable {

	private static final long serialVersionUID = -6026870805099007903L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
