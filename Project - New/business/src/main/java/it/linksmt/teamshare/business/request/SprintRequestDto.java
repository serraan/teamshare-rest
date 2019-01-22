package it.linksmt.teamshare.business.request;

import java.io.Serializable;
import java.util.Date;


public class SprintRequestDto implements Serializable{

	private static final long serialVersionUID = -568710552039743594L;
	
	private Date dataInizio;
	private Date dataScadenza;
	private String nomeSprint;
	
	private Integer idRelease;
	
	public Integer getIdRelease() {
		return idRelease;
	}
	public void setIdRelease(Integer idRelease) {
		this.idRelease = idRelease;
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
	
	
	
}
