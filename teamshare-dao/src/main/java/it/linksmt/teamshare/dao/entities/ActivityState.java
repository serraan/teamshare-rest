package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_attivita_stato")
public class ActivityState implements Serializable {

	private static final long serialVersionUID = 9167994568885809440L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
		
	@Column(name = "data_inizio")
	private Date startDate;
	
	@Column(name = "data_fine")
	private Date endDate;
	
	@ManyToOne(targetEntity=Activity.class)
	@JoinColumn(name = "id_attivita")
	private Activity activity;
	
	@ManyToOne(targetEntity=State.class)
	@JoinColumn(name = "id_stato")
	private State state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ActivityStates [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", activity="
				+ activity + "]";
	}

}
