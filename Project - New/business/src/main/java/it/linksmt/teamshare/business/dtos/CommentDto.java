package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.request.CommentRequestDto;

public class CommentDto extends CommentRequestDto implements Serializable {

	private static final long serialVersionUID = -4277326978678843314L;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CommentDto [idCommento=" + id + ", getTestoCommento()=" + getTestoCommento() + ", getIdPost()="
				+ getIdPost() + ", getIdUtente()=" + getIdUtente() + "]";
	}

}
