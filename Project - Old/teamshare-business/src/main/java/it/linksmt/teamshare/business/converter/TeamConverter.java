package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.TeamRequestDto;
import it.linksmt.teamshare.business.dtos.TeamDto;
import it.linksmt.teamshare.dao.entities.Team;

@Mapper
public interface TeamConverter {
	
	TeamConverter MAPPER = Mappers.getMapper(TeamConverter.class);

	List<TeamDto> toListTeamDto(List<Team> teams);
	
	TeamDto toTeamDto(Team team);
	
	Team toTeam(TeamDto teamDto);
	
	Team toTeam(TeamRequestDto teamRequestDto);
	
}
