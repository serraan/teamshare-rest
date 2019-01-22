package it.linksmt.teamshare.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dtos.ContentDto;
import it.linksmt.teamshare.business.request.ContentRequestDto;
import it.linksmt.teamshare.entities.Content;

@Mapper
public interface ContentConverter {

	ContentConverter MAPPER = Mappers.getMapper(ContentConverter.class);

	List<ContentDto> toListaContentDTOResponse(List<Content> cont);

	@Mapping(target = "idUtenteCreatore", source = "utenteCreatore.id")
	ContentDto toContentDto(Content cont);

	@Mapping(target = "utenteCreatore.id", source = "idUtenteCreatore")
	Content toContent(ContentDto contDto);

	@Mapping(target = "utenteCreatore.id", source = "idUtenteCreatore")
	Content toContent(ContentRequestDto contRequestDto);
}
