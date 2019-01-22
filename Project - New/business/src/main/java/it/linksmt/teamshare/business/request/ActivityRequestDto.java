package it.linksmt.teamshare.business.request;

import java.io.Serializable;
import java.util.Date;

public class ActivityRequestDto implements Serializable{


	private static final long serialVersionUID = -2335454080091852036L;
	
	private String titolo;
	private String descrizione;
	private String tipo;
	private String priorita;
	private Integer idUtenteCreatore;
	private Integer idUtenteAssegnatario;
	private Date dataPresaInCarico;
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPriorita() {
		return priorita;
	}
	public void setPriorita(String priorita) {
		this.priorita = priorita;
	}
	public Integer getIdUtenteCreatore() {
		return idUtenteCreatore;
	}
	public void setIdUtenteCreatore(Integer idUtenteCreatore) {
		this.idUtenteCreatore = idUtenteCreatore;
	}
	public Integer getIdUtenteAssegnatario() {
		return idUtenteAssegnatario;
	}
	public void setIdUtenteAssegnatario(Integer idUtenteAssegnatario) {
		this.idUtenteAssegnatario = idUtenteAssegnatario;
	}
	public Date getDataPresaInCarico() {
		return dataPresaInCarico;
	}
	public void setDataPresaInCarico(Date dataPresaCarico) {
		this.dataPresaInCarico = dataPresaCarico;
	}
	
}
