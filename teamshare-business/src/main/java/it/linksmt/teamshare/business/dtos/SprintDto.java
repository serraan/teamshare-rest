package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;
import java.util.Date;

public class SprintDto implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5223445074699867301L;

	private Integer id;
	
	private Date dataInizio;
	
	private Date dataScadenza;
	
	private String nomeSprint;
	
	private ReleaseDto release;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getNomeSprint() {
		return nomeSprint;
	}

	public void setNomeSprint(String nomeSprint) {
		this.nomeSprint = nomeSprint;
	}

	public ReleaseDto getRelease() {
		return release;
	}

	public void setRelease(ReleaseDto release) {
		this.release = release;
	}
	
	
}
