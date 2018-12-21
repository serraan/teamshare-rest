package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.List;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer IdContenutoTeam;
	
	@ManyToOne(targetEntity=Team.class)
	@JoinColumn(name = "id_team")
	private List<Team> lstTeam;
	@ManyToOne(targetEntity=Content.class)
	@JoinColumn(name = "id_contenuto")
	private List<Content> lstContenuto;
	
	public Integer getIdContenutoTeam() {
		return IdContenutoTeam;
	}
	public void setIdContenutoTeam(Integer idContenutoTeam) {
		IdContenutoTeam = idContenutoTeam;
	}
	public List<Team> getLstTeam() {
		return lstTeam;
	}
	public void setLstTeam(List<Team> lstTeam) {
		this.lstTeam = lstTeam;
	}
	public List<Content> getLstContenutoo() {
		return lstContenuto;
	}
	public void setLstContenuto(List<Content> lstContenuto) {
		this.lstContenuto = lstContenuto;
	}
	
}
