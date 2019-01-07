package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.ActivitySprintRequestDto;
import it.linksmt.teamshare.business.dtos.ActivitySprintDto;
import it.linksmt.teamshare.dao.entities.ActivitySprint;

@Mapper
public interface ActivitySprintConverter {

	ActivitySprintConverter MAPPER = Mappers.getMapper(ActivitySprintConverter.class);

	List<ActivitySprintDto> toListActivitySprintDto(Iterable<ActivitySprint> activitySprints);

	@Mappings({
		@Mapping(target = "idSprint", source = "sprint.id"),
		@Mapping(target = "idActivity", source = "activity.id")
	})
	ActivitySprintDto toActivitySprintDTO(ActivitySprint activitySprint);

	@Mappings({
		@Mapping(target = "sprint.id", source = "idSprint"),
		@Mapping(target = "activity.id", source = "idActivity")
	})
	ActivitySprint toActivitySprint(ActivitySprintDto activitySprintDto);

	@Mappings({
		@Mapping(target = "sprint.id", source = "idSprint"),
		@Mapping(target = "activity.id", source = "idActivity")
	})
	ActivitySprint toActivitySprint(ActivitySprintRequestDto activitySprintRequestDto);
	
}
