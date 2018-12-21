package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import it.linksmt.teamshare.business.dtos.SprintDto;

public class ActivityRequestDto implements Serializable {
	
	private static final long serialVersionUID = -298763132072447661L;
	
	private String titolo;
	
	private String descrizione;
	
	private String tipo;
	
	private String priorita;
	
	private Date dataPresaIncarico;

	private Integer idUtenteCreatore;
	
	private Integer idUtenteAssegnatario;
	
	private List<SprintDto> sprints;

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

	public Integer getIdUtenteCreatore() {
		return idUtenteCreatore;
	}

	public void setIdUtenteCreatore(Integer idUtenteCreatore) {
		this.idUtenteCreatore = idUtenteCreatore;
	}

	public Integer getIdUtenteAssegnatario() {
		return idUtenteAssegnatario;
	}

	public void setIdUtenteAssegnatario(Integer idUtenteAssegnatario) {
		this.idUtenteAssegnatario = idUtenteAssegnatario;
	}

	public List<SprintDto> getSprints() {
		return sprints;
	}

	public void setSprints(List<SprintDto> sprints) {
		this.sprints = sprints;
	}

}
