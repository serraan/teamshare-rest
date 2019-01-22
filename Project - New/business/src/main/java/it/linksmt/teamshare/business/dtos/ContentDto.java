package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.request.ContentRequestDto;

public class ContentDto extends ContentRequestDto implements Serializable {

	private static final long serialVersionUID = -4060076563095136676L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ContentDto [id=" + id + ", getTipo()=" + getTipo() + ", getIdUtenteCreatore()=" + getIdUtenteCreatore()
				+ ", getTitolo()=" + getTitolo() + ", getFile()=" + getFile() + ", getUrl()=" + getUrl()
				+ ", getNome_file()=" + getNome_file() + ", getFormato_file()=" + getFormato_file()
				+ ", getData_pubblicazione()=" + getData_pubblicazione() + "]";
	}
	
	

}
