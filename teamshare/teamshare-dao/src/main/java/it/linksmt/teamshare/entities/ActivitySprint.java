package it.linksmt.teamshare.entities;

import java.io.Serializable;

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
	@JoinColumn(name = "idAttivita")
	private Activity idAttivita;
	@ManyToMany
	@JoinColumn(name = "idSprint")
	private Sprint idSprint;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idAttivitaSprint;
	
	public Activity getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(Activity idAttivita) {
		this.idAttivita = idAttivita;
	}
	public Sprint getIdSprint() {
		return idSprint;
	}
	public void setIdSprint(Sprint idSprint) {
		this.idSprint = idSprint;
	}
	public Integer getIdAttivitaSprint() {
		return idAttivitaSprint;
	}
	public void setIdAttivitaSprint(Integer idAttivitaSprint) {
		this.idAttivitaSprint = idAttivitaSprint;
	}
	
	
}
