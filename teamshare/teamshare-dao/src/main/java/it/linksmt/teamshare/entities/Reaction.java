package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_utente_tipo_contenuto")
public class Reaction implements Serializable{

	private static final long serialVersionUID = 4851689194389277202L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "id_utente")
	private List<User> lstUtente;
	@ManyToOne(targetEntity =  Content.class)
	@JoinColumn(name = "id_contenuto")
	private List<Content> lstContenuto;
	@ManyToOne(targetEntity=Type.class)
	@JoinColumn(name = "id_tipo")
	private List<Type> lstTipo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<User> getLstUtente() {
		return lstUtente;
	}
	public void setLstUtente(List<User> lstUtente) {
		this.lstUtente = lstUtente;
	}
	public List<Content> getLstContenuto() {
		return lstContenuto;
	}
	public void setLstContenuto(List<Content> lstContenuto) {
		this.lstContenuto = lstContenuto;
	}
	public List<Type> getLstTipo() {
		return lstTipo;
	}
	public void setLstTipo(List<Type> lstTipo) {
		this.lstTipo = lstTipo;
	}
	
}
