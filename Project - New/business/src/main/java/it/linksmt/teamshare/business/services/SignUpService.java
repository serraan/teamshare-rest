package it.linksmt.teamshare.business.services;

import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.request.UserRequestDto;

public interface SignUpService {
	public UserDto addUser(UserRequestDto user);
}
