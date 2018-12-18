package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.List;

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
	private Integer idRelease;
	@Column(name = "Nome")
	private String nomeRelease;
	
	@OneToMany(mappedBy = "idRelease")
	private List<Sprint> sprint;
	
	public Integer getIdRelease() {
		return idRelease;
	}
	public void setIdRelease(Integer idRelease) {
		this.idRelease = idRelease;
	}
	public String getNomeRelease() {
		return nomeRelease;
	}
	public void setNomeRelease(String nomeRelease) {
		this.nomeRelease = nomeRelease;
	}
	
	
}
