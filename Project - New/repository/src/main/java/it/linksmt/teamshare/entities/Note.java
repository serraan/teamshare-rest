package it.linksmt.teamshare.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_nota")
public class Note implements Serializable{

	private static final long serialVersionUID = -8982643513648171033L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "testo")
	private String Testo;
	
	@ManyToOne(targetEntity = Activity.class)
	@JoinColumn(name = "id_attivita", referencedColumnName = "id")
	private Activity attivita;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTesto() {
		return Testo;
	}
	public void setTesto(String testo) {
		Testo = testo;
	}
	public Activity getAttivita() {
		return attivita;
	}
	public void setAttivita(Activity attivita) {
		this.attivita = attivita;
	}

	
	
}
