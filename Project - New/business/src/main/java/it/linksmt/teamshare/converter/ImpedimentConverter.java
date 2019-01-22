package it.linksmt.teamshare.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dtos.ImpedimentDto;
import it.linksmt.teamshare.business.request.ImpedimentRequestDto;
import it.linksmt.teamshare.entities.Impediment;

@Mapper
public interface ImpedimentConverter {

	ImpedimentConverter MAPPER = Mappers.getMapper(ImpedimentConverter.class);
	
	List<ImpedimentDto> toListaImpedimentDTO(List<Impediment> imp);
	
	@Mappings({ @Mapping(target = "idTeam", source = "team.id"),
		@Mapping(target = "idAttivita", source = "attivita.id") })
	ImpedimentDto toImpedimentDto(Impediment impediment);
	
	@Mappings({ @Mapping(target = "team.id", source = "idTeam"),
		@Mapping(target = "attivita.id", source = "idAttivita") })
	Impediment toImpediment(ImpedimentDto ImpedimentDto);
	
	@Mappings({ @Mapping(target = "team.id", source = "idTeam"),
		@Mapping(target = "attivita.id", source = "idAttivita") })
	Impediment toImpediment(ImpedimentRequestDto ImpedimentRequestDto);
}
