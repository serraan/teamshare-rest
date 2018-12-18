package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.UserConverter;
import it.linksmt.teamshare.business.dto.request.UserRequestDto;
import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.services.UserService;
import it.linksmt.teamshare.dao.entities.User;
import it.linksmt.teamshare.dao.repositories.UserRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDto> searchUsers(String email, String firstName, String lastName) {
		List<User> users = null;

//		if(!StringUtils.isEmpty(email) && StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
//			users = userRepository.findByEmail(email);
//		} else if(StringUtils.isEmpty(email) && !StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
//			users = userRepository.findByFirstName(firstName);
//		} else if(StringUtils.isEmpty(email) && StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
//			users = userRepository.findByLastName(lastName);
//		}else if(StringUtils.isEmpty(email) && !StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
//			users = userRepository.findByFirstNameAndLastName(firstName, lastName);
//		} else {
//			users = (List<User>) userRepository.findAll();
//		}
		
		users = userRepository.findByEmailContainingAndNomeContainingAndCognomeContaining(email, firstName, lastName);

		return UserConverter.MAPPER.toListUserDTO(users);
	}

	@Override
	public List<UserDto> getUsers() {

		List<User> users = (List<User>) userRepository.findAll();

		return UserConverter.MAPPER.toListUserDTO(users);
	}

	@Override
	public UserDto getUser(Integer id) {

		Optional<User> user = userRepository.findById(id);

		return UserConverter.MAPPER.toUserDTO(user.get());
	}

	@Override
	public UserDto addUser(UserRequestDto userRequestDto) {

		User user = UserConverter.MAPPER.toUser(userRequestDto);

		user = userRepository.save(user);

		return UserConverter.MAPPER.toUserDTO(user);
	}

	@Override
	public UserDto updateUser(Integer userId, UserRequestDto userRequestDto) {

		User user = UserConverter.MAPPER.toUser(userRequestDto);
		user.setId(userId);

		user = userRepository.save(user);

		return UserConverter.MAPPER.toUserDTO(user);
	}

	@Override
	public void deleteUser(Integer id) {

		userRepository.deleteById(id);
	}

}
