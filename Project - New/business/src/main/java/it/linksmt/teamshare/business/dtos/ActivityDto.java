package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.request.ActivityRequestDto;

public class ActivityDto extends ActivityRequestDto implements Serializable {
	
	private static final long serialVersionUID = -1988497334387154529L;
	
	private Integer Id;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "ActivityDto [Id=" + Id + ", getTitolo()=" + getTitolo() + ", getDescrizione()=" + getDescrizione()
				+ ", getTipo()=" + getTipo() + ", getPriorita()=" + getPriorita() + ", getIdUtenteCreatore()="
				+ getIdUtenteCreatore() + ", getIdUtenteAssegnatario()=" + getIdUtenteAssegnatario()
				+ ", getDataPresaInCarico()=" + getDataPresaInCarico() + "]";
	}
	

}