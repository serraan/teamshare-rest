package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_impediment")
public class Impediment implements Serializable{

	private static final long serialVersionUID = 1182943674958793803L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "descrizione")
	private String descizione;
	@Column(name = "data")
	private Date data;
	
	
	@ManyToOne(targetEntity = Team.class)
	@JoinColumn(name = "id_team", referencedColumnName = "id")
	private Team team;
	
	@OneToOne
	@JoinColumn(name = "id_attivita")
	private Activity attivita;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescizione() {
		return descizione;
	}
	public void setDescizione(String descizione) {
		this.descizione = descizione;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Activity getAttivita() {
		return attivita;
	}
	public void setAttivita(Activity attivita) {
		this.attivita = attivita;
	}


	
	
}
