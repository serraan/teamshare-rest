package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.UserTeamConverter;
import it.linksmt.teamshare.business.dto.request.UserTeamRequestDto;
import it.linksmt.teamshare.business.dtos.UserTeamDto;
import it.linksmt.teamshare.business.services.UserTeamService;
import it.linksmt.teamshare.dao.entities.UserTeam;
import it.linksmt.teamshare.dao.repositories.UserTeamRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class UserTeamServiceImpl implements UserTeamService{

	@Autowired
	private UserTeamRepository userTeamRepository;

	@Override
	public List<UserTeamDto> getUserTeams() {

		List<UserTeam> userTeams = (List<UserTeam>) userTeamRepository.findAll();
		
		return UserTeamConverter.MAPPER.toListUserTeamDto(userTeams);
	}

	@Override
	public UserTeamDto getUserTeam(Integer userTeamId) {

		Optional<UserTeam> userTeam = userTeamRepository.findById(userTeamId);

		return UserTeamConverter.MAPPER.toUserTeamDto(userTeam.get());
	}

	@Override
	public UserTeamDto addUserTeam(UserTeamRequestDto userTeamRequestDto) {

		UserTeam userTeam = UserTeamConverter.MAPPER.toUserTeam(userTeamRequestDto);
		
		userTeam = userTeamRepository.save(userTeam);
		
		return UserTeamConverter.MAPPER.toUserTeamDto(userTeam);
	}

	@Override
	public UserTeamDto updateUserTeam(Integer userTeamId, UserTeamRequestDto userTeamRequestDto) {

		UserTeam userTeam = UserTeamConverter.MAPPER.toUserTeam(userTeamRequestDto);
		userTeam.setId(userTeamId);
		
		userTeam = userTeamRepository.save(userTeam);

		return UserTeamConverter.MAPPER.toUserTeamDto(userTeam);
	}

	@Override
	public void deleteUserTeam(Integer userTeamId) {

		userTeamRepository.deleteById(userTeamId);
	}
	
}
