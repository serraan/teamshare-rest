package it.linksmt.teamshare.business.request;

import java.io.Serializable;
import java.util.Date;

public class ImpedimentRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7838968766637386707L;

	private String descrizione;
	
	private Integer idTeam;
	private Integer idAttivita;

	private Date Data;

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	

	public Integer getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}

	public Integer getIdAttivita() {
		return idAttivita;
	}

	public void setIdAttivita(Integer idAttivita) {
		this.idAttivita = idAttivita;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

}
