package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.ActivityStateRequestDto;

public class ActivityStateDto extends ActivityStateRequestDto implements Serializable {

	private static final long serialVersionUID = 8271535859525165936L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
