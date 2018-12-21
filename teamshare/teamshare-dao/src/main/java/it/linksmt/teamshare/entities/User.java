package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_utente")
public class User implements Serializable {

	private static final long serialVersionUID = 6197130342670307616L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> commento;
	@OneToMany(mappedBy = "utenteCreatore", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Content> contenuto;
	@OneToMany(mappedBy = "utenteCreatore", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Post> post;
	@OneToMany(mappedBy = "lstUtente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reaction> reazione;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tb_utente_team", joinColumns = @JoinColumn(name = "id_utente"), 
	inverseJoinColumns = @JoinColumn(name = "id_team"))
	private List<Team> teams = new ArrayList<>();

	public void addTeam(Team team) {
		teams.add(team);
		team.getUtenti().add(this);
	}

	public void removeTeam(Team team) {
		teams.remove(team);
		team.getUtenti().remove(this);
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

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

}
