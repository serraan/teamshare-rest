package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;
import java.util.Date;

public class UserAuthenticationDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3726811427727918353L;

	private String jwt;

	private Integer id;
	private String nome;
	private String cognome;
	private String email;
	private Date dataNascita;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId( Integer id ) {
		this.id = id;
	}
	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}
	/**
	 * @param jwt the jwt to set
	 */
	public void setJwt( String jwt ) {
		this.jwt = jwt;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome( String nome ) {
		this.nome = nome;
	}
	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}
	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome( String cognome ) {
		this.cognome = cognome;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail( String email ) {
		this.email = email;
	}
	/**
	 * @return the dataNascita
	 */
	public Date getDataNascita() {
		return dataNascita;
	}
	/**
	 * @param dataNascita the dataNascita to set
	 */
	public void setDataNascita( Date dataNascita ) {
		this.dataNascita = dataNascita;
	}
}
