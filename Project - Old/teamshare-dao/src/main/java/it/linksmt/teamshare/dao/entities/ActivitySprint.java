package it.linksmt.teamshare.dao.entities;

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
@Table(name = "tb_attivita_sprint")
public class ActivitySprint implements Serializable {

	private static final long serialVersionUID = 1100015012130654286L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(targetEntity=Activity.class)
	@JoinColumn(name = "id_attivita")
	private Activity activity;
	
	@ManyToOne(targetEntity=Sprint.class)
	@JoinColumn(name = "id_sprint")
	private Sprint sprint;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	@Override
	public String toString() {
		return "ActivitySprint [id=" + id + ", activity=" + activity + ", sprint=" + sprint + "]";
	}
	
}
