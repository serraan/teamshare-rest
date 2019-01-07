package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.UserTeamRequestDto;
import it.linksmt.teamshare.business.dtos.UserTeamDto;
import it.linksmt.teamshare.dao.entities.UserTeam;

@Mapper
public interface UserTeamConverter {
	
	UserTeamConverter MAPPER = Mappers.getMapper(UserTeamConverter.class);

	List<UserTeamDto> toListUserTeamDto(Iterable<UserTeam> userTeams);
	
	@Mappings({
		@Mapping(target = "idUser", source = "user.id"),
		@Mapping(target = "idTeam", source = "team.id")
	})
	UserTeamDto toUserTeamDto(UserTeam userTeam);
	
	@Mappings({
		@Mapping(target = "user.id", source = "idUser"),
		@Mapping(target = "team.id", source = "idTeam")
	})
	UserTeam toUserTeam(UserTeamDto userTeamDto);
	
	@Mappings({
		@Mapping(target = "user.id", source = "idUser"),
		@Mapping(target = "team.id", source = "idTeam")
	})
	UserTeam toUserTeam(UserTeamRequestDto userTeamRequestDto);
	
}
