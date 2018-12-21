package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.TeamConverter;
import it.linksmt.teamshare.business.dto.request.TeamRequestDto;
import it.linksmt.teamshare.business.dtos.TeamDto;
import it.linksmt.teamshare.business.services.TeamService;
import it.linksmt.teamshare.dao.entities.Team;
import it.linksmt.teamshare.dao.repositories.TeamRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	@Override
	public List<TeamDto> getTeams() {
		
		List<Team> teams = (List<Team>) teamRepository.findAll();
		
		return TeamConverter.MAPPER.toListTeamDTO(teams);
		
	}

	@Override
	public TeamDto getTeamById(Integer id) {
		
		Optional<Team> teams = teamRepository.findById(id);
		
		return TeamConverter.MAPPER.toTeamDTO(teams.get());
	}

	@Override
	public TeamDto addTeam(TeamRequestDto teamRequestDto) {
		
		Team team = TeamConverter.MAPPER.toTeam(teamRequestDto);
		
		team = teamRepository.save(team);
		
		return TeamConverter.MAPPER.toTeamDTO(team);
	}

	@Override
	public TeamDto updateTeam(Integer id, TeamRequestDto teamRequestDto) {
		
		Team team = TeamConverter.MAPPER.toTeam(teamRequestDto);
		team.setId(id);
		
		team = teamRepository.save(team);
		
		return TeamConverter.MAPPER.toTeamDTO(team);
	}

	@Override
	public void deleteTeam(Integer id) {

		teamRepository.deleteById(id);

	}

}
