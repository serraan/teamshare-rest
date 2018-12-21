package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;
import java.util.Date;

public class ImpedimentRequestDto  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8672064773945316152L;


	private String descrizione;
	
	private Date data;
	
	private Integer idAttivita;
	
	private Integer idTeam;
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public Integer getIdAttivita() {
		return idAttivita;
	}
	
	public void setIdAttivita(Integer idAttivita) {
		this.idAttivita = idAttivita;
	}
	
	public Integer getIdTeam() {
		return idTeam;
	}
	
	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}
}
	
	