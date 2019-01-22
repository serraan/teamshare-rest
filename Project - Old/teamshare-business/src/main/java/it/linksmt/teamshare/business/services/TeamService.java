package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.TeamRequestDto;
import it.linksmt.teamshare.business.dtos.TeamDto;

public interface TeamService {

	public List<TeamDto> getTeams();

	public TeamDto getTeam(Integer id);

	public TeamDto addTeam(TeamRequestDto teamRequestDto);

	public TeamDto updateTeam(Integer teamId, TeamRequestDto teamRequestDto);

	public void deleteTeam(Integer id);
	
}