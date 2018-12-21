package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;

public class StateRequestDto implements Serializable{

	private static final long serialVersionUID = 7070676177231838491L;

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
}
