package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.ImpedimentRequestDto;
import it.linksmt.teamshare.business.dtos.ImpedimentDto;
import it.linksmt.teamshare.dao.entities.Impediment;

@Mapper
public interface ImpedimentConverter {
	
	ImpedimentConverter MAPPER = Mappers.getMapper(ImpedimentConverter.class);

	List<ImpedimentDto> toListImpedimentDTOResponse(Iterable<Impediment> allImpediment);

	@Mappings({ @Mapping(target = "idTeam", source = "team.id"),
		@Mapping(target = "idAttivita", source = "attivita.id") })
	ImpedimentDto toImpedimentDTO(Impediment impediment);
	
	@Mappings({ @Mapping(target = "team.id", source = "idTeam"),
		@Mapping(target = "attivita.id", source = "idAttivita")})
	Impediment toImpediment(ImpedimentDto impedimentDto);
	
	@Mappings({ @Mapping(target = "team.id", source = "idTeam"),
		@Mapping(target = "attivita.id", source = "idAttivita")})
	Impediment toImpediment(ImpedimentRequestDto impedimentRequestDto);


}
