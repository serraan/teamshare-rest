package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;

public class TypeRequestDto implements Serializable {

	private static final long serialVersionUID = -7607340738084557627L;

	private String name;
	private String pathImage;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	@Override
	public String toString() {
		return "TypeRequestDto [name=" + name + ", pathImage=" + pathImage + "]";
	}

}
