package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.TypeRequestDto;
import it.linksmt.teamshare.business.dtos.TypeDto;
import it.linksmt.teamshare.dao.entities.Type;

@Mapper
public interface TypeConverter {

	TypeConverter MAPPER = Mappers.getMapper(TypeConverter.class);

	List<TypeDto> toListTypeDto(Iterable<Type> allType);
	
	TypeDto toTypeDto(Type type);
	Type toType(TypeDto typeDto);
	Type toType(TypeRequestDto typeRequestDto);
}
