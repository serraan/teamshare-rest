package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.util.Date;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "data_inizio")
	private Date dataInizio;
	@Column(name = "data_fine")
	private Date dataFine;
	
	@ManyToOne(targetEntity = Activity.class)
	@JoinColumn(name = "id_attivita", referencedColumnName = "id")
	private Activity attivita;
	
	@ManyToOne(targetEntity = State.class)
	@JoinColumn(name = "id_stato", referencedColumnName = "id")
	private State stato;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Activity getAttivita() {
		return attivita;
	}
	public void setAttivita(Activity attivita) {
		this.attivita = attivita;
	}
	public State getStato() {
		return stato;
	}
	public void setStato(State stato) {
		this.stato = stato;
	}


	
}
