package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4255585813610430123L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column(name="titolo")
	private String title;

	@Column(name="descrizione")
	private String description;

	@Column(name ="rifermento")
	private String reference;

	@Column(name = "idUtente")
	private Integer userCreator;


	public Integer getUserCreator() {
		return userCreator;
	}

	public void setUserCreator(Integer userCreator) {
		this.userCreator = userCreator;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String riferimento) {
		this.reference = riferimento;
	}



}
