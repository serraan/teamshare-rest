package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_reazione")
public class Reaction implements Serializable{

	private static final long serialVersionUID = 4851689194389277202L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdReazione;
	
	
	@ManyToMany
	@JoinColumn(name = "idUtente")
	private List<User> idUtente;
	@ManyToMany
	@JoinColumn(name = "FK_IdContenuto")
	private List<Content> idContenuto;
	@ManyToMany
	@JoinColumn(name = "FK_IdTipo")
	private List<Type> idTipo;
	
	public List<User> getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(List<User> idUtente) {
		this.idUtente = idUtente;
	}
	public List<Content> getIdContenuto() {
		return idContenuto;
	}
	public void setIdContenuto(List<Content> idContenuto) {
		this.idContenuto = idContenuto;
	}
	public List<Type> getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(List<Type> idTipo) {
		this.idTipo = idTipo;
	}
	
}
