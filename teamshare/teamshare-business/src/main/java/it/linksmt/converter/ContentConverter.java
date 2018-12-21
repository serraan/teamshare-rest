package it.linksmt.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dtos.ContentDto;
import it.linksmt.teamshare.business.request.ContentRequestDto;
import it.linksmt.teamshare.entities.Content;

@Mapper
public interface ContentConverter {
	ContentConverter MAPPER = Mappers.getMapper(ContentConverter.class);

	List<ContentDto> toListContentDTO(Iterable<Content> allContent);

	ContentDto toContentDTO(Content content);
	
	Content toContent(ContentDto contentDto);
	
	Content toContent(ContentRequestDto contentRequestDto);
}
