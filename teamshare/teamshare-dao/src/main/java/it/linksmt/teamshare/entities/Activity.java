package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_attivita")
public class Activity implements Serializable{

	private static final long serialVersionUID = 877546176463513619L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAttivita;
	@Column(name = "Titolo")
	private String titolo;
	@Column(name = "Descrizione")
	private String descrizione;
	@Column(name = "Tipo")
	private String Tipo;
	@Column(name = "Priorita")
	private String Priorita;
	@OneToOne
	@JoinColumn(name = "idUtenteCreatore")
	private User idUtenteCreatore;
	@OneToOne
	@JoinColumn(name = "idUtenteAssegnatario")
	private User idUtenteAssegnatario;
	@Column(name = "Data_Presa_Incarico")
	private Date dataPresaIncarico;
	
	public Integer getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(Integer idAttivita) {
		this.idAttivita = idAttivita;
	}
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
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getPriorita() {
		return Priorita;
	}
	public void setPriorita(String priorita) {
		Priorita = priorita;
	}
	public User getIdUtenteCreatore() {
		return idUtenteCreatore;
	}
	public void setIdUtenteCreatore(User idUtenteCreatore) {
		this.idUtenteCreatore = idUtenteCreatore;
	}
	public User getIdUtenteAssegnatario() {
		return idUtenteAssegnatario;
	}
	public void setIdUtenteAssegnatario(User idUtenteAssegnatario) {
		this.idUtenteAssegnatario = idUtenteAssegnatario;
	}
	public Date getDataPresaIncarico() {
		return dataPresaIncarico;
	}
	public void setDataPresaIncarico(Date dataPresaIncarico) {
		this.dataPresaIncarico = dataPresaIncarico;
	}
	
	
}
