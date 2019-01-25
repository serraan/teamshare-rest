package it.linksmt.teamshare.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.request.UserRequestDto;
import it.linksmt.teamshare.business.services.SignUpService;
import it.linksmt.teamshare.converter.UserConverter;
import it.linksmt.teamshare.entities.User;
import it.linksmt.teamshare.repository.UserRepository;
@Service
@Transactional()
public class SignUpServiceImpl implements SignUpService {
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDto addUser(UserRequestDto user) {
		User u = UserConverter.MAPPER.toUser(user);
		u = userRepository.save(u);
		
		return UserConverter.MAPPER.toUserDTO(u);
	}
	
}
