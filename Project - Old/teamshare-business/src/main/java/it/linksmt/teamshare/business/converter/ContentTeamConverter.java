package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.ContentTeamRequestDto;
import it.linksmt.teamshare.business.dtos.ContentTeamDto;
import it.linksmt.teamshare.dao.entities.ContentTeam;

@Mapper
public interface ContentTeamConverter {

	ContentTeamConverter MAPPER = Mappers.getMapper(ContentTeamConverter.class);

	List<ContentTeamDto> toListContentTeamDto(Iterable<ContentTeam> contentTeams);

	@Mappings({
		@Mapping(target = "idContent", source = "content.id"),
		@Mapping(target = "idTeam", source = "team.id")
	})
	ContentTeamDto toContentTeamDto(ContentTeam contentTeam);

	@Mappings({
		@Mapping(target = "content.id", source = "idContent"),
		@Mapping(target = "team.id", source = "idTeam")
	})
	ContentTeam toContentTeam(ContentTeamDto contentTeamDto);

	@Mappings({
		@Mapping(target = "content.id", source = "idContent"),
		@Mapping(target = "team.id", source = "idTeam")
	})
	ContentTeam toContentTeam(ContentTeamRequestDto contentTeamRequestDto);
	
}
