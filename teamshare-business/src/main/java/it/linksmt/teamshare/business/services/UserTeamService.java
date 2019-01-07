package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.UserTeamRequestDto;
import it.linksmt.teamshare.business.dtos.UserTeamDto;

public interface UserTeamService {

	public List<UserTeamDto> getUserTeams();

	public UserTeamDto getUserTeam(Integer id);

	public UserTeamDto addUserTeam(UserTeamRequestDto userTeamRequestDto);

	public UserTeamDto updateUserTeam(Integer userTeamId, UserTeamRequestDto userTeamRequestDto);

	public void deleteUserTeam(Integer id);
	
}
