package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;

public class UserTeamRequestDto implements Serializable {

	private static final long serialVersionUID = 8509743649274945288L;

	private Integer idUser;
	private Integer idTeam;

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}

	@Override
	public String toString() {
		return "UserTeamRequestDto [idUser=" + idUser + ", idTeam=" + idTeam + "]";
	}

}
