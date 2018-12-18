package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_post")
public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4255585813610430123L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Titolo")
	private String title;

	@Column(name = "Descrizione")
	private String description;

	@Column(name = "Rifermento")
	private String reference;

	@Column(name = "DataPubblicazione")
	private Date datePublication;

	@ManyToOne
	@JoinColumn(name="FK_IdUtente")
	private User userCreator;

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public User getUserCreator() {
		return userCreator;
	}

	public void setUserCreator(User userCreator) {
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
