package it.linksmt.teamshare.business.request;

import java.io.Serializable;
import java.util.Date;

public class PostRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1387886715308234152L;

	private String titoloPost;
	private String descrizionePost;
	private String riferimentoPost;
	private Integer idUtente;
	private Date dataPost;
	
	public String getTitoloPost() {
		return titoloPost;
	}
	public void setTitoloPost(String titoloPost) {
		this.titoloPost = titoloPost;
	}
	public String getDescrizionePost() {
		return descrizionePost;
	}
	public void setDescrizionePost(String descrizionePost) {
		this.descrizionePost = descrizionePost;
	}
	public String getRiferimentoPost() {
		return riferimentoPost;
	}
	public void setRiferimentoPost(String riferimentoPost) {
		this.riferimentoPost = riferimentoPost;
	}
	public Integer getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}
	public Date getDataPost() {
		return dataPost;
	}
	public void setDataPost(Date dataPost) {
		this.dataPost = dataPost;
	}

}
