package it.linksmt.teamshare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_team_vede_contenuto")
public class TeamContent implements Serializable{

	private static final long serialVersionUID = -2511951469203915266L;

	@Id
	@ManyToMany
	@JoinColumn(name = "idTeam")
	private Team idTeam;
	@Id
	@ManyToMany
	@JoinColumn(name = "idContenuto")
	private Content idContenuto;
	
	public Team getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(Team idTeam) {
		this.idTeam = idTeam;
	}
	public Content getIdContenuto() {
		return idContenuto;
	}
	public void setIdContenuto(Content idContenuto) {
		this.idContenuto = idContenuto;
	}
	
}
