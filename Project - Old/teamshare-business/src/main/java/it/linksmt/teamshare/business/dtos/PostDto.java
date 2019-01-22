package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.PostRequestDto;

public class PostDto extends PostRequestDto implements Serializable {

	private static final long serialVersionUID = 6206427025925835094L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
