package it.linksmt.teamshare.dao.entities;

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
public class Team implements Serializable {
	
	private static final long serialVersionUID = -8466080830339740626L;
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome")
	private String name;
	
	@OneToMany(mappedBy = "team" , cascade=CascadeType.ALL)
	private List<ContentTeam> listContentTeam;
	
	@OneToMany(mappedBy = "team" , cascade=CascadeType.ALL)
	private List<UserTeam> listUserTeam;
	
	@OneToMany(mappedBy = "team" , cascade=CascadeType.ALL)
	private List<Impediment> listImpediment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ContentTeam> getListContentTeam() {
		return listContentTeam;
	}

	public void setListContentTeam(List<ContentTeam> listContentTeam) {
		this.listContentTeam = listContentTeam;
	}

	public List<UserTeam> getListUserTeam() {
		return listUserTeam;
	}

	public void setListUserTeam(List<UserTeam> listUserTeam) {
		this.listUserTeam = listUserTeam;
	}

	public List<Impediment> getListImpediment() {
		return listImpediment;
	}

	public void setListImpediment(List<Impediment> listImpediment) {
		this.listImpediment = listImpediment;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", listContentTeam=" + listContentTeam + ", listUserTeam="
				+ listUserTeam + ", listImpediment=" + listImpediment + "]";
	}
	
}
