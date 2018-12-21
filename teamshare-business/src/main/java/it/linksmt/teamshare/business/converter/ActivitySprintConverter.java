package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dtos.SprintDto;
import it.linksmt.teamshare.dao.entities.Sprint;

@Mapper
public interface ActivitySprintConverter {
	
	ActivitySprintConverter MAPPER = Mappers.getMapper(ActivitySprintConverter.class);
	
	List<SprintDto> toListActivitySprintDto(List<Sprint> list);

	/*ActivitySprintDto toActivitySprintDTO(ActivitySprint activitySprint);
	
	ActivitySprint toActivitySprint(ActivitySprintDto activitySprintDto);
	
	ActivitySprint toActivitySprint(ActivitySprintRequestDto activitySprintRequestDto);*/
	
}
