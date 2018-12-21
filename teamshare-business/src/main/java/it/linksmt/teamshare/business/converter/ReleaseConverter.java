package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.ReleaseRequestDto;
import it.linksmt.teamshare.business.dtos.ReleaseDto;
import it.linksmt.teamshare.dao.entities.Release;

@Mapper
public interface ReleaseConverter {
	
	ReleaseConverter MAPPER = Mappers.getMapper(ReleaseConverter.class);

	List<ReleaseDto> toListReleaseDto(Iterable<Release> allRelease);

	ReleaseDto toReleaseDto(Release release);
	
	Release toRelease(ReleaseDto releaseDto);
	
	Release toRelease(ReleaseRequestDto releaseRequestDto);
}
