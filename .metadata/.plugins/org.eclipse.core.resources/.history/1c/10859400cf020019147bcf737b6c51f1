package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sprint")
public class Sprint implements Serializable{

	private static final long serialVersionUID = -6033623675655160198L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSprint;
	@Column(name = "DataInizio")
	private Date dataInizio;
	@Column(name = "DataScadenza")
	private Date dataScadenza;
	@Column(name = "Nome")
	private String nomeSprint;
	
	@ManyToOne
	@JoinColumn(name = "FK_IdRelease")
	private Release idRelease;
	
	@ManyToMany(mappedBy = "idSprint")
	private List<ActivitySprint> activitySprint;
	
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
