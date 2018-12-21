package it.linksmt.teamshare.business.request;

import java.io.Serializable;
import java.util.Date;

public class CommentRequestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6276587944203358614L;

	private String testoCommento;
	
	private Date dataPubblicazione;
	

	private Integer idPost;
	
	private Integer idUtente;

	public String getTestoCommento() {
		return testoCommento;
	}

	public void setTestoCommento(String testoCommento) {
		this.testoCommento = testoCommento;
	}

	public Integer getIdPost() {
		return idPost;
	}

	public void setIdPost(Integer idPost) {
		this.idPost = idPost;
	}

	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	
	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}
	
	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}
}
