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

	List<UserTypeContentDto> toListUserTypeContentDTO(Iterable<UserTypeContent> allUserTypeContent);

	@Mappings({
		@Mapping(target = "idUser", source = "idUser.id"),
		@Mapping(target = "idType", source = "idType.id"),
		@Mapping(target = "idContent", source = "idContent.id")
	})
	UserTypeContentDto toUserTypeContentDTO(UserTypeContent userTypeContent);
	
	@Mappings({
		@Mapping(target = "idUser.id", source = "idUser"),
		@Mapping(target = "idType.id", source = "idType"),
		@Mapping(target = "idContent.id", source = "idContent")
	})
	UserTypeContent toUserTypeContent(UserTypeContentDto userTypeContentDto);
	
	@Mappings({
		@Mapping(target = "idUser.id", source = "idUser"),
		@Mapping(target = "idType.id", source = "idType"),
		@Mapping(target = "idContent.id", source = "idContent")
	})
	UserTypeContent toUserTypeContent(UserTypeContentRequestDto userTypeContentRequestDto);
}
