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
@Table(name = "tb_tipo")
public class Type implements Serializable{

	private static final long serialVersionUID = -6260035158642141928L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome")
	private String nomeTipo;
	@Column(name = "path_immagine")
	private String pathImmagine;
	
	@OneToMany(mappedBy = "tipo", cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<Reaction> reazione;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public List<Reaction> getReazione() {
		return reazione;
	}
	public void setReazione(List<Reaction> reazione) {
		this.reazione = reazione;
	}
	
}
