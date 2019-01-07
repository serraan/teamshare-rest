package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.ContentRequestDto;
import it.linksmt.teamshare.business.dtos.ContentDto;
import it.linksmt.teamshare.dao.entities.Content;

@Mapper
public interface ContentConverter {

	ContentConverter MAPPER = Mappers.getMapper(ContentConverter.class);

	List<ContentDto> toListContentDto(List<Content> contents);

	@Mapping(target = "idUser", source = "user.id")
	ContentDto toContentDto(Content content);

	@Mapping(target = "user.id", source = "idUser")
	Content toContent(ContentDto contentDto);

	@Mapping(target = "user.id", source = "idUser")
	Content toContent(ContentRequestDto contentRequestDto);
	
}
