package it.linksmt.teamshare.entities;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_post")
public class Post implements Serializable{

	private static final long serialVersionUID = -1458400562028096121L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "titolo")
	private String titoloPost;
	@Column(name = "descrizione")
	private String descrizionePost;
	@Column(name = "riferimento")
	private String riferimentoPost;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "id_utente", referencedColumnName = "id")
	private User utente;
	@Column(name = "data_pubblicazione")
	private Date dataPost;
	
	@OneToMany(mappedBy = "post", cascade= {CascadeType.ALL}, orphanRemoval=true)
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

	public User getUtente() {
		return utente;
	}

	public void setUtente(User utente) {
		this.utente = utente;
	}

	public Date getDataPost() {
		return dataPost;
	}

	public void setDataPost(Date dataPost) {
		this.dataPost = dataPost;
	}

	public List<Comment> getCommento() {
		return commento;
	}

	public void setCommento(List<Comment> commento) {
		this.commento = commento;
	}
	


	
	
}
