package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.ActivityRequestDto;
import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.dao.entities.Activity;

@Mapper
public interface ActivityConverter {

	ActivityConverter MAPPER = Mappers.getMapper(ActivityConverter.class);

	List<ActivityDto> toListActivityDto(Iterable<Activity> activities);

	@Mappings({
		@Mapping(target = "idUserCreator", source = "userCreator.id"),
		@Mapping(target = "idUserAssignee", source = "userAssignee.id")
	})
	ActivityDto toActivityDTO(Activity activity);
	
	@Mappings({
		@Mapping(target = "userCreator.id", source = "idUserCreator"),
		@Mapping(target = "userAssignee.id", source = "idUserAssignee")
	})
	Activity toActivity(ActivityDto activityDto);
	
	@Mappings({
		@Mapping(target = "userCreator.id", source = "idUserCreator"),
		@Mapping(target = "userAssignee.id", source = "idUserAssignee")
	})
	Activity toActivity(ActivityRequestDto activityRequestDto);

}
