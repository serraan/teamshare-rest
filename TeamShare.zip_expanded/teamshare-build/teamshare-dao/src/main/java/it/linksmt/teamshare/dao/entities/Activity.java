package it.linksmt.teamshare.dao.entities;

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
@Table(name="attivita")
public class Activity implements Serializable {

	private static final long serialVersionUID = -1311340941982205414L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column(name="titolo")
	private String title;

	@Column(name="descrizione")
	private String description;
	
	@Column(name="tipo")
	private String type;

	@Column(name="priorita")
	private String priority;

	@Column(name="data_presa_carico")
	private Date dateTakenCharge;

	@OneToOne
	@JoinColumn(name="id_utente_creatore")
	private User userCreator;

	@OneToOne
	@JoinColumn(name="id_utente_assegnatario")
	private User userAssignee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getDateTakenCharge() {
		return dateTakenCharge;
	}

	public void setDateTakenCharge(Date dateTakenCharge) {
		this.dateTakenCharge = dateTakenCharge;
	}

	public User getUserCreator() {
		return userCreator;
	}

	public void setUserCreator(User userCreator) {
		this.userCreator = userCreator;
	}

	public User getUserAssignee() {
		return userAssignee;
	}

	public void setUserAssignee(User userAssignee) {
		this.userAssignee = userAssignee;
	}
	
}
