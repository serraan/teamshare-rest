package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_attivita")
public class Activity implements Serializable{

	private static final long serialVersionUID = 877546176463513619L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "titolo")
	private String titolo;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "priorita")
	private String priorita;
	
	@Column(name = "data_presa_in_carico")
	private Date dataPresaIncarico;

	@OneToOne
	@JoinColumn(name = "id_utente_assegnatario")
	private User utenteCreatore;
	
	@OneToOne
	@JoinColumn(name = "id_utente_creatore")
	private User utenteAssegnatario;
	
	/*
		@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "zone_dealer", joinColumns = @JoinColumn(name = "id_zone", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_dealer", referencedColumnName = "id"))
	private List<Dealer> dealers;

	*/
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_attivita_sprint", joinColumns = @JoinColumn(name = "id_attivita", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_sprint", referencedColumnName = "id"))
	private List<Sprint> sprints;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDataPresaIncarico() {
		return dataPresaIncarico;
	}

	public void setDataPresaIncarico(Date dataPresaIncarico) {
		this.dataPresaIncarico = dataPresaIncarico;
	}

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

	public List<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

}
