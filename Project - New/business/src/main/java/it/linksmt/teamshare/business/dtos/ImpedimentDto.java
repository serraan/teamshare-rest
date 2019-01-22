package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.request.ImpedimentRequestDto;

public class ImpedimentDto extends ImpedimentRequestDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 173150665648915247L;
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id= id;
	}
	@Override
	public String toString() {
		return "ImpedimentDto [id=" + id + ", getDescrizione()=" + getDescrizione()
				+ ", getIdTeam()=" + getIdTeam() + ", getIdAttivita()=" + getIdAttivita() + ", getData()=" + getData() + "]";
	}
	
	
	
	
}
