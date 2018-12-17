package it.linksmt.teamshare.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_nota")
public class Note implements Serializable{

	private static final long serialVersionUID = -8982643513648171033L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idNota;
	@Column(name = "Testo")
	private String Testo;
	@OneToOne
	@JoinColumn(name = "idAttivita")
	private Activity idAttivita;
	
	public Integer getIdNota() {
		return idNota;
	}
	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}
	public String getTesto() {
		return Testo;
	}
	public void setTesto(String testo) {
		Testo = testo;
	}
	public Activity getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(Activity idAttivita) {
		this.idAttivita = idAttivita;
	}
	
	
}
