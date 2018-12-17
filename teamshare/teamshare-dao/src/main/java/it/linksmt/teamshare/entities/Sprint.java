package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sprint")
public class Sprint implements Serializable{

	private static final long serialVersionUID = -6033623675655160198L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSprint;
	@Column(name = "Data_Inizio")
	private Date dataInizio;
	@Column(name = "Data_Scadenza")
	private Date dataScadenza;
	@Column(name = "Nome_Sprint")
	private String nomeSprint;
	@OneToOne
	@JoinColumn(name = "idRelease")
	private Release idRelease;
	
	public Integer getIdSprint() {
		return idSprint;
	}
	public void setIdSprint(Integer idSprint) {
		this.idSprint = idSprint;
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
	public Release getIdRelease() {
		return idRelease;
	}
	public void setIdRelease(Release idRelease) {
		this.idRelease = idRelease;
	}
	
	
}
