package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_attivita_sprint")
public class ActivitySprint implements Serializable{

	private static final long serialVersionUID = 1100015012130654286L;

	@ManyToMany
	@JoinColumn(name = "FK_IdAttivita")
	private List<Activity> idAttivita;
	
	@ManyToMany
	@JoinColumn(name = "FK_IdSprint")
	private List<Sprint> idSprint;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idAttivitaSprint;
	
	public List<Activity> getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(List<Activity> idAttivita) {
		this.idAttivita = idAttivita;
	}
	public List<Sprint> getIdSprint() {
		return idSprint;
	}
	public void setIdSprint(List<Sprint> idSprint) {
		this.idSprint = idSprint;
	}
	public Integer getIdAttivitaSprint() {
		return idAttivitaSprint;
	}
	public void setIdAttivitaSprint(Integer idAttivitaSprint) {
		this.idAttivitaSprint = idAttivitaSprint;
	}
	
	
}
