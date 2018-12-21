package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_team")
public class Team implements Serializable{

	private static final long serialVersionUID = -1919092312122607968L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome")
	private String nomeTeam;
	
	@OneToMany(mappedBy ="team", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Impediment> lstImpediment;
	@OneToMany(mappedBy = "lstTeam", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<TeamContent> lstTeamContenuto;

	 @ManyToMany(mappedBy = "teams")
	 private List<User> utenti = new ArrayList<>();
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
	public List<Impediment> getLstImpediment() {
		return lstImpediment;
	}
	public void setLstImpediment(List<Impediment> lstImpediment) {
		this.lstImpediment = lstImpediment;
	}
	public List<TeamContent> getLstTeamContenuto() {
		return lstTeamContenuto;
	}
	public void setLstTeamContenuto(List<TeamContent> lstTeamContenuto) {
		this.lstTeamContenuto = lstTeamContenuto;
	}
	public List<User> getUtenti() {
		return utenti;
	}
	public void setUtenti(List<User> utenti) {
		this.utenti = utenti;
	}

	
	
}
