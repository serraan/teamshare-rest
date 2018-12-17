package it.linksmt.teamshare.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_release")
public class Release implements Serializable{

	private static final long serialVersionUID = -7846720263271395516L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRelease;
	@Column(name = "Nome_Release")
	private String nomeRelease;
	
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
