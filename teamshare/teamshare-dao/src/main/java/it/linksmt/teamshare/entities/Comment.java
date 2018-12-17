package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_commento")
public class Comment implements Serializable{

	private static final long serialVersionUID = 5984401241096747568L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idCommento;
	@Column(name = "Test_Commento")
	private String testoCommento;
	@Column(name = "Data_Commento")
	private Date dataCommento;
	@OneToOne
	@JoinColumn(name = "idPost")
	private Post idPost;
	@OneToOne
	@JoinColumn(name = "idUtente")
	private User idUtente;
	
	public Integer getIdCommento() {
		return idCommento;
	}
	public void setIdCommento(Integer idCommento) {
		this.idCommento = idCommento;
	}
	public String getTestoCommento() {
		return testoCommento;
	}
	public void setTestoCommento(String testoCommento) {
		this.testoCommento = testoCommento;
	}
	public Date getDataCommento() {
		return dataCommento;
	}
	public void setDataCommento(Date dataCommento) {
		this.dataCommento = dataCommento;
	}
	public Post getIdPost() {
		return idPost;
	}
	public void setIdPost(Post idPost) {
		this.idPost = idPost;
	}
	public User getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(User idUtente) {
		this.idUtente = idUtente;
	}
	
	
}

