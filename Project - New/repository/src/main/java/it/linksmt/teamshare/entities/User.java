package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_utente")
public class User implements Serializable{

	private static final long serialVersionUID = 6197130342670307616L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "data_nascita")
	private Date dataNascita;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "avatar")
	private Blob Avatar;
	
	
	@OneToMany(mappedBy = "utente", cascade= {CascadeType.ALL}, orphanRemoval=true)
	private List<Comment> commento;
	@OneToMany(mappedBy = "utenteCreatore", cascade= {CascadeType.ALL}, orphanRemoval=true)
	private List<Content> contenuto;
	@OneToMany(mappedBy = "utente", cascade= {CascadeType.ALL}, orphanRemoval=true)
	private List<Post> post;
	@OneToMany(mappedBy = "utente", cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<Reaction> reazione;
	@OneToMany(mappedBy = "utente", cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<UserTeam> utenteTeam;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Blob getAvatar() {
		return Avatar;
	}
	public void setAvatar(Blob avatar) {
		Avatar = avatar;
	}
	public List<Comment> getCommento() {
		return commento;
	}
	public void setCommento(List<Comment> commento) {
		this.commento = commento;
	}
	public List<Content> getContenuto() {
		return contenuto;
	}
	public void setContenuto(List<Content> contenuto) {
		this.contenuto = contenuto;
	}
	public List<Post> getPost() {
		return post;
	}
	public void setPost(List<Post> post) {
		this.post = post;
	}
	public List<Reaction> getReazione() {
		return reazione;
	}
	public void setReazione(List<Reaction> reazione) {
		this.reazione = reazione;
	}
	public List<UserTeam> getUtenteTeam() {
		return utenteTeam;
	}
	public void setUtenteTeam(List<UserTeam> utenteTeam) {
		this.utenteTeam = utenteTeam;
	}
	
	

}
