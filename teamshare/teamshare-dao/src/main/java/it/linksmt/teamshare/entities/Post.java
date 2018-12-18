package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_post")
public class Post implements Serializable{

	private static final long serialVersionUID = -1458400562028096121L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPost;
	@Column(name = "Titolo")
	private String titoloPost;
	@Column(name = "Descrizione")
	private String descrizionePost;
	@Column(name = "Riferimento")
	private String riferimentoPost;
	
	@ManyToOne
	@JoinColumn(name = "FK_IdUtente")
	private User utenteCreatore;
	@Column(name = "DataPubblicazione")
	private Date dataPost;
	
	@OneToMany(mappedBy = "idPost")
	private List<Comment> commento;
	
	public Integer getIdPost() {
		return idPost;
	}
	public void setIdPost(Integer idPost) {
		this.idPost = idPost;
	}
	public String getTitoloPost() {
		return titoloPost;
	}
	public void setTitoloPost(String titoloPost) {
		this.titoloPost = titoloPost;
	}
	public String getDescrizionePost() {
		return descrizionePost;
	}
	public void setDescrizionePost(String descrizionePost) {
		this.descrizionePost = descrizionePost;
	}
	public String getRiferimentoPost() {
		return riferimentoPost;
	}
	public void setRiferimentoPost(String riferimentoPost) {
		this.riferimentoPost = riferimentoPost;
	}
	public User getUtenteCreatore() {
		return utenteCreatore;
	}
	public void setUtenteCreatore(User utenteCreatore) {
		this.utenteCreatore = utenteCreatore;
	}
	public Date getDataPost() {
		return dataPost;
	}
	public void setDataPost(Date dataPost) {
		this.dataPost = dataPost;
	}
	
	
}
