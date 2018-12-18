package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contenuto_team")
public class TeamContent implements Serializable{

	private static final long serialVersionUID = -2511951469203915266L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer IdContenutoTeam;
	
	@ManyToMany
	@JoinColumn(name = "FK_IdTeam")
	private List<Team> idTeam;
	@ManyToMany
	@JoinColumn(name = "FK_IdContenuto")
	private List<Content> idContenuto;
	
	public Integer getIdContenutoTeam() {
		return IdContenutoTeam;
	}
	public void setIdContenutoTeam(Integer idContenutoTeam) {
		IdContenutoTeam = idContenutoTeam;
	}
	public List<Team> getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(List<Team> idTeam) {
		this.idTeam = idTeam;
	}
	public List<Content> getIdContenuto() {
		return idContenuto;
	}
	public void setIdContenuto(List<Content> idContenuto) {
		this.idContenuto = idContenuto;
	}
	
}
