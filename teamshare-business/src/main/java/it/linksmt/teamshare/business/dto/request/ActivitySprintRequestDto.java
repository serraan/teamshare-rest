package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;

public class ActivitySprintRequestDto implements Serializable {

	private static final long serialVersionUID = 5147715909821698827L;

	private Integer idSprint;
	private Integer idActivity;

	public Integer getIdSprint() {
		return idSprint;
	}

	public void setIdSprint(Integer idSprint) {
		this.idSprint = idSprint;
	}

	public Integer getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Integer idActivity) {
		this.idActivity = idActivity;
	}

	@Override
	public String toString() {
		return "ActivitySprintRequestDto [idSprint=" + idSprint + ", idActivity=" + idActivity + "]";
	}

}
