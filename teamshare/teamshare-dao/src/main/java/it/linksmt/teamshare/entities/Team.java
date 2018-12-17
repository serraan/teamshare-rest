package it.linksmt.teamshare.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_team")
public class Team implements Serializable{

	private static final long serialVersionUID = -1919092312122607968L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "Nome_Team")
	private String nomeTeam;
	
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
	
	
}
