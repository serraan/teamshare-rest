package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_attivita")
public class Activity implements Serializable {

	private static final long serialVersionUID = 877546176463513619L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "titolo")
	private String title;
	
	@Column(name = "descrizione")
	private String description;
	
	@Column(name = "tipo")
	private String type;
	
	@Column(name = "priorita")
	private String priority;
	
	@Column(name = "data_presa_in_carico")
	private Date dateTakenIntoCharge;

	@OneToOne
	@JoinColumn(name = "id_utente_creatore")
	private User userCreator;
	
	@OneToOne
	@JoinColumn(name = "id_utente_assegnatario")
	private User userAssignee;
	
	@OneToMany(mappedBy = "activity" , cascade=CascadeType.ALL)
	private List<Note> listNote;
	
	@OneToMany(mappedBy = "activity" , cascade=CascadeType.ALL)
	private List<ActivitySprint> listActivitySprint;
	
	@OneToMany(mappedBy = "activity" , cascade=CascadeType.ALL)
	private List<ActivityState> listActivityStatus;

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

	public Date getDateTakenIntoCharge() {
		return dateTakenIntoCharge;
	}

	public void setDateTakenIntoCharge(Date dateTakenIntoCharge) {
		this.dateTakenIntoCharge = dateTakenIntoCharge;
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

	public List<Note> getListNote() {
		return listNote;
	}

	public void setListNote(List<Note> listNote) {
		this.listNote = listNote;
	}

	public List<ActivitySprint> getListActivitySprint() {
		return listActivitySprint;
	}

	public void setListActivitySprint(List<ActivitySprint> listActivitySprint) {
		this.listActivitySprint = listActivitySprint;
	}

	public List<ActivityState> getListActivityStatus() {
		return listActivityStatus;
	}

	public void setListActivityStatus(List<ActivityState> listActivityStatus) {
		this.listActivityStatus = listActivityStatus;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", title=" + title + ", description=" + description + ", type=" + type
				+ ", priority=" + priority + ", dateTakenIntoCharge=" + dateTakenIntoCharge + ", userCreator="
				+ userCreator + ", userAssignee=" + userAssignee + ", listNote=" + listNote
				+ ", listActivitySprint=" + listActivitySprint + ", listActivityStatus=" + listActivityStatus + "]";
	}
	
}
