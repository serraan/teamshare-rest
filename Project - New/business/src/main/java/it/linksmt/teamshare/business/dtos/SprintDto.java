package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.request.SprintRequestDto;

public class SprintDto extends SprintRequestDto implements Serializable {

	private static final long serialVersionUID = 7369835401889433150L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SprintDto [idSprint=" + id + ", getDataInizio()=" + getDataInizio() + ", getDataScadenza()="
				+ getDataScadenza() + ", getNomeSprint()=" + getNomeSprint() + "]";
	}

}
