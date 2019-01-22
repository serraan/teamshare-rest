package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.UserTypeContentRequestDto;
import it.linksmt.teamshare.business.dtos.UserTypeContentDto;
import it.linksmt.teamshare.dao.entities.UserTypeContent;

@Mapper
public interface UserTypeContentConverter {

	UserTypeContentConverter MAPPER = Mappers.getMapper(UserTypeContentConverter.class);

	List<UserTypeContentDto> toListUserTypeContentDto(Iterable<UserTypeContent> userTypeContents);

	@Mappings({
		@Mapping(target = "idUser", source = "user.id"),
		@Mapping(target = "idType", source = "type.id"),
		@Mapping(target = "idContent", source = "content.id")
	})
	UserTypeContentDto toUserTypeContentDto(UserTypeContent userTypeContent);

	@Mappings({
		@Mapping(target = "user.id", source = "idUser"),
		@Mapping(target = "type.id", source = "idType"),
		@Mapping(target = "content.id", source = "idContent")
	})
	UserTypeContent toUserTypeContent(UserTypeContentDto userTypeContentDto);

	@Mappings({
		@Mapping(target = "user.id", source = "idUser"),
		@Mapping(target = "type.id", source = "idType"),
		@Mapping(target = "content.id", source = "idContent")
	})
	UserTypeContent toUserTypeContent(UserTypeContentRequestDto userTypeContentRequestDto);
	
}
