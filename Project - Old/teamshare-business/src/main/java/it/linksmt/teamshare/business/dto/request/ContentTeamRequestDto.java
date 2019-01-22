package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;

public class ContentTeamRequestDto implements Serializable {

	private static final long serialVersionUID = -4455056396415635415L;

	private Integer idTeam;
	private Integer idContent;

	public Integer getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}

	public Integer getIdContent() {
		return idContent;
	}

	public void setIdContent(Integer idContent) {
		this.idContent = idContent;
	}

	@Override
	public String toString() {
		return "ContentTeamRequestDto [idTeam=" + idTeam + ", idContent=" + idContent + "]";
	}

}
