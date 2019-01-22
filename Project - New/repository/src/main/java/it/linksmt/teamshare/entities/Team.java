package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_team")
public class Team implements Serializable{

	private static final long serialVersionUID = -1919092312122607968L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome_team")
	private String nomeTeam;
	
	@OneToMany(mappedBy = "team", cascade= {CascadeType.ALL}, orphanRemoval=true)
	private List<Impediment> impediment;
	@OneToMany(mappedBy = "team", cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<TeamContent> teamContenuto;
	@OneToMany(mappedBy = "team", cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<UserTeam> utenteTeam;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeTeam() {
		return nomeTeam;
	}
	public void setNomeTeam(String nomeTeam) {
		this.nomeTeam = nomeTeam;
	}
	public List<Impediment> getImpediment() {
		return impediment;
	}
	public void setImpediment(List<Impediment> impediment) {
		this.impediment = impediment;
	}
	public List<TeamContent> getTeamContenuto() {
		return teamContenuto;
	}
	public void setTeamContenuto(List<TeamContent> teamContenuto) {
		this.teamContenuto = teamContenuto;
	}
	public List<UserTeam> getUtenteTeam() {
		return utenteTeam;
	}
	public void setUtenteTeam(List<UserTeam> utenteTeam) {
		this.utenteTeam = utenteTeam;
	}
	
	
}
