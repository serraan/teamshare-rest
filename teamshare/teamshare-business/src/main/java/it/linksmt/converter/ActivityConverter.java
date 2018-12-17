package it.linksmt.converter;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.business.request.ActivityRequestDto;
import it.linksmt.teamshare.entities.Activity;
import it.linksmt.teamshare.entities.User;

@Mapper
public interface ActivityConverter {

	ActivityConverter MAPPER = Mappers.getMapper(ActivityConverter.class);

	List<ActivityDto> toListaAttivitaDTOesponse(Iterable<Activity> allActivities);

	@Mappings({ @Mapping(target = "idUtenteCreatore", source = "utenteCreatore.id"),
			@Mapping(target = "idUtenteAssegnatario", source = "utenteAssegnatario.id") })
	ActivityDto toActivityDTO(Activity activity);

	@Mapping(target = "utenteCreatore.id", source = "idUtenteCreatore")
	Activity toActivity(ActivityDto activityDto);

	@Mapping(target = "utenteCreatore.id", source = "idUtenteCreatore")
	Activity toActivity(ActivityRequestDto activityRequestDto);

	@AfterMapping
	default void addBack(ActivityRequestDto request, @MappingTarget  Activity activity ) {
		if (request.getIdUtenteAssegnatario() != null
				&& request.getIdUtenteAssegnatario().intValue() > 0) {
			activity.setIdUtenteAssegnatario(new User());
			activity.getIdUtenteAssegnatario().setIdUtente(request.getIdUtenteAssegnatario());
		}
	}

}
