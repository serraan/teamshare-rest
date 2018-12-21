package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;

public class ActivitySprintRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3753259068767756500L;

	private Integer idActivity;
	
	private Integer idSprint;

	public Integer getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Integer idActivity) {
		this.idActivity = idActivity;
	}

	public Integer getIdSprint() {
		return idSprint;
	}

	public void setIdSprint(Integer idSprint) {
		this.idSprint = idSprint;
	}

}
