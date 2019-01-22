package it.linksmt.teamshare.business.request;

import java.io.Serializable;

public class NoteRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4051330274271781263L;

	
	private String Testo;
	private Integer idAttivita;
	

	public String getTesto() {
		return Testo;
	}

	public void setTesto(String testo) {
		Testo = testo;
	}

	public Integer getIdAttivita() {
		return idAttivita;
	}

	public void setIdAttivita(Integer idAttivita) {
		this.idAttivita = idAttivita;
	}

}
