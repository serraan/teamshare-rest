package it.linksmt.teamshare.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dtos.SprintDto;
import it.linksmt.teamshare.business.request.SprintRequestDto;
import it.linksmt.teamshare.entities.Sprint;

@Mapper
public interface SprintConverter {
	SprintConverter MAPPER = Mappers.getMapper(SprintConverter.class);

	List<SprintDto> toListSprintDTO(Iterable<Sprint> allUser);
	
	@Mapping(target = "idRelease", source = "release.id")
	SprintDto toSprintDto(Sprint sprint);
	
	@Mapping(target = "release.id", source = "idRelease")
	Sprint toSprint(SprintDto sprint);
	
	@Mapping(target = "release.id", source = "idRelease")
	Sprint toSprint(SprintRequestDto sprint);
}
