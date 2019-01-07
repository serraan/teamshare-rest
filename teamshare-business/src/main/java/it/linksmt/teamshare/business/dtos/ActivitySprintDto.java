package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.ActivitySprintRequestDto;

public class ActivitySprintDto extends ActivitySprintRequestDto implements Serializable {

	private static final long serialVersionUID = 4854363690440298474L;

	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
