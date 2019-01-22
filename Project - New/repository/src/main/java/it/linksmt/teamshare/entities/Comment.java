package it.linksmt.teamshare.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_commento")
public class Comment implements Serializable{

	private static final long serialVersionUID = 5984401241096747568L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "testo")
	private String testoCommento;
	
	
	@ManyToOne(targetEntity = Post.class)
	@JoinColumn(name = "id_post", referencedColumnName = "id")
	private Post post;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "id_utente", referencedColumnName = "id")
	private User utente;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTestoCommento() {
		return testoCommento;
	}
	public void setTestoCommento(String testoCommento) {
		this.testoCommento = testoCommento;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public User getUtente() {
		return utente;
	}
	public void setUtente(User utente) {
		this.utente = utente;
	}

	
	
}

