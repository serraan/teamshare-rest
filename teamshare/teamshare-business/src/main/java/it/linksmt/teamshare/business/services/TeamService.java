package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dtos.TeamDto;
import it.linksmt.teamshare.business.request.ActivityRequestDto;
import it.linksmt.teamshare.business.request.TeamRequestDto;

public interface TeamService {
	public List<TeamDto> getAll();
	public TeamDto getTeam(String nomeTeam);
	public TeamDto addTeam(TeamRequestDto team);
	public TeamDto updateTeam(Integer teamId, TeamRequestDto team);
	public void deleteTeam(Integer id);
}
