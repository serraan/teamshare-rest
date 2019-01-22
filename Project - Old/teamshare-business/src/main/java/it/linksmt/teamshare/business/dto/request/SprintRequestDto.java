package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;
import java.util.Date;

public class SprintRequestDto implements Serializable {

	private static final long serialVersionUID = -1890973195400234886L;

	private Date startDate;
	private Date endDate;
	private String name;
	
	private Integer idRelease;

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

	public Integer getIdRelease() {
		return idRelease;
	}

	public void setIdRelease(Integer idRelease) {
		this.idRelease = idRelease;
	}

	@Override
	public String toString() {
		return "SprintRequestDto [startDate=" + startDate + ", endDate=" + endDate + ", name=" + name + ", idRelease="
				+ idRelease + "]";
	}

}
