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
@Table(name = "tb_impediment")
public class Impediment implements Serializable{

	private static final long serialVersionUID = 1182943674958793803L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idImpediment;
	@Column(name = "Descrizione")
	private String Descizione;
	@Column(name = "Data")
	private Date Data;
	@OneToOne
	@JoinColumn(name = "idTeam")
	private Team idTeam;
	@OneToOne
	@JoinColumn(name = "idAttivita")
	private Activity idAttivita;
	
	public Integer getIdImpediment() {
		return idImpediment;
	}
	public void setIdImpediment(Integer idImpediment) {
		this.idImpediment = idImpediment;
	}
	public String getDescizione() {
		return Descizione;
	}
	public void setDescizione(String descizione) {
		Descizione = descizione;
	}
	public Date getData() {
		return Data;
	}
	public void setData(Date data) {
		Data = data;
	}
	public Team getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(Team idTeam) {
		this.idTeam = idTeam;
	}
	public Activity getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(Activity idAttivita) {
		this.idAttivita = idAttivita;
	}
	
	
}
