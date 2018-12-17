package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import javax.persistence.Table;


@Entity
@Table(name = "attivita_stato")
public class ActivityState implements Serializable {

	private static final long serialVersionUID = 3482318305237487718L;

	@Column(name = "Data_Inizio")
	private Date dataInizio;
	@Column(name = "Data_Fine")
	private Date dataFine;
	@ManyToMany
	@JoinColumn(name = "idAttivita")
	private Activity idAttivita;
	@ManyToMany
	@JoinColumn(name = "idStato")
	private State idStato;
	
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public Activity getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(Activity idAttivita) {
		this.idAttivita = idAttivita;
	}
	public State getIdStato() {
		return idStato;
	}
	public void setIdStato(State idStato) {
		this.idStato = idStato;
	}
	
}
