package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;
import java.sql.Date;

public class ImpedimentRequestDto implements Serializable {

	private static final long serialVersionUID = 6821896358761266476L;

	private String description;
	private Date date;

	private Integer idTeam;
	private Integer idActivity;

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

	public Integer getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}

	public Integer getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Integer idActivity) {
		this.idActivity = idActivity;
	}

	@Override
	public String toString() {
		return "ImpedimentRequestDto [description=" + description + ", date=" + date + ", idTeam=" + idTeam
				+ ", idActivity=" + idActivity + "]";
	}

}
