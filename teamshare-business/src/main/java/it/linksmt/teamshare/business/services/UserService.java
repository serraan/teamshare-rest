package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.UserRequestDto;
import it.linksmt.teamshare.business.dtos.UserDto;

public interface UserService {

	public List<UserDto> searchUsers(String email, String firstName, String lastName);
	
	public List<UserDto> getUsers();
	public UserDto getUser(Integer id);
	public UserDto addUser(UserRequestDto userRequestDto);
	public UserDto updateUser(Integer userId, UserRequestDto userRequestDto);
	public void deleteUser(Integer id);
	
}
