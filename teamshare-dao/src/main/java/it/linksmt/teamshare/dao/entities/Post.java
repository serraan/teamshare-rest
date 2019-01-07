package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_post")
public class Post implements Serializable {

	private static final long serialVersionUID = -3853231229292705347L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "titolo")
	private String title;
	
	@Column(name = "descrizione")
	private String description;
	
	@Column(name = "riferimento")
	private String reference;
	
	@Column(name = "data_pubblicazione")
	private Date publicationDate;
	
	@OneToOne
	@JoinColumn(name = "id_utente")
	private User user;
	
	@OneToMany(mappedBy = "post" , cascade=CascadeType.ALL)
	private List<Comment> listComment;
	
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

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPuSblicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(List<Comment> listComment) {
		this.listComment = listComment;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", reference=" + reference
				+ ", publicationDate=" + publicationDate + ", user=" + user + ", listComment=" + listComment + "]";
	}

}
