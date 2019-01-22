package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;

public class ReleaseRequestDto implements Serializable {

	private static final long serialVersionUID = 7482629668652148094L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ReleaseRequestDto [name=" + name + "]";
	}

}
