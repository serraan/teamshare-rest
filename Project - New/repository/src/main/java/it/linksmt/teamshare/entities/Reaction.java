package it.linksmt.teamshare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_reazione")
public class Reaction implements Serializable{

	private static final long serialVersionUID = 4851689194389277202L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "id_utente", referencedColumnName = "id")
	private User utente;
	@ManyToOne(targetEntity = Content.class)
	@JoinColumn(name = "id_contenuto", referencedColumnName = "id")
	private Content contenuto;
	@ManyToOne(targetEntity = Type.class)
	@JoinColumn(name = "id_tipo", referencedColumnName = "id")
	private Type tipo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUtente() {
		return utente;
	}
	public void setUtente(User utente) {
		this.utente = utente;
	}
	public Content getContenuto() {
		return contenuto;
	}
	public void setContenuto(Content contenuto) {
		this.contenuto = contenuto;
	}
	public Type getTipo() {
		return tipo;
	}
	public void setTipo(Type tipo) {
		this.tipo = tipo;
	}
	
}
