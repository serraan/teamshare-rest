package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.request.ContentRequestDto;

public class ContentDto extends ContentRequestDto implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 5832215629969131135L;
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ContentDto [id=" + id + ", getId()=" + getId() + ", getTitolo()=" + getTitolo() + ", getNomeFile()="
				+ getNomeFile() + ", getFormatoFile()=" + getFormatoFile() + ", getFile()=" + getFile() + ", getUrl()="
				+ getUrl() + ", getDataCondivisione()=" + getDataCondivisione() + "]";
	}
	
}
