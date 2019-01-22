package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;

public class StateRequestDto implements Serializable {

	private static final long serialVersionUID = -1634111610595122520L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}