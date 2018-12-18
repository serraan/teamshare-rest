package it.linksmt.teamshare.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_reaction")
public class Reaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReazione;

	@Column(name = "IdUtente")
	private Integer idUtente;

	@Column(name = "IdContenuto")
	private Integer idContenuto;

	@Column(name = "IdTipo")
	private Integer idTipo;

	public Integer getIdReazione() {
		return idReazione;
	}

	public void setIdReazione(Integer idReazione) {
		this.idReazione = idReazione;
	}

	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	public Integer getIdContenuto() {
		return idContenuto;
	}

	public void setIdContenuto(Integer idContenuto) {
		this.idContenuto = idContenuto;
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

}