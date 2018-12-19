package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

public class ActivitySprintDto implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 4854363690440298474L;

	private Integer id;
	
	private SprintDto sprint;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public SprintDto getSprint() {
		return sprint;
	}

	public void setSprint(SprintDto sprint) {
		this.sprint = sprint;
	}

}
