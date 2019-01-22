package it.linksmt.teamshare.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.dtos.TeamDto;
import it.linksmt.teamshare.business.request.TeamRequestDto;
import it.linksmt.teamshare.business.services.TeamService;
import it.linksmt.teamshare.converter.TeamConverter;
import it.linksmt.teamshare.entities.Team;
import it.linksmt.teamshare.repository.TeamRepository;
@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	@Autowired
	TeamRepository teamRepository;
	
	@Override
	public List<TeamDto> getAll() {
		List<Team> att = (List<Team>) teamRepository.findAll();
		
		return TeamConverter.MAPPER.toListaTeamDTOResponse(att);
	}

	@Override
	public TeamDto getTeam(String nomeTeam) {
		Team team = teamRepository.findByNomeTeam(nomeTeam);
		return TeamConverter.MAPPER.toTeamDto(team);
	}

	@Override
	public TeamDto addTeam(TeamRequestDto team) {
		Team t = TeamConverter.MAPPER.toTeam(team);
		t = teamRepository.save(t);
		return TeamConverter.MAPPER.toTeamDto(t);
	}

	@Override
	public TeamDto updateTeam(Integer teamId, TeamRequestDto team) {
		Team t = TeamConverter.MAPPER.toTeam(team);
		t.setId(teamId);
		t = teamRepository.save(t);
		return TeamConverter.MAPPER.toTeamDto(t);
	}

	@Override
	public void deleteTeam(Integer id) {
		teamRepository.deleteById(id);
		
	}

}
