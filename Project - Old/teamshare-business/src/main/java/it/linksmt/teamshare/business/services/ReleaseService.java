package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.ReleaseRequestDto;
import it.linksmt.teamshare.business.dtos.ReleaseDto;

public interface ReleaseService {

	public List<ReleaseDto> getReleases();

	public ReleaseDto getRelease(Integer id);

	public ReleaseDto addRelease(ReleaseRequestDto releaseRequestDto);

	public ReleaseDto updateRelease(Integer activityId, ReleaseRequestDto releaseRequestDto);

	public void deleteRelease(Integer id);
	
}
