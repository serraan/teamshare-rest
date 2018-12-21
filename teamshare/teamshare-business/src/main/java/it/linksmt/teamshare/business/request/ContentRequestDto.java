package it.linksmt.teamshare.business.request;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

public class ContentRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3995229573703388813L;

	private String titolo;
	
	private String nomeFile;
	
	private String formatoFile;

	private Blob file;

	private Blob url;

	private Date dataCondivisione;

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getFormatoFile() {
		return formatoFile;
	}

	public void setFormatoFile(String formatoFile) {
		this.formatoFile = formatoFile;
	}

	public Blob getFile() {
		return file;
	}

	public void setFile(Blob file) {
		this.file = file;
	}

	public Blob getUrl() {
		return url;
	}

	public void setUrl(Blob url) {
		this.url = url;
	}

	public Date getDataCondivisione() {
		return dataCondivisione;
	}

	public void setDataCondivisione(Date dataCondivisione) {
		this.dataCondivisione = dataCondivisione;
	}


}
