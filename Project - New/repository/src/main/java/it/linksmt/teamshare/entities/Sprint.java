package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_sprint")
public class Sprint implements Serializable{

	private static final long serialVersionUID = -6033623675655160198L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "data_inizio")
	private Date dataInizio;
	@Column(name = "data_scadenza")
	private Date dataScadenza;
	@Column(name = "nome")
	private String nomeSprint;
	
	@ManyToOne(targetEntity = Release.class)
	@JoinColumn(name = "id_release")
	private Release release;
	
	@OneToMany(mappedBy = "sprint", cascade= {CascadeType.ALL}, orphanRemoval=true)
	private List<ActivitySprint> activitySprint;
	
	
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
	public Release getRelease() {
		return release;
	}
	public void setRelease(Release release) {
		this.release = release;
	}
	public List<ActivitySprint> getActivitySprint() {
		return activitySprint;
	}
	public void setActivitySprint(List<ActivitySprint> activitySprint) {
		this.activitySprint = activitySprint;
	}	
	
}
