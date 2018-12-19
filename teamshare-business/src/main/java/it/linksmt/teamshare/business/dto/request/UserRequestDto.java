package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

public class UserRequestDto implements Serializable {
	
	private static final long serialVersionUID = 8289143077979931763L;
	
	private String nome;
	
	private String cognome;
	
	private Date dataNascita;
	
	private String email;
	
	private String password;
	
	private Blob avatar;

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
		return avatar;
	}

	public void setAvatar(Blob avatar) {
		this.avatar = avatar;
	}
	
	
	
}
