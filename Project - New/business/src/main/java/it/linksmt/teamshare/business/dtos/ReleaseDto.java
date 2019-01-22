package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.request.ReleaseRequestDto;

public class ReleaseDto extends ReleaseRequestDto implements Serializable {

	private static final long serialVersionUID = 5805813597262249196L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ReleaseDto [idRelease=" + id + ", getNomeRelease()=" + getNomeRelease() + "]";
	}

}
