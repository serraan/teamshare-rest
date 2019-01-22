package it.linksmt.teamshare.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dtos.TeamDto;
import it.linksmt.teamshare.business.request.TeamRequestDto;
import it.linksmt.teamshare.entities.Team;
@Mapper
public interface TeamConverter {
	TeamConverter MAPPER = Mappers.getMapper(TeamConverter.class);

	List<TeamDto> toListaTeamDTOResponse(List<Team> att);
	
	TeamDto toTeamDto(Team team);
	
	Team toTeam(TeamDto teamDto);
	
	Team toTeam(TeamRequestDto teamRequestDto);
}
