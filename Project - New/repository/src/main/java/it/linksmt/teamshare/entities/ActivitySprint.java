package it.linksmt.teamshare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_attivita_sprint")
public class ActivitySprint implements Serializable{

	private static final long serialVersionUID = 1100015012130654286L;

	@ManyToOne(targetEntity = Activity.class)
	@JoinColumn(name = "id_attivita")
	private Activity attivita;
	
	@ManyToOne(targetEntity = Sprint.class)
	@JoinColumn(name = "id_sprint")
	private Sprint sprint;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Activity getAttivita() {
		return attivita;
	}
	public void setAttivita(Activity attivita) {
		this.attivita = attivita;
	}
	public Sprint getSprint() {
		return sprint;
	}
	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
	
}
