package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.ReleaseRequestDto;

public class ReleaseDto extends ReleaseRequestDto implements Serializable {

	private static final long serialVersionUID = 4134839869864270598L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
