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
@Table(name = "tb_utente_team")
public class UserTeam implements Serializable{

	private static final long serialVersionUID = 8688329666698371783L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUtenteTeam;
	@ManyToMany
	@JoinColumn(name = "idUtente")
	private User idUtente;
	@ManyToMany
	@JoinColumn(name = "idTeam")
	private Team idTeam;
	
	public Integer getIdUtenteTeam() {
		return idUtenteTeam;
	}
	public void setIdUtenteTeam(Integer idUtenteTeam) {
		this.idUtenteTeam = idUtenteTeam;
	}
	public User getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(User idUtente) {
		this.idUtente = idUtente;
	}
	public Team getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(Team idTeam) {
		this.idTeam = idTeam;
	}
	
	
}
