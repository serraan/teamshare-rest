package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.ActivityStateRequestDto;
import it.linksmt.teamshare.business.dtos.ActivityStateDto;
import it.linksmt.teamshare.dao.entities.ActivityState;

@Mapper
public interface ActivityStateConverter {

	ActivityStateConverter MAPPER = Mappers.getMapper(ActivityStateConverter.class);

	List<ActivityStateDto> toListActivityStateDto(Iterable<ActivityState> activityStatees);

	@Mappings({
		@Mapping(target = "idState", source = "state.id"),
		@Mapping(target = "idActivity", source = "activity.id")
	})
	ActivityStateDto toActivityStateDto(ActivityState activityState);

	@Mappings({
		@Mapping(target = "state.id", source = "idState"),
		@Mapping(target = "activity.id", source = "idActivity")
	})
	ActivityState toActivityState(ActivityStateDto activityStateDto);

	@Mappings({
		@Mapping(target = "state.id", source = "idState"),
		@Mapping(target = "activity.id", source = "idActivity")
	})
	ActivityState toActivityState(ActivityStateRequestDto activityStateRequestDto);
	
}
