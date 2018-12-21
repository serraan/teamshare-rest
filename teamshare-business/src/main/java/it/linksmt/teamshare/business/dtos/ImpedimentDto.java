package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.ImpedimentRequestDto;

public class ImpedimentDto extends ImpedimentRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1619599728190015851L;
	/**
	 * 
	 */
	
	private Integer id;
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "ImpedimentDto [idImpediment=" + id + ", getDescrizione()=" + getDescrizione() + ", getData()="
				+ getData() + ", getIdAttivita()=" + getIdAttivita() + ", getIdTeam()=" + getIdTeam() + "]";
	}
	

	
	
}


	
	