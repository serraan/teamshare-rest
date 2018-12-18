package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.List;

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
	private Integer idTeam;
	@Column(name = "NomeTeam")
	private String nomeTeam;
	
	@OneToMany(mappedBy = "idTeam")
	private List<Impediment> impediment;
	@ManyToMany(mappedBy = "idTeam")
	private List<TeamContent> teamContenuto;
	@ManyToMany(mappedBy = "idTeam")
	private List<UserTeam> utenteTeam;
	
	public Integer getId() {
		return idTeam;
	}
	public void setId(Integer idTeam) {
		this.idTeam = idTeam;
	}
	public String getNomeTeam() {
		return nomeTeam;
	}
	public void setNomeTeam(String nomeTeam) {
		this.nomeTeam = nomeTeam;
	}
	
	
}
