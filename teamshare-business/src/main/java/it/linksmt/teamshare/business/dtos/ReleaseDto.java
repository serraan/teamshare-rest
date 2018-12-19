package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

public class ReleaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4134839869864270598L;

	private Integer id;

	private String nome;

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

}
