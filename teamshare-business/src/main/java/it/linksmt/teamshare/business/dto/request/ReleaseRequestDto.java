package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;

public class ReleaseRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7833224977894545156L;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
