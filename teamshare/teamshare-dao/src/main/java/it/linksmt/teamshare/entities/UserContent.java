package it.linksmt.teamshare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_utente_reagisce_contenuto")
public class UserContent implements Serializable{

	private static final long serialVersionUID = 4851689194389277202L;

	@Id
	@ManyToMany
	@JoinColumn(name = "idUtente")
	private User idUtente;
	@Id
	@ManyToMany
	@JoinColumn(name = "idContenuto")
	private Content idContenuto;
	@Id
	@ManyToMany
	@JoinColumn(name = "idTipo")
	private Type idTipo;
	
	public User getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(User idUtente) {
		this.idUtente = idUtente;
	}
	public Content getIdContenuto() {
		return idContenuto;
	}
	public void setIdContenuto(Content idContenuto) {
		this.idContenuto = idContenuto;
	}
	public Type getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Type idTipo) {
		this.idTipo = idTipo;
	}
	
}
