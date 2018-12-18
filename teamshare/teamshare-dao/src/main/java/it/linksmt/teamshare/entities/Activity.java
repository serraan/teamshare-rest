package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_attivita")
public class Activity implements Serializable{

	private static final long serialVersionUID = 877546176463513619L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdAttivita")
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
	@JoinColumn(name = "FK_IdUtenteCreatore")
	private User utenteCreatore;
	@OneToOne
	@JoinColumn(name = "FK_IdUtenteAssegnatario")
	private User utenteAssegnatario;
	@Column(name = "DataPresaIncarico")
	private Date dataPresaCarico;
	
	
	@ManyToMany(mappedBy = "idAttivita")
	private List<ActivityState> activityState;
	@ManyToMany(mappedBy = "idAttivita")
	private List<ActivitySprint> activitySprint;
	@OneToMany(mappedBy = "idAttivita")
	private List<Note> note;
	
	public User getUtenteCreatore() {
		return utenteCreatore;
	}
	public void setUtenteCreatore(User utenteCreatore) {
		this.utenteCreatore = utenteCreatore;
	}
	public User getUtenteAssegnatario() {
		return utenteAssegnatario;
	}
	public void setUtenteAssegnatario(User utenteAssegnatario) {
		this.utenteAssegnatario = utenteAssegnatario;
	}
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

	public Date getDataPresaCarico() {
		return dataPresaCarico;
	}
	public void setDataPresaCarico(Date dataPresaIncarico) {
		this.dataPresaCarico = dataPresaIncarico;
	}
	
	
}
