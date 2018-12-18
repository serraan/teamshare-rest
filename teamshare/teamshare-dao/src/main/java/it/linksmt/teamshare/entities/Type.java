package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipo")
public class Type implements Serializable{

	private static final long serialVersionUID = -6260035158642141928L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTipo;
	@Column(name = "Nome")
	private String nomeTipo;
	@Column(name = "PathImmagine")
	private String pathImmagine;
	
	@ManyToMany(mappedBy = "idTipo")
	private List<Reaction> reazione;
	
	public Integer getId() {
		return idTipo;
	}
	public void setId(Integer idTipo) {
		this.idTipo = idTipo;
	}
	public String getNomeTipo() {
		return nomeTipo;
	}
	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}
	public String getPathImmagine() {
		return pathImmagine;
	}
	public void setPathImmagine(String pathImmagine) {
		this.pathImmagine = pathImmagine;
	}
	
}
