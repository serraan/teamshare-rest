package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_impediment")
public class Impediment implements Serializable {

	private static final long serialVersionUID = -7158990428286572595L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "descrizione")
	private String description;
	
	@Column(name = "data")
	private Date date;
	
	@OneToOne
	@JoinColumn(name = "id_team")
	private Team team;
	
	@OneToOne
	@JoinColumn(name = "id_attivita")
	private Activity activity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "Impediment [id=" + id + ", description=" + description + ", date=" + date + ", team=" + team
				+ ", activity=" + activity + "]";
	}

}
