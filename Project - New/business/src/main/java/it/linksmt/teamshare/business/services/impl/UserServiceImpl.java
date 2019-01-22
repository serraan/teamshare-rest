package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.request.UserRequestDto;
import it.linksmt.teamshare.business.services.UserService;
import it.linksmt.teamshare.converter.UserConverter;
import it.linksmt.teamshare.entities.User;
import it.linksmt.teamshare.repository.UserRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;


	@Override
    public List<UserDto> searchUsers(String email, String nome, String cognome) {
            List<User> users = userRepository.findByEmailContainingAndNomeContainingAndCognomeContaining(email, nome, cognome);
            return UserConverter.MAPPER.toListUserDTO(users);
    }

	@Override
	public UserDto getUser(Integer id) {
		Optional<User> users = userRepository.findById(id);
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
		u.setId(userId);
		u = userRepository.save(u);
		return UserConverter.MAPPER.toUserDTO(u);
	}

	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}


}
