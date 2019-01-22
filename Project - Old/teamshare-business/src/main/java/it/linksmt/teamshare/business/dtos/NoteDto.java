package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.NoteRequestDto;

public class NoteDto extends NoteRequestDto implements Serializable {

	private static final long serialVersionUID = -6784811999441284337L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
