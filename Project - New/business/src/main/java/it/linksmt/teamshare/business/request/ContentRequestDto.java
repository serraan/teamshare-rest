package it.linksmt.teamshare.business.request;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

public class ContentRequestDto implements Serializable {

	private static final long serialVersionUID = -5232032529172775963L;

	private String titolo;

	private String nome_file;

	private String formato_file;

	private Blob file;

	private String url;

	private Date data_pubblicazione;

	private Integer idUtenteCreatore;

	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getIdUtenteCreatore() {
		return idUtenteCreatore;
	}

	public void setIdUtenteCreatore(Integer idUtenteCreatore) {
		this.idUtenteCreatore = idUtenteCreatore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Blob getFile() {
		return file;
	}

	public void setFile(Blob file) {
		this.file = file;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNome_file() {
		return nome_file;
	}

	public void setNome_file(String nome_file) {
		this.nome_file = nome_file;
	}

	public String getFormato_file() {
		return formato_file;
	}

	public void setFormato_file(String formato_file) {
		this.formato_file = formato_file;
	}

	public Date getData_pubblicazione() {
		return data_pubblicazione;
	}

	public void setData_pubblicazione(Date data_pubblicazione) {
		this.data_pubblicazione = data_pubblicazione;
	}

}
