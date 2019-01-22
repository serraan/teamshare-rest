package it.linksmt.teamshare.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dtos.ReleaseDto;
import it.linksmt.teamshare.business.request.ReleaseRequestDto;
import it.linksmt.teamshare.entities.Release;



@Mapper
public interface ReleaseConverter {
	ReleaseConverter MAPPER = Mappers.getMapper(ReleaseConverter.class);

	List<ReleaseDto> toListReleaseDTO(Iterable<Release> allUser);

	ReleaseDto toReleaseDto(Release release);
	
	Release toRelease(ReleaseDto release);
	
	Release toRelease(ReleaseRequestDto release);
}
