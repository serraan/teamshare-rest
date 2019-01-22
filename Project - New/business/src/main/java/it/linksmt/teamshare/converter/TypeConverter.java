package it.linksmt.teamshare.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dtos.TypeDto;
import it.linksmt.teamshare.business.request.TypeRequestDto;
import it.linksmt.teamshare.entities.Type;

@Mapper
public interface TypeConverter {

	TypeConverter MAPPER = Mappers.getMapper(TypeConverter.class);
	
	List<TypeDto> toListTypeDTO(Iterable<Type> allType);

	TypeDto toTypeDTO(Type tipo);
	
	Type toType(TypeDto tipo);
	
	Type toType(TypeRequestDto tipo);
   
	
	
}
