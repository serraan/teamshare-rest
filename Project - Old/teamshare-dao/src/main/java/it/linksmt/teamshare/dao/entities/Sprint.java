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
@Table(name = "tb_sprint")
public class Sprint implements Serializable {

	private static final long serialVersionUID = -6033623675655160198L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "data_inizio")
	private Date startDate;
	
	@Column(name = "data_scadenza")
	private Date endDate;
	
	@Column(name = "nome")
	private String name;
	
	@OneToOne
	@JoinColumn(name = "id_release")
	private Release release;
	
	@OneToMany(mappedBy = "sprint", cascade=CascadeType.ALL)
	private List<ActivitySprint> listActivitySprint;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

	public List<ActivitySprint> getListActivitySprint() {
		return listActivitySprint;
	}

	public void setListActivitySprint(List<ActivitySprint> listActivitySprint) {
		this.listActivitySprint = listActivitySprint;
	}

	@Override
	public String toString() {
		return "Sprint [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", name=" + name
				+ ", release=" + release + ", listActivitySprint=" + listActivitySprint + "]";
	}

}
