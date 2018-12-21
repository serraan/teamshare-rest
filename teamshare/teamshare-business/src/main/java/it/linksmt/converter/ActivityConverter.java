package it.linksmt.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.business.request.ActivityRequestDto;
import it.linksmt.teamshare.entities.Activity;

@Mapper
public interface ActivityConverter {

	ActivityConverter MAPPER = Mappers.getMapper(ActivityConverter.class);

	List<ActivityDto> toListaAttivitaDTOResponse(Iterable<Activity> allActivities);

	@Mappings({ @Mapping(target = "idUtenteCreatore", source = "utenteCreatore.id"),
			@Mapping(target = "idUtenteAssegnatario", source = "utenteAssegnatario.id") })
	ActivityDto toActivityDTO(Activity activity);

	@Mappings({ @Mapping(target = "utenteCreatore.id", source = "idUtenteCreatore"),
	@Mapping(target = "utenteAssegnatario.id", source = "idUtenteAssegnatario")})
	Activity toActivity(ActivityDto activityDto);

	@Mappings({ @Mapping(target = "utenteCreatore.id", source = "idUtenteCreatore"),
	@Mapping(target = "utenteAssegnatario.id", source = "idUtenteAssegnatario")})
	Activity toActivity(ActivityRequestDto activityRequestDto);

}
