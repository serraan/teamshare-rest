package it.linksmt.teamshare.business.request;

import java.io.Serializable;

public class TypeRequestDto implements Serializable {

	private static final long serialVersionUID = 8380423186878056358L;
	private String nomeTipo;
	private String pathImmagine;

	public String getNomeTipo() {
		return nomeTipo;
	}
	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}
	public String getPathImmagine() {
		return pathImmagine;
	}
	public void setPathImmagine(String pathImmagine) {
		this.pathImmagine = pathImmagine;
	}	
}
