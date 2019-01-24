package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.request.DashboardEntryRequestDto;
import it.linksmt.teamshare.business.request.UserRequestDto;

public interface UserService {

	public List<UserDto> searchUsers(String email, String nome, String cognome);
	public List<UserDto> searchAll();
	public UserDto getUser(Integer id);
	public UserDto addUser(UserRequestDto user);
	public UserDto updateUser(Integer userId, UserRequestDto user);
	public void deleteUser(Integer id);

	
}
