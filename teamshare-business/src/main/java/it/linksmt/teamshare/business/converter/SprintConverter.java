package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.SprintRequestDto;
import it.linksmt.teamshare.business.dtos.SprintDto;
import it.linksmt.teamshare.dao.entities.Sprint;

@Mapper
public interface SprintConverter {

	SprintConverter MAPPER = Mappers.getMapper(SprintConverter.class);

	List<SprintDto> toListSprintDto(Iterable<Sprint> allSprint);

	@Mapping(target = "idRelease", source = "release.id")
	SprintDto toSprintDto(Sprint sprint);

	@Mapping(target = "release.id", source = "idRelease")
	Sprint toSprint(SprintDto sprintDto);

	@Mapping(target = "release.id", source = "idRelease")
	Sprint toSprint(SprintRequestDto sprintRequestDto);
}
