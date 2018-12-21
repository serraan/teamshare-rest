package it.linksmt.teamshare.business.dto.request;

import java.util.Date;

public class SprintRequestDto {

	private Date dataInizio;

	private Date dataScadenza;

	private String nomeSprint;

	private Integer idRelease;
	

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

	public Integer getIdRelease() {
		return idRelease;
	}

	public void setIdRelease(Integer idRelease) {
		this.idRelease = idRelease;
	}
}
