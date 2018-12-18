package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sprint")
public class Sprint implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4889584991915617040L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Nome")
	private String name;

	@Column(name = "DataInizio")
	private Date startDate;

	@Column(name = "DataScadenza")
	private Date endDate;

	@ManyToMany @JoinTable(name="tb_attivita_sprint", joinColumns = {
			@JoinColumn(name = "FK_IdSprint")}, 
			inverseJoinColumns = {@JoinColumn (name = "FK_IdAttivita")})
	private List<Activity> activities = new ArrayList<Activity>();

	//@Column(name = "FK_IdRelease")
	//private Release idRelease;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

//	public Release getIdRelease() {
//		return idRelease;
//	}
//
//	public void setIdRelease(Release idRelease) {
//		this.idRelease = idRelease;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}

//	@Override
//	public String toString() {
//		return "Sprint [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
//				+ ", idRelease=" + idRelease + "]";
//	}

}
