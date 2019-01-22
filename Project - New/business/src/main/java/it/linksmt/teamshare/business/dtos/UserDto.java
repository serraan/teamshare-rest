package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.request.UserRequestDto;

public class UserDto extends UserRequestDto implements Serializable {

	private static final long serialVersionUID = 5977013417767148380L;
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", getNome()=" + getNome() + ", getCognome()=" + getCognome() + ", getEmail()="
				+ getEmail() + ", getPassword()=" + getPassword() + ", getDataNascita()=" + getDataNascita() + "]";
	}	
}
