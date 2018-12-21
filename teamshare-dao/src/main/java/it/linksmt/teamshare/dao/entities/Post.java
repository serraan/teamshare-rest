package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;
import java.util.Date;
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

	private static final long serialVersionUID = -1458400562028096121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "titolo")
	private String titoloPost;
	@Column(name = "descrizione")
	private String descrizionePost;
	@Column(name = "riferimento")
	private String riferimentoPost;

	@OneToOne
	@JoinColumn(name = "id_utente")
	private User utenteCreatore;
	@Column(name = "data_pubblicazione")
	private Date dataPost;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> commento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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