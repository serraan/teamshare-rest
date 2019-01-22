package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.request.PostRequestDto;

public class PostDto extends PostRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6206427025925835094L;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PostDto [idPost=" + id + ", getTitoloPost()=" + getTitoloPost()
				+ ", getDescrizionePost()=" + getDescrizionePost() + ", getRiferimentoPost()=" + getRiferimentoPost()
				+ ", getIdUtente()=" + getIdUtente() + ", getDataPost()=" + getDataPost() +  "]";
	}
	
}
