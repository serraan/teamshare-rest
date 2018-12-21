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
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_attivita_stato")
public class ActivityState implements Serializable {

	private static final long serialVersionUID = 3482318305237487718L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer IdAttivitaStato;
	@Column(name = "data_inizio")
	private Date dataInizio;
	@Column(name = "data_fine")
	private Date dataFine;
	@ManyToOne(targetEntity=Activity.class)
	@JoinColumn(name = "id_attivita")
	private List<Activity> lstAttivita;
	@ManyToOne(targetEntity=State.class)
	@JoinColumn(name = "id_stato")
	private List<State> lstStato;
	
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
	public List<Activity> getLstAttivita() {
		return lstAttivita;
	}
	public void setLstAttivita(List<Activity> lstAttivita) {
		this.lstAttivita = lstAttivita;
	}
	public List<State> getLstStato() {
		return lstStato;
	}
	public void setLstStato(List<State> lstStato) {
		this.lstStato = lstStato;
	}
	
}
