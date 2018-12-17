package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.converter.UserConverter;
import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.request.UserRequestDto;
import it.linksmt.teamshare.business.services.UserService;
import it.linksmt.teamshare.entities.User;
import it.linksmt.teamshare.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDto> getAll() {
		List<User> users = (List<User>) userRepository.findAll();

		return UserConverter.MAPPER.toListUserDTO(users);
	}

	@Override
    public List<UserDto> searchUsers(String email, String firstName, String lastName) {
            List<User> users = null;
            users = userRepository.findByEmailContainingAndFirstNameContainingAndLastNameContaining(email, firstName, lastName);
            return UserConverter.MAPPER.toListUserDTO(users);
    }

	@Override
	public UserDto getUser(Integer id) {
		Optional<User> users = userRepository.findById(id);
//		user.setId(users.getId());
//		user.setFirstName(users.getFirstName());
//		user.setLastName(users.getLastName());
//		user.setEmail(users.getEmail());
		return UserConverter.MAPPER.toUserDTO(users.get());
	}

	@Override
	public UserDto addUser(UserRequestDto user) {
		User u = UserConverter.MAPPER.toUser(user);
		u = userRepository.save(u);
		
		return UserConverter.MAPPER.toUserDTO(u);
	}
	

	@Override
	public UserDto updateUser(Integer userId, UserRequestDto user) {
		User u = UserConverter.MAPPER.toUser(user);
		u.setIdUtente(userId);
		u = userRepository.save(u);
		return UserConverter.MAPPER.toUserDTO(u);
	}

	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}


}
