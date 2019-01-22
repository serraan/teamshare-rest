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
@Table(name = "tb_contenuto_team")
public class TeamContent implements Serializable{

	private static final long serialVersionUID = -2511951469203915266L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	@ManyToOne(targetEntity = Team.class)
	@JoinColumn(name = "id_team", referencedColumnName = "id")
	private Team team;
	@ManyToOne(targetEntity = Content.class)
	@JoinColumn(name = "id_contenuto", referencedColumnName = "id")
	private Content contenuto;
	

	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Content getContenuto() {
		return contenuto;
	}
	public void setContenuto(Content contenuto) {
		this.contenuto = contenuto;
	}

	
}
