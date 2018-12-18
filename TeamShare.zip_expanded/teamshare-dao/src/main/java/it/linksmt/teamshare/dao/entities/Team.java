package it.linksmt.teamshare.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_team")
public class Team {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer idTeam;

	@Column(name="NomeTeam")
	private String nomeTeam;

	public Integer getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}

	public String getNomeTeam() {
		return nomeTeam;
	}

	public void setNomeTeam(String nomeTeam) {
		this.nomeTeam = nomeTeam;
	}

}
