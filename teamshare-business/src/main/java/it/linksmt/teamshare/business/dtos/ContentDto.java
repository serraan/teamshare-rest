package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.ContentRequestDto;

public class ContentDto extends ContentRequestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7191304334155616630L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
