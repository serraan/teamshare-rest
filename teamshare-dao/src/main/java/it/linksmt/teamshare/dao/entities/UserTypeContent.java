package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_utente_tipo_contenuto")
public class UserTypeContent implements Serializable{
	
	private static final long serialVersionUID = -9189730108168769048L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "id_utente")
	private User idUser; 
	
	@ManyToOne
    @JoinColumn(name = "id_tipo")
	private Type idType; 
	
	@ManyToOne
    @JoinColumn(name = "id_contenuto")
	private Content idContent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public Type getIdType() {
		return idType;
	}

	public void setIdType(Type idType) {
		this.idType = idType;
	}

	public Content getIdContent() {
		return idContent;
	}

	public void setIdContent(Content idContent) {
		this.idContent = idContent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
