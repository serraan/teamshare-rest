package it.linksmt.teamshare.business.request;

import java.io.Serializable;

public class CommentRequestDto implements Serializable{
	private static final long serialVersionUID = 3407230318540115255L;
	
	
	private String testoCommento;
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
	
	
}


