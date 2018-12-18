package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.PostRequestDto;

public class PostDto extends PostRequestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4404657293499914684L;
	Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PostDto [id=" + id + ", getTitle()=" + getTitle() + ", getDescription()=" + getDescription()
				+ ", getReference()=" + getReference() + ", getDatePublication()=" + getDatePublication()
				+ ", getIdUserCreator()=" + getIdUserCreator() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
