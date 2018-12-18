package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.request.UserRequestDto;

public class UserDto extends UserRequestDto implements Serializable {

	private static final long serialVersionUID = 5977013417767148380L;
	
	private Integer idUtente;
	
	public Integer getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Integer id) {
		this.idUtente = id;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + idUtente + ", getNome()=" + getNome() + ", getCognome()=" + getCognome()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getBirthDate()="
				+ getDataNascita() + "]";
	}
	

	
	
}
