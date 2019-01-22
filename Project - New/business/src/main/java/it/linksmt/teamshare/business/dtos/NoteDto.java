package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.request.NoteRequestDto;

public class NoteDto extends NoteRequestDto implements Serializable {
	
	
	
	private Integer idNota;
	
	
	public Integer getIdNota() {
		return idNota;
	}
	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}
	@Override
	public String toString() {
		return "NoteDto [idNota=" + idNota + ", getIdNota()=" + getIdNota() + ", getTesto()=" + getTesto()
				+ ", getIdAttivita()=" + getIdAttivita() + "]";
	}

}


