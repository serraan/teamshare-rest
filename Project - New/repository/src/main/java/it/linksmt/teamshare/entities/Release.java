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
@Table(name = "tb_release")
public class Release implements Serializable{

	private static final long serialVersionUID = -7846720263271395516L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome")
	private String nomeRelease;
	
	@OneToMany(mappedBy = "release",cascade = {CascadeType.ALL},orphanRemoval = true)
	private List<Sprint> sprint;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeRelease() {
		return nomeRelease;
	}
	public void setNomeRelease(String nomeRelease) {
		this.nomeRelease = nomeRelease;
	}
	public List<Sprint> getSprint() {
		return sprint;
	}
	public void setSprint(List<Sprint> sprint) {
		this.sprint = sprint;
	}
	
	
}
