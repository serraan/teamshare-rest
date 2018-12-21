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
import javax.persistence.Table;


@Entity
@Table(name = "tb_attivita_stato")
public class ActivityState implements Serializable {

	private static final long serialVersionUID = 3482318305237487718L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer IdAttivitaStato;
	@Column(name = "DataInizio")
	private Date dataInizio;
	@Column(name = "DataFine")
	private Date dataFine;
	@ManyToMany
	@JoinColumn(name = "FK_IdAttivita")
	private List<Activity> idAttivita;
	@ManyToMany
	@JoinColumn(name = "FK_IdStato")
	private List<State> idStato;
	
	public Integer getIdAttivitaStato() {
		return IdAttivitaStato;
	}
	public void setIdAttivitaStato(Integer idAttivitaStato) {
		IdAttivitaStato = idAttivitaStato;
	}
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
	public List<Activity> getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(List<Activity> idAttivita) {
		this.idAttivita = idAttivita;
	}
	public List<State> getIdStato() {
		return idStato;
	}
	public void setIdStato(List<State> idStato) {
		this.idStato = idStato;
	}
	
}
