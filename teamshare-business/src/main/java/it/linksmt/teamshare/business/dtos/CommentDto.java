package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.CommentRequestDto;

public class CommentDto extends CommentRequestDto implements Serializable {

	private static final long serialVersionUID = 6563813495101240589L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
