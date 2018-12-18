package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_nota")
public class Note implements Serializable {

	private static final long serialVersionUID = -7539399955992096001L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNota;

	@Column(name = "Testo")
	private String testo;

	@OneToMany
	@JoinColumn(name = "TB_ATTIVITA_IdAttivita")
	private Set<Activity> idAttivita;

	public int getIdNota() {
		return idNota;
	}

	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public Set<Activity> getIdAttivita() {
		return idAttivita;
	}

	public void setIdAttivita(Set<Activity> idAttivita) {
		this.idAttivita = idAttivita;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Note [idNota=" + idNota + ", Testo=" + testo + ", idAttivita=" + idAttivita + "]";
	}

}
